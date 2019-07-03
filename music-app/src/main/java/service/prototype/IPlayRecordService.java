package service.prototype;

import java.util.List;

import entity.PlayRecord;
import entity.PlayRecordSong;

public interface IPlayRecordService {
	//增加播放记录
	void addSongRecord(PlayRecord playRecord);
	//删除播放记录
	void deleteMv(int playRecordid);
	//根据 userId查询播放记录
	List<PlayRecordSong> findById(int userId);
	//更新播放记录
	void updatePlayRecord(PlayRecord playRecord);
}