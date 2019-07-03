package dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IPlayDao;
import entity.Mv;
import entity.PlayRecord;
import entity.Play;
import util.DateUtil;

@Repository
public class PlaySpringImpl implements IPlayDao{
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void addPlay(Play play) {
		jt.update("insert into t_play(song_id,user_id) values(?,?)",play.getSongId(),play.getUserId());	
	}

	@Override
	public void deletePlay(int playid) {
		jt.update("delete from t_paly where id = ?",playid);		
	}

	@Override
	public void updatePlay(Play play) {
		jt.update("update t_play from set song_id = ? where id = ?",play.getSongId(),play.getId());	
	}


	@Override
	public int findPlayCount() {
		return jt.queryForObject("select count(*) from t_play",Integer.class);
	}

	@Override
	public int findBySongId(int songId) {
		return jt.queryForObject("select count(*) from t_play where song_id = ?",Integer.class,songId);
	}

}
