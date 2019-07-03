package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.prototype.ISongDao;
import entity.Song;
import util.DateUtil;

@Repository
public class SongDaoImpl implements ISongDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		String sql = "insert into t_song(id,song_name,song_author,type_id,song_create_time,song_url,song_image,song_words,description,is_vip,status,song_time,uploader_id )values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = new Object[]{song.getId(),song.getSongName(),song.getSongAuthor(),song.getTypeId(),DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"),song.getSongUrl(),song.getSongImage(),song.getSongWords(),song.getDescription(),song.isVip(),song.isStatus(),song.getSongTime(),song.getUploaderId()};
		jt.update(sql,obj);
	}

	@Override
	public Song searchSong(int id) {
		// TODO Auto-generated method stub
		
		RowMapper<Song> rowMapper = new BeanPropertyRowMapper<Song>(Song.class);
		String sql = "select * from t_song where id="+id;
		return jt.queryForObject(sql, rowMapper);
	}

	@Override
	public List<Song> searchLikeSong(String key) {
		// TODO Auto-generated method stub
		RowMapper<Song> rowMapper = new BeanPropertyRowMapper<Song>(Song.class);
/*		new RowMapper(){
			public Object mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
				
				return rowNum;
				
			}};*/
		String sql = "select * from t_song where song_name like '%"+key+"%'";
		return jt.query(sql, rowMapper);
	
	}

	@Override
	public void deleteSong(Song song) {
		// TODO Auto-generated method stub
		String sql = "delete from t_song where song_name="+song.getSongName();
		jt.update(sql);
	}

	@Override
	public void updateSong(Song song) {
		
		jt.update("update t_song set song_name = ?,song_author = ?,type_id = ?,song_time = ?,song_url = ?,"
				+ "song_image = ?,song_words = ?,description = ?,is_vip = ?,status = ?,song_create_time = ? where song_name = ?",
				song.getSongName(),song.getSongAuthor(),song.getTypeId(),song.getSongTime(),song.getSongUrl(),song.getSongImage()
				,song.getSongWords(),song.getDescription(),song.isVip(),song.isStatus(),song.getSong_create_time(),song.getId());
	}

	@Override
	public List<Song> findByTypeId(int typeId) {
		return jt.query("select * from t_song where type_id = ?",new Object[]{typeId},new BeanPropertyRowMapper<Song>(Song.class));
	}

	@Override
	public List<Song> findAllSongs() {
		// TODO Auto-generated method stub
		return jt.query("select * from t_song", new BeanPropertyRowMapper<Song>(Song.class));
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int i = 0;
		List<Song> songs = jt.query("select * from t_song", new BeanPropertyRowMapper<Song>(Song.class));
		for (Song song : songs) {
			i++;
		}
		return i;
	}

	@Override
	public List<Song> newSong() {
		// TODO Auto-generated method stub
		return jt.query("select * from t_song order by song_create_time desc limit 100", new BeanPropertyRowMapper<Song>(Song.class));
	}

	@Override
	public List<Song> searchByUploaderId(int uploaderId) {
		return jt.query("select * from t_song where uploader_id=? order by song_create_time desc limit 100",new Object[]{uploaderId}, new BeanPropertyRowMapper<Song>(Song.class));
	}

}
