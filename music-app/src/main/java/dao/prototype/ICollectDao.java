package dao.prototype;

import java.util.List;

import entity.Collect;
import entity.Song;

public interface ICollectDao {

	//添加收藏歌曲
	void collectSong(int songId,int userId);
	
	//根据歌曲id删除收藏歌曲
	void deleteSong(int songId,int userId);
	
	//更新收藏歌曲
	void updateSong(Collect collect);
	
	//根据用户id查询收藏歌曲
	List<Song> findByUserId(int userId);
}
