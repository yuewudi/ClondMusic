package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IMvCommentDao;
import entity.MvComment;
import util.DateUtil;

@Repository
public class MvCommentSpringImpl implements IMvCommentDao{
	
	@Autowired
	private JdbcTemplate jt;
	//--添加视频评论
	@Override
	public void addMvComment(MvComment mvComment) {
		jt.update(
				"insert into t_mv_comment(user_id,mv_id,comment_time,content) "
				+ "values(?,?,?,?)",
				mvComment.getUserId(),mvComment.getMvId(),DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"),mvComment.getContent());
	}
	//--通过id删除视频评论
	@Override
	public void deleteMvComment(int id) {
		jt.update("delete from t_mv_comment = ?", id);
	}
	//--倒序查找所有视频评论
	@Override
	public List<MvComment> findAll() {
		return jt.query("select * from t_mv_comment order by comment_time desc",
				new BeanPropertyRowMapper<MvComment>(MvComment.class));
	}
	//--查找最后十条视频评论
	@Override
	public List<MvComment> findTen() {
		return jt.query("select * from t_mv_comment order by comment_time desc limit 10",
				new BeanPropertyRowMapper<MvComment>(MvComment.class));
	}
	//--通过id查找视频评论
	@Override
	public MvComment findById(int id) {
		return jt.queryForObject("select * from t_mv_comment where id=?", 
				new Object[] {id},
				new BeanPropertyRowMapper<MvComment>(MvComment.class));
	}
	//--通过userId倒序查找视频评论
	@Override
	public List<MvComment> findByUserId(int userId) {
		return jt.query("select * from t_mv_comment where user_id= ? order by comment_time desc", 
				new Object[] {userId},
				new BeanPropertyRowMapper<MvComment>(MvComment.class));
	}
	//--通过mvId倒序查找视频评论
	@Override
	public List<MvComment> findByMvId(int mvId) {
		return jt.query("select * from t_mv_comment where mv_id = ? order by comment_time desc", 
				new BeanPropertyRowMapper<MvComment>(MvComment.class),mvId);
	}
	//--更新视频评论
	@Override
	public void updateMvComment(MvComment mvComment) {
		jt.update(
				"update t_mv_comment set "
				+ "user_id=?,mv_id=?,content=?"
				+ "where id=?",
				new Object[]{
						mvComment.getUserId(),
						mvComment.getMvId(),
						mvComment.getContent(),
						mvComment.getId()
		});
	}

}
