package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Song;
import service.prototype.ICollectService;

@Controller
public class MyMusicController {
	
	
	@Autowired
	private ICollectService collectSerice;
	
	//进入我的音乐
	@RequestMapping(value = "/myMusic")
	public ModelAndView myMusic(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();
		String userId = req.getParameter("userid");
		
		List<Song> songs = collectSerice.fingByUserId(Integer.parseInt(userId));
		List nums = new ArrayList();
		for (int i = 0; i < songs.size(); i++) {
			nums.add(i+1);
		}
		req.setAttribute("songs",songs);
		req.setAttribute("nums",nums);
		mv.setViewName("myMusic");
		return mv;
	}


}
