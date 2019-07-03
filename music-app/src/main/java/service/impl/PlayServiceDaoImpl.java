package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IPlayDao;
import entity.Play;
import service.prototype.IPlayService;

@Service
public class PlayServiceDaoImpl implements IPlayService{

	@Autowired
	private IPlayDao playDao;
	
	@Override
	public void addPlay(Play play) {
		playDao.addPlay(play);
		
	}

	@Override
	public void deletePlay(int playid) {
		playDao.deletePlay(playid);
		
	}

	@Override
	public int findPlayCount() {
		return playDao.findPlayCount();
	}

	@Override
	public int findBySongId(int songId) {
		return playDao.findBySongId(songId);
	}

	@Override
	public void updatePlay(Play play) {
		playDao.updatePlay(play);
		
	}

}
