package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.PlayRecordSong;
import entity.Song;
import entity.User;
import service.prototype.IPlayRecordService;
import service.prototype.ISongService;
import service.prototype.IUserService;

@Controller
public class UserController {
	@Autowired
	private IPlayRecordService playRecordService;
	@Autowired
	private ISongService songService;
	
	@Autowired
	private IUserService userService;
	ModelAndView mv =null;
	private User user=null;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		mv = new ModelAndView();
		mv.setViewName("index");
		List<PlayRecordSong> newHotSongs10=playRecordService.findSongAndCountInWeekLimitTen();
		List<PlayRecordSong> newHotSongs8=new ArrayList<PlayRecordSong>();
		for(int i=0;i<8;i++) {
			newHotSongs8.add(newHotSongs10.get(i));
		}
		List<Song> originalSongs = songService.findByTypeId(6);

	

		List<Song> newSongs = songService.newSong();
		List<Song> newSongs10=new ArrayList<Song>();
		for(int i=0;i<10;i++) {
			newSongs10.add(newSongs.get(i));
		}
		mv.addObject("newHotSongs8",newHotSongs8);
		mv.addObject("newHotSongs10",newHotSongs10);
		mv.addObject("originalSongs",originalSongs);
		mv.addObject("newSongs10",newSongs10);
		return mv;
	}
	
	@RequestMapping(value ="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req,HttpServletResponse resp){
		String account = req.getParameter("userNumber");
		if(!account.equals("请输入账号")){
			System.out.println(account);
			String password = req.getParameter("password");
			System.out.println(password);
			List<User> user = userService.findByAccount(account);	
			System.out.println(user);
			mv=new ModelAndView();
			if(user.size()==0){			
				String erro="用户名不存在";
				String display = "block";
				mv.addObject("display",display);
				mv.addObject("erro", erro);
				mv.setViewName("index");
				return mv;
				
			}else if(user.get(0).getPassword().equals(password)){
				String block = "block";
				mv.addObject("block",block);
				String none = "none";
				mv.addObject("none",none);
				List<PlayRecordSong> newHotSongs10=playRecordService.findSongAndCountInWeekLimitTen();
				List<PlayRecordSong> newHotSongs8=new ArrayList<PlayRecordSong>();
				for(int i=0;i<8;i++) {
					newHotSongs8.add(newHotSongs10.get(i));
				}
				List<Song> originalSongs = songService.findByTypeId(6);

			

				List<Song> newSongs = songService.newSong();
				List<Song> newSongs10=new ArrayList<Song>();
				for(int i=0;i<10;i++) {
					newSongs10.add(newSongs.get(i));
				}
				mv.setViewName("index");
				mv.addObject("newHotSongs8",newHotSongs8);
				mv.addObject("newHotSongs10",newHotSongs10);
				mv.addObject("originalSongs",originalSongs);
				mv.addObject("newSongs10",newSongs10);
				req.getSession().setMaxInactiveInterval(60*30);
				req.getSession().setAttribute("block",block);
				req.getSession().setAttribute("none",none);
				req.getSession().setAttribute("user", user.get(0));
				return mv;
			}else{
				String nopass="密码不正确";
				
				String display = "block";
				mv.addObject("display",display);
				mv.addObject("nopass", nopass);
				mv.setViewName("index");
				return mv;
			}
		}else{
			account = req.getParameter("account");
			List<User> users = userService.findByAccount(account);
			System.out.println(user);
			List<PlayRecordSong> newHotSongs10=playRecordService.findSongAndCountInWeekLimitTen();
			List<PlayRecordSong> newHotSongs8=new ArrayList<PlayRecordSong>();
			for(int i=0;i<8;i++) {
				newHotSongs8.add(newHotSongs10.get(i));
			}
			List<Song> originalSongs = songService.findByTypeId(6);

		

			List<Song> newSongs = songService.newSong();
			List<Song> newSongs10=new ArrayList<Song>();
			for(int i=0;i<10;i++) {
				newSongs10.add(newSongs.get(i));
			}
			if(users.size()==0){
				System.out.println(account);
				String pwd = req.getParameter("pwd");
				System.out.println(pwd);
				user = new User();
				user.setcreate_date(new Date());
				user.setHeader("assets/images/header.jpg");
				user.setAccount(account);
				
				user.setPassword(pwd);
				userService.addUser(user);
				mv = new ModelAndView("loginSuccess");
				req.getSession().setAttribute("user", user);
				mv.addObject("newHotSongs8",newHotSongs8);
				mv.addObject("newHotSongs10",newHotSongs10);
				mv.addObject("originalSongs",originalSongs);
				mv.addObject("newSongs10",newSongs10);
				return mv;
			}else{
				String already="用户名已存在";
				String display = "block";
				mv.addObject("display",display);
				String sign = display;
				mv.addObject("sign",sign);
				String login = "none";
				mv.addObject("login",login);	
				mv.addObject("already", already);
				mv.setViewName("index");
				mv.addObject("newHotSongs8",newHotSongs8);
				mv.addObject("newHotSongs10",newHotSongs10);
				mv.addObject("originalSongs",originalSongs);
				mv.addObject("newSongs10",newSongs10);
				return mv;
			}
			
			
		}
		
		
		
	}
	
	
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest req,HttpServletResponse resp){
		
		mv = new ModelAndView();
		req.getSession().removeAttribute("user");
		req.getSession().invalidate();
		String block = "none";
		mv.addObject("block",block);
		String none = "block";
		mv.addObject("none",none);
		List<PlayRecordSong> newHotSongs10=playRecordService.findSongAndCountInWeekLimitTen();
		List<PlayRecordSong> newHotSongs8=new ArrayList<PlayRecordSong>();
		for(int i=0;i<8;i++) {
			newHotSongs8.add(newHotSongs10.get(i));
		}
		List<Song> originalSongs = songService.findByTypeId(6);

	

		List<Song> newSongs = songService.newSong();
		List<Song> newSongs10=new ArrayList<Song>();
		for(int i=0;i<10;i++) {
			newSongs10.add(newSongs.get(i));
		}
		mv.setViewName("index");
		mv.addObject("newHotSongs8",newHotSongs8);
		mv.addObject("newHotSongs10",newHotSongs10);
		mv.addObject("originalSongs",originalSongs);
		mv.addObject("newSongs10",newSongs10);
		return mv;
	}


}
