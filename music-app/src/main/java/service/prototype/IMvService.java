package service.prototype;

import java.util.List;

import entity.Mv;
import entity.Song;
/**
 * 
 * @author 许茹杰17735363779
 *
 */
public interface IMvService {

	//添加视频
	void addMv(Mv mv);
	
	//根据id查视频
	Mv searchMv(int mvId);

	//根据关键字查找视频
	List<Mv> searchLikeMv(String MvKey);
	
	//查找全部视频
	List<Mv> searchMvAll();
	
	//分页查找视频
	List<Mv> searchMvKV(int k,int v);
	
	//根据视频id删除视频
	void deleteMv(int mvId);
	
}
