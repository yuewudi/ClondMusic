package dao.prototype;

import java.util.List;

import entity.SongComment;
/**
 * 歌曲评论的dao
 * @author 刘昱
 *
 */
public interface ISongCommentDao {
	//--添加歌曲评论
	void addSongComment(SongComment songComment);
	//--通过id删除歌曲评论
	void deleteSongComment(int id);
	//--倒序查找所有歌曲评论
	List<SongComment> findAll();
	//--查找最后十条歌曲评论
		List<SongComment> findTen();
	//--通过id查找歌曲评论
	SongComment findById(int id);
	//--通过userId倒序查找歌曲评论
	List<SongComment> findByUserId(int userId);
	//--通过songId倒序查找歌曲评论
	List<SongComment> findBySongId(int songId);
	//--更新歌曲评论
	void updateSongComment(SongComment songComment);
}
