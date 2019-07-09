package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import config.AlipayConfig;
import entity.User;
import entity.Vip;
import service.impl.VipServiceDaoImpl;
import service.prototype.IUserService;
import service.prototype.IVipService;
import util.DateUtil;

@Controller
public class VipController {

	@Autowired
	private IVipService vipService;
	@Autowired
	private IUserService userService;
	
	private ModelAndView mv = new ModelAndView();
	
	
	//进入vip充值页面
	@RequestMapping("/vip")
	public ModelAndView vip(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		mv.setViewName("vip");
		resp.setContentType("text/html; charset=utf-8");
		User user =(User)req.getSession().getAttribute("user");
		int vipStatus = 0;
		String endTime = null;
		if(user==null) {
			PrintWriter out = resp.getWriter();
			out.print("<script language=\"javascript\">alert('身份过期了，你需要重新登陆！');window.location.href='/music/index'</script>");
			return null;
		}else {
			Vip vip=vipService.findVipByUserId(user.getId());
			if (vip==null) {
				vipStatus=0;
			}else {
				vipStatus=1;
				endTime=DateUtil.formate(vip.getEnd_time(),"yyyy-MM-dd HH:mm:ss");
			}
			req.setAttribute("vipStatus",vipStatus);
			req.setAttribute("endTime",endTime);
			return mv;	
		}
		
	}

	@RequestMapping("/gopay")
	public void goPay(HttpServletRequest req,HttpServletResponse resp) throws AlipayApiException, IOException {
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		 //随机生成一位整数
        int random = (int) (Math.random()*9+1);
        String valueOf = String.valueOf(random);
        //生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        //可能为负数
        if(hashCode<0){
            hashCode = -hashCode;
        }
        String value = valueOf + String.format("%015d", hashCode);
        String userId = req.getParameter("userId");
		//商户订单号，商户网站订单系统中唯一订单号，必填
		//String out_trade_no = new String(req.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		String out_trade_no =userId+","+value;
		//付款金额，必填
		String total_amount = req.getParameter("amount");
		//String total_amount = "15";
		//订单名称，必填
		String subject = req.getParameter("subject");
		//String subject ="优逸云音乐会员1个月";
		//商品描述，可空
		String body =req.getParameter("body");
		//String body ="会员有效期内可以畅听全站歌曲";
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
		//		+ "\"total_amount\":\""+ total_amount +"\"," 
		//		+ "\"subject\":\""+ subject +"\"," 
		//		+ "\"body\":\""+ body +"\"," 
		//		+ "\"timeout_express\":\"10m\"," 
		//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
		
		//请求
		String head="<html><head><meta http-equiv='Content-Type'	content='text/html; charset=utf-8'></head>";
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		String buttom="<body></body></html>";
		//输出
		resp.getWriter().println(head+result+buttom);
	}
	@RequestMapping("/return")
	public void returnUrl(HttpServletRequest req,HttpServletResponse resp) throws AlipayApiException, IOException {
	
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = req.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			System.out.println("Return 验签成功！");
			//商户订单号
			String out_trade_no = new String(req.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(req.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//付款金额
			String total_amount = new String(req.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			
			String[] strArr = out_trade_no.split(",");
			String userId=strArr[0];
			 int id = Integer.parseInt(userId);
			 String name=userService.findById(id).getNickName();
			String head="<html><head><meta http-equiv='Content-Type'	content='text/html; charset=utf-8'></head><body><center>";
			String result =" <br> <br> <br> <br> <br> <br>"+name+",您已经成功支付"+total_amount+"元, <br>关闭本页面，刷新原网页即可看到会员状态!";
			String buttom="</center></body></html>";
			//输出
			resp.getWriter().println(head+result+buttom);
		}else {
			resp.getWriter().println("验签失败");
		}
	}
	@RequestMapping("/notify")
	public void notifyUrl(HttpServletRequest req,HttpServletResponse resp) throws IOException, AlipayApiException {
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = req.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		
		/* 实际验证过程建议商户务必添加以下校验：
		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		4、验证app_id是否为该商户本身。
		*/
		if(signVerified) {//验证成功
			System.out.println("Notify 验签成功!");
			//商户订单号
			String out_trade_no = new String(req.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(req.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//付款金额
			String total_amount = new String(req.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			//交易状态
			String trade_status = new String(req.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			
			if(trade_status.equals("TRADE_FINISHED")){
				System.out.println("TRADE_FINISHED 执行");
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
					
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				System.out.println("TRADE_SUCCESS 执行");
				String[] strArr = out_trade_no.split(",");
				String userId=strArr[0];
				 int id = Integer.parseInt(userId);
				 switch(total_amount) {
				 case "15.00":
						vipService.rechargeVip(id, 1);
						break;
				 case "40.00":
						vipService.rechargeVip(id, 3);
						break;
				 case "75.00":
						vipService.rechargeVip(id, 6);
						break;
				 case "138.00":
						vipService.rechargeVip(id, 12);
						break;
				 }
				
				
			}
			 
			resp.getWriter().println("success");
			
		}else {//验证失败
			resp.getWriter().println("fail");
			System.out.println("Notify 验签失败!");
			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}
		
		//——请在这里编写您的程序（以上代码仅作参考）——
	}
	
}