package service.impl;

import java.util.Calendar;
import java.util.Date;
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
	public void deleteMv(int id) {
		playRecordDao.deleteMv(id);
		
	}

	@Override
	public void updatePlayRecord(PlayRecord playRecord) {
		playRecordDao.updatePlayRecord(playRecord);
		
	}

	@Override
	public List<PlayRecordSong> findSongAndCountByUserId(int userId) {
		return playRecordDao.findSongAndCountByUserId(userId);
	}


	@Override
	public long findCountBySongId(int songId) {
		return playRecordDao.findCountBySongId(songId);
	}

	@Override
	public List<PlayRecordSong> findSongAndCountAll() {
		return playRecordDao.findSongAndCountAll();
	}

	@Override
	public List<PlayRecordSong> findSongAndCountByUserIdInWeek(int userId) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -7);
		//一周前
		Date date = c.getTime();
		return playRecordDao.findSongAndCountByUserIdAndTime(userId, date);
	}

	@Override
	public List<PlayRecordSong> findSongAndCountInWeek() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -7);
		//一周前
		Date date = c.getTime();
		return playRecordDao.findSongAndCountByTime(date);
	}

	@Override
	public long findCountByUserId(int userId) {
		return playRecordDao.findCountByUserId(userId);
	}

	@Override
	public List<PlayRecordSong> findSongAndCountLimitTen() {
		return playRecordDao.findSongAndCountLimit(10);
	}

	@Override
	public List<PlayRecordSong> findSongAndCountInWeekLimitTen() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -7);
		//一周前
		Date date = c.getTime();
		return playRecordDao.findSongAndCountByTimeLimit(date, 10);
	}

	@Override
	public List<PlayRecordSong> findSongAndCountLimitHundred() {
		return playRecordDao.findSongAndCountLimit(100);
	}

	@Override
	public List<PlayRecordSong> findSongAndCountInWeekLimitHundred() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -7);
		//一周前
		Date date = c.getTime();
		return playRecordDao.findSongAndCountByTimeLimit(date, 100);
	}

	@Override
	public long findCountBySongIdInWeek(int songId) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -7);
		//一周前
		Date date = c.getTime();
		return playRecordDao.findCountBySongIdAndTime(songId, date);
	}

}



