package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IPlayRecordDao;
import entity.Play;
import entity.PlayRecord;
import entity.PlayRecordSong;
import util.DateUtil;

@Repository
public class PlayRecordSpringImpl implements IPlayRecordDao{
	@Autowired
	private JdbcTemplate jt;
	@Override
	public void addSongRecord(PlayRecord playRecord) {
		jt.update("insert into t_play_record(song_id,user_id,play_time) values(?,?,?)",playRecord.getSongId(),playRecord.getUserId(),DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"));	
		
	}

	@Override
	public void deleteMv(int playRecordid) {
		jt.update("delete from t_paly_record where id = ?",playRecordid);
		
	}

	@Override
	public List<PlayRecordSong> findById(int userId) {
		return  jt.query("SELECT a.* , b.play_time FROM t_song a JOIN t_play_record b ON a.id=b.song_id WHERE b.user_id= ?",
				new Object[] {userId},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
	}

	@Override
	public void updatePlayRecord(PlayRecord playRecord) {
		jt.update("update t_play_record from set song_id = ? , user_id  =? , play_time = ? where id = ?",playRecord.getSongId(),playRecord.getUserId(),DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"),playRecord.getId());	
	}

}
