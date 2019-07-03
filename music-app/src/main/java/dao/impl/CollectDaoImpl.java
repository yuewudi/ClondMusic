package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.prototype.ICollectDao;
import entity.Collect;
import entity.Song;

@Repository
public class CollectDaoImpl implements ICollectDao{
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<Song> findByUserId(int userId) {
		RowMapper<Song> rowMapper = new BeanPropertyRowMapper<Song>(Song.class);
		String sql = "select s.* from t_collect c left join t_song s on c.song_id = s.id where user_id="+userId;
		return jt.query(sql, rowMapper);
	}

	@Override
	public void collectSong(int songId,int userId) {
		// TODO Auto-generated method stub
		jt.update("insert into t_collect(user_id,song_id,collect_time) values (?,?,?)",userId,songId,new Date());
	}

	@Override
	public void deleteSong(int songId,int userId) {
		// TODO Auto-generated method stub
		jt.update("delete from t_collect where song_id = ? and user_id=?",songId,userId);
	}

	@Override
	public void updateSong(Collect collect) {
		// TODO Auto-generated method stub
		jt.update("update t_collect set user_id = ?,song_id = ?,collect_time = ? where id=?",collect.getUserId(),collect.getSongId(),collect.getCollect_time(),collect.getId());
	}

}
