package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IPlayRecordDao;
import entity.PlayRecord;
import entity.PlayRecordSong;
import service.prototype.IPlayRecordService;

@Service
public class PlayRecordServiceDaoImpl implements IPlayRecordService{

	@Autowired
	private IPlayRecordDao playRecordDao;
	
	@Override
	public void addSongRecord(PlayRecord playRecord) {
		 playRecordDao.addSongRecord(playRecord);
	}

	@Override
	public void deleteMv(int playRecordid) {
		 playRecordDao.deleteMv(playRecordid);
		
	}

	@Override
	public List<PlayRecordSong> findById(int userId) {
		return  playRecordDao.findById(userId);
	}

	@Override
	public void updatePlayRecord(PlayRecord playRecord) {
		 playRecordDao.updatePlayRecord(playRecord);
		
	}

}
