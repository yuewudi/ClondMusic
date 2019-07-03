package dao.prototype;

import java.util.List;

import entity.MvComment;

public interface IMvCommentDao {
	
	//--添加视频评论
		void addMvComment(MvComment mvComment);
		//--通过id删除视频评论
		void deleteMvComment(int id);
		//--倒序查找所有视频评论
		List<MvComment> findAll();
		//--查找最后十条视频评论
			List<MvComment> findTen();
		//--通过id查找视频评论
		MvComment findById(int id);
		List<MvComment> findByUserId(int userId);
		//--通过mvId倒序查找视频评论
		List<MvComment> findByMvId(int mvId);
		//--更新视频评论
		void updateMvComment(MvComment mvComment);
}
