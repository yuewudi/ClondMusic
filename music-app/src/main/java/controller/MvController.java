package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Mv;
import entity.MvComment;
import entity.User;
import service.prototype.IMvCommenService;
import service.prototype.IMvService;
import service.prototype.IUserService;

@Controller
public class MvController {

	@Autowired
	private IMvService mv;
	@Autowired
	private IUserService user;
	@Autowired
	private IMvCommenService mvCommenService;

	ModelAndView mav = null;

	//进入热门视频

	@RequestMapping("/MV")
	public ModelAndView mv() {

		mav = new ModelAndView();

		List<Mv> mvs = mv.searchMvAll();
		mav.getModel().put("mvs", mvs);
		List<User> users = new ArrayList<>();
		int i = 1;
		List<List<MvComment>> mcss = new ArrayList<>();
		List<List<User>> mcuserss = new ArrayList<>();
		for (Mv mv : mvs) {
			List<MvComment> mcs = mvCommenService.findByMvId(mv.getId());
			List<User> mcusers = new ArrayList<>();
			for (MvComment mvComment : mcs) {
				User us = user.findById(mvComment.getUserId());
				mcusers.add(us);
			}
			mcss.add(mcs);
			User us = user.findById(i);
			System.out.println(us);
			i++;
			mcuserss.add(mcusers);
			users.add(us);
		}

		mav.getModel().put("users", users);
		mav.getModel().put("mcuserss", mcuserss);
		mav.getModel().put("mcss", mcss);
		mav.setViewName("mv");

		return mav;
	}

}
