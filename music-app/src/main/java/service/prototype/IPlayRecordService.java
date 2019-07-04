package service.prototype;

import java.util.Date;
import java.util.List;

import entity.PlayRecord;
import entity.PlayRecordSong;

public interface IPlayRecordService {
	//增加播放记录
			void addSongRecord(PlayRecord playRecord);
			//删除播放记录
			void deleteMv(int id);
			//更新播放记录
			void updatePlayRecord(PlayRecord playRecord);
			//根据userId查询查询播放的歌和次数
			List<PlayRecordSong> findSongAndCountByUserId(int userId);
			//根据userId查询本周播放的歌和次数
			List<PlayRecordSong> findSongAndCountByUserIdInWeek(int userId);
			//根据songId查询播放次数
			long findCountBySongId(int songId);
			//根据songId查询本周播放次数
			long findCountBySongIdInWeek(int songId);
			//根据userId查询播放次数
			long findCountByUserId(int userId);
			//查询所有歌还有播放次数
			List<PlayRecordSong> findSongAndCountAll();
			//查询本周的歌还有播放次数
			List<PlayRecordSong> findSongAndCountInWeek();
			//查询所有歌还有播放次数10条
			List<PlayRecordSong> findSongAndCountLimitTen();
			//查询本周的歌还有播放次数10条
			List<PlayRecordSong> findSongAndCountInWeekLimitTen();
			//查询所有歌还有播放次数100条
			List<PlayRecordSong> findSongAndCountLimitHundred();
			//查询本周的歌还有播放次数10条
			List<PlayRecordSong> findSongAndCountInWeekLimitHundred();
}