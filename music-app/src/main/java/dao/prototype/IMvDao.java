package dao.prototype;
import java.util.List;
import entity.Mv;


public interface IMvDao {
	
	
	//上传视频
	void addMv(Mv mv);
	//删除视频
	void deleteMv(int mvid);
	//视频列表
	List<Mv> findAll(int offset,int pageSize);
	//通过userid查询属于user的视频
	List<Mv> findByUserId(int userId);
	//根据id查视频
	Mv findById(int mvId);
	//根据Mvname查询视频
	Mv findByAccount(String MvName);
	//更新视频 id和userid不更新
	void updateMv(Mv mv);
	//通过关键字搜索视频
	List<Mv> keywordSeek(String mvName);
	//全部视频列表
	List<Mv> findAll();
}
