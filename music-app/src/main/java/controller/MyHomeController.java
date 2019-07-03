package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Sms;
import entity.User;
import service.prototype.IUserService;
import sms.JavaSmsApi;

@Controller
public class MyHomeController {
	
	@Autowired
	private IUserService userService;
	
	private ModelAndView mv= new ModelAndView();
	
	//进去个人中心
	@RequestMapping("/myHome")
	public ModelAndView myHome(HttpServletRequest req,HttpServletResponse resp){
		
		User user =(User)req.getSession().getAttribute("user");
		
		mv.setViewName("myhome");
		
		return mv;
	}
	
	
	//更新资料
	@RequestMapping("/edit")
	public ModelAndView edit(){
		mv.setViewName("edit");
		return mv;
	}
	
	//保存修改的个人资料
	@RequestMapping(value="/save",method=RequestMethod.POST)
	
	public void save(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		PrintWriter pw = resp.getWriter();
		String nickName = req.getParameter("nickName");
		System.out.println(nickName);
		String description = req.getParameter("description");
		String flag = req.getParameter("sex");
		User user = (User)req.getSession().getAttribute("user");
		user.setNickName(nickName);
		user.setDescription(description);
		user.setSex(Boolean.parseBoolean(flag));
		userService.updateUser(user);
		resp.setContentType("test/javascript;charset=utf-8");
		String success = "添加成功";

		pw.write(success);
		
	}
	
	//绑顶手机
	@RequestMapping("/bind")
	public ModelAndView bind(){
		mv.setViewName("bind");
		return mv;
	}
	
	
	//发送验证码
	@RequestMapping(value="/Sms",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView Sms(HttpServletRequest req,HttpServletResponse resp){
		String mobile = req.getParameter("phone");
		System.out.println(mobile);
		Sms sms = new Sms();
		sms.setMobile(mobile);
		
		JavaSmsApi javaSmsApi = new JavaSmsApi();
		try {
			String sendSms = javaSmsApi.sendSms(sms);
			req.getSession().setAttribute("sendSms", sendSms);
			req.getSession().setAttribute("mobile", mobile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return mv;
	}
	
	//验证验证码
	@RequestMapping(value="/SmsCode",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView SmsCode(HttpServletRequest req,HttpServletResponse resp){
		String code = req.getParameter("code");
		System.out.println(code);

		String senedSms =(String) req.getSession().getAttribute("sendSms");
		String mobile =(String) req.getSession().getAttribute("mobile");
		User user = (User)req.getSession().getAttribute("user");
		if(senedSms.equals(code)){
			user.setPhone(Integer.parseInt(mobile));
			userService.updateUser(user);
			req.getSession().removeAttribute("sendSms");
			req.getSession().removeAttribute("mobile");
			mv.addObject("success",true);
			req.setAttribute("succ", "添加成功");
		}else{
			
		}
		return mv;
	}
	
	
	
	
	

}
