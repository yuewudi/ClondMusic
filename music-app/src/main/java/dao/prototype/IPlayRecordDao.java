package dao.prototype;

import java.util.Date;
import java.util.List;

import entity.PlayRecord;
import entity.PlayRecordSong;

public interface IPlayRecordDao {
	
	//增加播放记录
		void addSongRecord(PlayRecord playRecord);
		//删除播放记录
		void deleteMv(int id);
		//更新播放记录
		void updatePlayRecord(PlayRecord playRecord);
		//根据userId查询查询播放的歌和次数
		List<PlayRecordSong> findSongAndCountByUserId(int userId);
		//根据userId和时间查询查询播放的歌和次数
		List<PlayRecordSong> findSongAndCountByUserIdAndTime(int userId,Date time);
		//根据songId查询播放次数
		long findCountBySongId(int songId);
		//根据songId查询某一天后播放次数
		long findCountBySongIdAndTime(int songId,Date time);
		//根据userId查询播放次数
		long findCountByUserId(int userId);
		//查询所有歌还有播放次数
		List<PlayRecordSong> findSongAndCountAll();
		//查询所有歌还有播放次数n条
		List<PlayRecordSong> findSongAndCountLimit(int n);
		//查询某一天后的歌还有播放次数
		List<PlayRecordSong> findSongAndCountByTime(Date time);
		//查询某一天后的歌还有播放次数n条
		List<PlayRecordSong> findSongAndCountByTimeLimit(Date time,int n);
}
