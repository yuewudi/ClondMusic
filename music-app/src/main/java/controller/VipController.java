package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VipController {

	private ModelAndView mv = new ModelAndView();
	
	//进入vip充值页面
	@RequestMapping("/vip")
	public ModelAndView vip(){
		
		mv.setViewName("vip");
		
		return mv;
	}
}
