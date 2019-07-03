package service.prototype;

import java.util.List;

import entity.MvComment;

public interface IMvCommenService {

	//添加视频评论
	void addMvComment(MvComment mvComment);
	
	//根据视频id查视频评论
	List<MvComment> findByMvId(int mvid);

	//根据评论id删除视频评论			
	void deleteMvComment(int mvCommentId);
	
}
