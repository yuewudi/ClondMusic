package dao.prototype;

import java.util.List;

import entity.Song;

public interface ISongDao {

	//添加歌曲
	void addSong(Song song);
	
	//根据id查歌曲
	Song searchSong(int id);

	//根据关键字查找歌曲
	List<Song> searchLikeSong(String key);
	
	//删除歌曲
	void deleteSong(Song song);
	
	//修改歌曲信息
	void updateSong(Song song);
	
	
	//根据类型查找歌曲
	List<Song> findByTypeId(int typeId);
	
	//查询全部歌曲
	List<Song> findAll();
}
