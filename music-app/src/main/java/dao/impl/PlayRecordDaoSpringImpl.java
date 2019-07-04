package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IPlayRecordDao;
import entity.PlayRecord;
import entity.PlayRecordSong;
import util.DateUtil;

@Repository
public class PlayRecordDaoSpringImpl implements IPlayRecordDao{
	@Autowired
	private JdbcTemplate jt;
	@Override
	public void addSongRecord(PlayRecord playRecord) {
		jt.update("insert into t_play_record(song_id,user_id,play_time) values(?,?,?)",playRecord.getSongId(),playRecord.getUserId(),DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"));	
		
	}

	@Override
	public void deleteMv(int id) {
		jt.update("delete from t_paly_record where id = ?",id);
		
	}

	@Override
	public void updatePlayRecord(PlayRecord playRecord) {
		jt.update("update t_play_record from set song_id = ? , user_id  =? , play_time = ? where id = ?",playRecord.getSongId(),playRecord.getUserId(),DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"),playRecord.getId());	
	}

	@Override
	public List<PlayRecordSong> findSongAndCountByUserId(int userId) {
		return  jt.query("select a.* , count(b.song_id) count from t_song a,t_play_record b where a.id=b.song_id and b.user_id=? group by b.song_id order by count desc",
				new Object[] {userId},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
	}

	@Override
	public List<PlayRecordSong> findSongAndCountByUserIdAndTime(int userId,Date time) {
		return  jt.query("select a.* , count(b.song_id) count from t_song a,t_play_record b where a.id=b.song_id and b.user_id=? and b.play_time>=? group by b.song_id order by count desc",
				new Object[] {userId,DateUtil.formate(time, "yyyy-MM-dd HH:mm:ss")},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
	}

	@Override
	public long findCountBySongId(int songId) {
		List<PlayRecordSong> playRecordSongs=  jt.query("select a.* , count(b.song_id) count from t_song a,t_play_record b where a.id=b.song_id and b.song_id=?",
				new Object[] {songId},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
		  long count=playRecordSongs.get(0).getCount();
		  return count;
	}

	@Override
	public List<PlayRecordSong> findSongAndCountAll() {
		return  jt.query("select a.* , count(b.song_id) count from t_song a,t_play_record b where a.id=b.song_id group by b.song_id order by count desc",
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
	}

	@Override
	public List<PlayRecordSong> findSongAndCountByTime(Date time) {
		return  jt.query("select a.* , count(b.song_id) count from t_song a,t_play_record b where a.id=b.song_id and b.play_time>=? group by b.song_id order by count desc",
				new Object[] {DateUtil.formate(time, "yyyy-MM-dd HH:mm:ss")},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
	}

	@Override
	public long findCountByUserId(int userId) {
		List<PlayRecordSong> playRecordSongs=  jt.query("select count(*) count from t_play_record where user_id=?",
				new Object[] {userId},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
		  long count=playRecordSongs.get(0).getCount();
		  return count;
	}

	@Override
	public List<PlayRecordSong> findSongAndCountLimit(int n) {
		return  jt.query("select a.* , count(b.song_id) count from t_song a,t_play_record b where a.id=b.song_id group by b.song_id order by count desc limit ?",
				new Object[] {n},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
	}

	@Override
	public List<PlayRecordSong> findSongAndCountByTimeLimit(Date time, int n) {
		return  jt.query("select a.* , count(b.song_id) count from t_song a,t_play_record b where a.id=b.song_id and b.play_time>=? group by b.song_id order by count desc limit ?",
				new Object[] {DateUtil.formate(time, "yyyy-MM-dd HH:mm:ss"),n},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
	}

	@Override
	public long findCountBySongIdAndTime(int songId, Date time) {
		List<PlayRecordSong> playRecordSongs=  jt.query("select a.* , count(b.song_id) count from t_song a,t_play_record b  where a.id=b.song_id and b.song_id=? and b.play_time>=?",
				new Object[] {songId,time},
				new BeanPropertyRowMapper<PlayRecordSong>(PlayRecordSong.class));
		  long count=playRecordSongs.get(0).getCount();
		  return count;
	}
}