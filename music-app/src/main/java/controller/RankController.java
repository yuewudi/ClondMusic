package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import entity.PlayRecord;
import entity.PlayRecordSong;
import entity.Song;
import entity.User;
import service.prototype.IPlayRecordService;
import service.prototype.ISongCommentService;
import service.prototype.ISongService;
import util.DateUtil;

@Controller
public class RankController {

	@Autowired
	private ISongService songService;
	@Autowired
	private IPlayRecordService playRecordService;
	
	@Autowired 
	private ISongCommentService songCommentService;
	
	@RequestMapping("/rank")
	public ModelAndView rank(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("rank");
		User user =(User)req.getSession().getAttribute("user");
		String today=DateUtil.formate(new Date(), "MM月dd日");
		List<PlayRecordSong> newHotSongs=playRecordService.findSongAndCountInWeekLimitHundred();
		long newHotSongsCount=0;
		for(PlayRecordSong newHotSong:newHotSongs) {
			newHotSongsCount+=playRecordService.findCountBySongIdInWeek(newHotSong.getId());
		}
		List<PlayRecordSong> hotSongs=playRecordService.findSongAndCountLimitHundred();
		long hotSongsCount=0;
		for(PlayRecordSong hotSong:hotSongs) {
			hotSongsCount+=playRecordService.findCountBySongId(hotSong.getId());
		}
		
		List<Song> originalSongs = songService.findByTypeId(6);
		long originalSongsCount=0;
		for(Song originalSong:originalSongs) {
			originalSongsCount+=playRecordService.findCountBySongId(originalSong.getId());
		}

		List<Song> newSongs = songService.newSong();
		long newSongsCount=0;
		for(Song newSong:newSongs) {
			newSongsCount+=playRecordService.findCountBySongId(newSong.getId());
		}

		mv.addObject("newHotSongs",newHotSongs);
		mv.addObject("newHotSongsCount",newHotSongsCount);
		mv.addObject("hotSongs",hotSongs);
		mv.addObject("hotSongsCount",hotSongsCount);
		mv.addObject("today",today);
		mv.addObject("originalSongs",originalSongs);
		mv.addObject("originalSongsCount",originalSongsCount);
		mv.addObject("newSongs",newSongs);
		mv.addObject("newSongsCount",newSongsCount);
		
		return mv;
	}
}
