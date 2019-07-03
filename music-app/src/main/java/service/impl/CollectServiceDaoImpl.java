package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.ICollectDao;
import entity.Song;
import entity.User;
import service.prototype.ICollectService;

@Service
public class CollectServiceDaoImpl implements ICollectService{
	@Autowired
	private ICollectDao colllectDao;

	@Override
	public List<Song> fingByUserId(int userId) {
		
		return colllectDao.findByUserId(userId);
	}

	@Override
	public void addCollect(Song song, User user) {
	
		colllectDao.collectSong(song.getId(), user.getId());
		
	}

	@Override
	public void deleteCollect(Song song, User user) {

		colllectDao.deleteSong(song.getId(), user.getId());
		
	}

}
