package service.prototype;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Song;
import entity.User;



public interface ICollectService {

	
	//根据用户id查询收藏歌曲
	List<Song> fingByUserId(int userId);
	
	//添加收藏歌曲
	void addCollect(Song song,User user);
	
	//删除收藏的歌曲
	void deleteCollect(Song song,User user);
	
	
}
