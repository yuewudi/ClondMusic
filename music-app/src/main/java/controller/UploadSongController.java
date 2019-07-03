package controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import entity.Sms;
import entity.Song;
import entity.Type;
import entity.User;
import service.prototype.ICollectService;
import service.prototype.IPlayRecordService;
import service.prototype.ISongService;
import service.prototype.ITypeService;
import service.prototype.IUserService;
import sms.JavaSmsApi;

@Controller
public class UploadSongController {
	
	@Autowired
	private ITypeService typeService;
	
	
	@Autowired
	private ISongService songService;
	
	private ModelAndView mv= new ModelAndView();
	
	
	@RequestMapping("/uploadSong")
	public ModelAndView uploadSong(HttpServletRequest req,HttpServletResponse resp){
		List<Type> types=typeService.findAll();
		mv.setViewName("uploadSong");
		mv.addObject("types",types);
		return mv;
	}
	
	@RequestMapping(value="/getSong",method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getSong(@RequestParam(value = "songFile", required = false) MultipartFile songFile,@RequestParam(value = "songImgFile", required = false) MultipartFile songImgFile,HttpServletRequest req,HttpServletResponse resp) {
		User user = (User)req.getSession().getAttribute("user");
	
		 System.out.println(user);
		 try {
			 File desSongFile=new File("src/main/webapp/assets/music/"+songFile.getOriginalFilename());
				FileUtils.writeByteArrayToFile(desSongFile,songFile.getBytes());
			File desSongImgFile=new File("src/main/webapp/assets/images/song-imgs/"+songImgFile.getOriginalFilename());
				FileUtils.writeByteArrayToFile(desSongImgFile,songImgFile.getBytes());
			    Map<String,String> map = new HashMap<String,String>();
				map.put("songUrl", "assets/music/"+songFile.getOriginalFilename());
			    map.put("songImage", "assets/images/song-imgs/"+songImgFile.getOriginalFilename());
				JSONObject obj = new JSONObject(map); 
				
				return obj.toString();
			} catch (IOException e) {
				e.printStackTrace();
				return "f";
			}
		 

	}

	@RequestMapping(value="/addSong",method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String addSong(HttpServletRequest req,HttpServletResponse resp){
		User user = (User)req.getSession().getAttribute("user");
		String songName = req.getParameter("songName");
		String songAuthor = req.getParameter("songAuthor");
		int typeId = Integer.parseInt(req.getParameter("typeId"));
		String songUrl = req.getParameter("songUrl");
		String songImage = req.getParameter("songImage");
		String songWords = req.getParameter("songWords");
		String description = req.getParameter("description");
		String songTime = req.getParameter("songTime");
		int uploaderId=user.getId();
		Song song=new Song();
		song.setSongName(songName);
		song.setSongAuthor(songAuthor);
		song.setTypeId(typeId);
		song.setSongUrl(songUrl);
		song.setSongImage(songImage);
		song.setSongWords(songWords);
		song.setDescription(description);
		song.setSongTime(songTime);
		song.setUploaderId(uploaderId);
		System.out.println(song);
		songService.addSong(song);
		
		String data="发布成功";
		return data;
	}
	
	
	

}
