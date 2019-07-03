package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.ISongCommentDao;
import entity.SongComment;
import service.prototype.ISongCommentService;

/**
 * 歌曲评论service实现类
 * @author 刘昱
 *
 */
@Service
public class SongCommentServiceDaoImpl implements ISongCommentService{

	@Autowired
	private ISongCommentDao songCommentDao;

	@Override
	public void addSongComment(int userId, int songId, String content) {
		SongComment songComment =new SongComment();
		songComment.setUserId(userId);
		songComment.setSongId(songId);
		songComment.setContent(content);
		songCommentDao.addSongComment(songComment);
	}

	@Override
	public void deleteSongComment(int id) {
		songCommentDao.deleteSongComment(id);
		
	}

	@Override
	public List<SongComment> findAll() {

		return songCommentDao.findAll();
	}

	@Override
	public List<SongComment> findTen() {
		return songCommentDao.findTen();
	}

	@Override
	public SongComment findById(int id) {
		return songCommentDao.findById(id);
	}

	@Override
	public List<SongComment> findBySongId(int songId) {
		return songCommentDao.findBySongId(songId) ;
	}

	@Override
	public void updateSongComment(int id, String content) {
		SongComment songComment =new SongComment();
		songComment.setId(id);
		songComment.setContent(content);
		songCommentDao.updateSongComment(songComment);
	}


	
}
