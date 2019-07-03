package dao.prototype;


import entity.Play;

public interface IPlayDao {	
	    //增加播放
		void addPlay(Play play);
		//删除播放
		void deletePlay(int playid);
		//查询正在播放总数
		int findPlayCount();
		//查询某首歌的播放量
		int findBySongId(int songId);
		//更新正在播放
		void updatePlay(Play play);
}
