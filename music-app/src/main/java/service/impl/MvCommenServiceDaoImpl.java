package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IMvCommentDao;
import dao.prototype.IMvDao;
import entity.MvComment;
import service.prototype.IMvCommenService;

@Service
public class MvCommenServiceDaoImpl implements IMvCommenService{

	
	@Autowired
	private IMvCommentDao mvCommentDao;
	
	@Override
	public void addMvComment(MvComment mvComment) {	
		mvCommentDao.addMvComment(mvComment);
	}

	@Override
	public List<MvComment> findByMvId(int mvid) {
	
		return mvCommentDao.findByMvId(mvid);
	}

	@Override
	public void deleteMvComment(int mvCommentId) {
		mvCommentDao.deleteMvComment(mvCommentId);
		
	}

}
