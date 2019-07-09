package config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016100100640822";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDUPY9UkpbaUWq7TAKLgRkDW/yFEMQkEMuV/IRiCsoynzi3Hpfq1tck/4u2d20awibPdQApEne8pxNkHxEyDRlYgAN/MjlAnIf/ZjoY+lnlHBaVgiOxng+TYosSb0ZqE4HBDi7MT/dIN9Y9YOHJOMgLg7enaK8a8/BK90GGQzkPU5RfdIA6B/jNGF13BeD/iMu11bkgmcU56cl6K0CJb2RdIKMlWG+WlzgTuMJwqquJQsO13U7HFshhAF4bytVnHKvXTitECJ5mqqvnHFV4Wau3FSBq6n+IsOuh6Eo5c165B46EIeTJLerHnNxVmjsW22W6rL1QjIuvahiLEHQ9c1wZAgMBAAECggEBAJQu6uy0cGi7YZalij1WhF1JEzTgsOExbMMqjE9bkzLm4hVQYecP2yS02xoppd6B4dEEsnj6sOjhifNkkX/tj12v+0EKktiesYFLIZMg8DS7eLUoKL2xStSvf8P+Nx6GwhhFS71Qs6kTexxdkScJ4vnPHCHhQCjEWmgs2+3e727XuXY1B6bE64hYWnes/GlQ5/is8JuNcMhS5HLFiVU4n4vrYAUer/p60E4q/ShWau2gHOn0Y4a6jIKY3lxbsSTWLnygghjHkA8Bgs39Nqgv61egHMuzSScRLRK1D58VIW6bENvWg1P/F7fZUsb/ULAz6L8NMmQKD3ZL13HWsGudT4ECgYEA7hhptt/lrxNRDbrNfSpwUgMwailOXaRg1InQMKtBOqtvtPHHgAmxCScylgo6+2EiuWwqZGO8GM/wcNK36q3af4JT5VOoUwTD7sdXIczOuJY98PrO3fDfF0aseG4TeSlSfwK6GCDlj4bfzzs7+W4gLiAufYlZejTrx1MdaECDOfECgYEA5DNptU6gvUXmeETqMPxEt5ynNvYvv28/Be0u/crjyYoQVTcXrgBIA8KmtIkxgZ6Co7I3/ui41VMwAICRcgku/4H4h3gLsmJ1Ji9/Q3kbt5MRBY5293n2z2fZYK2ziSMfAwNNhRYPl+8iBapu3Q/sbdnCWKJmb8meXCcL/hJ33KkCgYA360Poz20CUWcX8meQngcDO/yC8nCVTaXwRO3AgHgxb1ItDRvt1ljd7XbUBlMT9xxQsDbEnSfwK+YsmVDYrTxD9jf+BEfkN5pM2kR8i72BXMfvcPhk5819ifu3zSKFsk7NxbYvNIq1yteFtEPBsTudmbFRipCZQxSdG8gsU/p+AQKBgErntWMWFB0MvMHtnRHHPKcofJrF5JZp5b4ERNB5sJuO/h16oAM1hG33jtDj16Q8a5VgApFhwooDbFY93YAZE5w7BWEyPmSnfNyz6oozTq3LUGMKiHJjTmh2Jhxd5/iz1pIem2t7+lJc5EYH06wsdeb4+5osdINtItYM2xri5QVBAoGBALRy2NZgFQpoKsXGjmP+Pmg3Es2dpRwa9ozhr6staMcU1HIw6G36bcc0GfmGyWYb/3aDLvNDPZYfHwRfqX5h/xQbxh+hNjjAWfeLg31qTDRzYgDh6BQAArVvGtnz30FXiT85kJ32D/4ldN3l5MrwOJFO5VJr7ft2pj09ejlh7lm2";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgOvjOHq+I7+Ax/tJ0bwjxSSqWT5cZJ/Bq+KSPhi3lJ0NH4cvzywZ/Cb+zr2JT5JCUXo/C25+J0g+ykcV6LrAI0SXhwswJpD3Qu9BDPiQ4X2ey1Twmv5FuLO+YWnlrEST8/8yYXjXTZ1EOoJwk6XQglTTA0ve20Hcc31u8k9CpkxMEeVqWFBMx/ql0xZFyjd4RPJBF+8GP4n9LoyP0M7g+xvcYlVmsQZ7YBwYNdNaZpNgJtVCXZ1KGVPma/U5K8uFixvpJersfryZxF7ldJlR3XBTd2D8KtPBBuUD60lf1aTfu9FfSk2DT0h09uOSS9qTgSCKYFoeB1Wn7HLNfhDAtQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://liuyu.frpgz1.idcfengye.com/music/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://liuyu.frpgz1.idcfengye.com/music/return";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	// 支付宝网关
	public static String log_path = "D:\\\\cloudMusic\\\\alipay\\\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

