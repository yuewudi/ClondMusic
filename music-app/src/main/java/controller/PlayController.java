package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import entity.Play;
import entity.PlayRecord;
import entity.Song;
import entity.SongComment;
import entity.SongCommentDTO;
import entity.User;
import service.prototype.IPlayRecordService;
import service.prototype.IPlayService;
import service.prototype.ISongCommentService;
import service.prototype.ISongService;
import service.prototype.IUserService;

@RestController
public class PlayController {
	
	@Autowired
	private ISongService songService;
	
	@Autowired
	private ISongCommentService songCommentService;
	@Autowired
	private IUserService userService;
	
	@Autowired 
	private IPlayService playService;
	
	@Autowired
	private IPlayRecordService playRecordService;
 
	
	ModelAndView mv=new ModelAndView();
	
	
	
	//进入播放页面
	@RequestMapping(value = "/play",method=RequestMethod.GET)
	public ModelAndView nowPlay(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
		String songid = req.getParameter("songId");
		int songId = Integer.parseInt(songid);
		Song song = songService.searchSong(songId);
		User user = (User)req.getSession().getAttribute("user");
		if(user==null) {
			user=new User();
		}
		//添加正在播放
		Play play = new Play();
		play.setSongId(songId);
		play.setUserId(user.getId());	 
		playService.addPlay(play);
		//添加播放记录
		PlayRecord pr = new PlayRecord();
		pr.setUserId(user.getId());
		pr.setSongId(songId);
		playRecordService.addSongRecord(pr);
		
		req.setCharacterEncoding("utf-8");
		
		
		List<SongComment> songComments = songCommentService.findBySongId(songId);
		List<SongCommentDTO> scDTOs = new ArrayList<SongCommentDTO>();
		for (SongComment songComment : songComments) {
			System.out.println(songComment);
			SongCommentDTO scDTO = new SongCommentDTO();
			user = userService.findById(songComment.getUserId());
			System.out.println(user);
			scDTO.setSongComment(songComment);
			scDTO.setUser(user);
			scDTOs.add(scDTO);
		}

		mv.addObject("scDTOs",scDTOs);
		
		mv.addObject("song",song);
		
		mv.setViewName("play");
		return mv;
	}

}
