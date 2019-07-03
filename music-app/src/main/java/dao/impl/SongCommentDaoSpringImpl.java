package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.ISongCommentDao;
import entity.SongComment;
import util.DateUtil;
/**
 * 歌曲评论的dao实现
 * @author 刘昱
 *
 */
@Repository
public class SongCommentDaoSpringImpl implements ISongCommentDao{
	
	@Autowired
	private JdbcTemplate jt;
	//--添加歌曲评论
	@Override
	public void addSongComment(SongComment songComment) {
		jt.update(
				"insert into t_song_comment(user_id,song_id,comment_time,content) "
				+ "values(?,?,?,?)",
				songComment.getUserId(),songComment.getSongId(),DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"),songComment.getContent());
	}
	//--通过id删除歌曲评论
	@Override
	public void deleteSongComment(int id) {
		jt.update("delete from t_song_comment where id = ?", id);
	}
	//--倒序查找所有歌曲评论
	@Override
	public List<SongComment> findAll() {
		return jt.query("select * from t_song_comment order by comment_time desc",
				new BeanPropertyRowMapper<SongComment>(SongComment.class));
	}
	//--查找最后十条歌曲评论
	@Override
	public List<SongComment> findTen() {
		return jt.query("select * from t_song_comment order by comment_time desc limit 10",
				new BeanPropertyRowMapper<SongComment>(SongComment.class));
	}
	//--通过id查找歌曲评论
	@Override
	public SongComment findById(int id) {
		return jt.queryForObject("select * from t_song_comment where id=?", 
				new Object[] {id},
				new BeanPropertyRowMapper<SongComment>(SongComment.class));
	}
	//--通过userId倒序查找歌曲评论
	@Override
	public List<SongComment> findByUserId(int userId) {
		return jt.query("select * from t_song_comment where user_id=? order by comment_time desc", 
				new Object[] {userId},
				new BeanPropertyRowMapper<SongComment>(SongComment.class));
	}
	//--通过songId倒序查找歌曲评论
	@Override
	public List<SongComment> findBySongId(int songId) {
		return jt.query("select * from t_song_comment where song_id=? order by comment_time desc", 
				new Object[] {songId},
				new BeanPropertyRowMapper<SongComment>(SongComment.class));
	}
	//--更新歌曲评论
	@Override
	public void updateSongComment(SongComment songComment) {
		jt.update(
				"update t_song_comment set "
				+ "user_id=?,song_id=?,content=?"
				+ "where id=?",
				new Object[]{
						songComment.getUserId(),
						songComment.getSongId(),
						songComment.getContent(),
						songComment.getId()
		});
	}


}
