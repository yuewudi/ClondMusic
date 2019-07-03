package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.ISongDao;
import entity.Song;
import service.prototype.ISongService;
@Service
public class SongServiceDaoImpl implements ISongService{

	@Autowired
	private ISongDao songDao;
	
	@Override
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		songDao.addSong(song);
		
	}

	@Override
	public Song searchSong(int id) {
		
		return songDao.searchSong(id);
	}

	@Override
	public List<Song> searchLikeSong(String key) {
		// TODO Auto-generated method stub
		return songDao.searchLikeSong(key);
	}

	@Override
	public void deleteSong(Song song) {
		// TODO Auto-generated method stub
		songDao.deleteSong(song);
	}

	@Override
	public void updateSong(Song song) {
		// TODO Auto-generated method stub
		songDao.updateSong(song);
	}

	@Override
	public List<Song> findByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return songDao.findByTypeId(typeId);
	}

	@Override
	public List<Song> findAllSongs() {
		// TODO Auto-generated method stub
		return songDao.findAllSongs();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return songDao.count();
	}

	@Override
	public List<Song> newSong() {
		// TODO Auto-generated method stub
		return songDao.newSong();
	}

	@Override
	public List<Song> searchByUploaderId(int uploaderId) {
		// TODO Auto-generated method stub
		return songDao.searchByUploaderId(uploaderId);
	}
	
	

}
