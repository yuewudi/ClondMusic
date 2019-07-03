package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IMvDao;
import entity.Mv;
import entity.Song;
import service.prototype.IMvService;

@Service
public class MvServiceDaoImpl implements IMvService{

	
	@Autowired
	private IMvDao mvDao;
	
	//添加视频
	@Override
	public void addMv(Mv mv) {
		mvDao.addMv(mv);
		
	}

	//根据视频id查找视频
	@Override
	public Mv searchMv(int mvId) {
		return mvDao.findById(mvId);
	}

	//根据关键词查找视频列表
	@Override
	public List<Mv> searchLikeMv(String MvKey) {
		return mvDao.keywordSeek(MvKey);
	}

	
	//根据视频id删除视频
	@Override
	public void deleteMv(int mvId) {
		mvDao.deleteMv(mvId);
	}

	@Override
	public List<Mv> searchMvAll() {

		return mvDao.findAll();
	}

	@Override
	public List<Mv> searchMvKV(int k, int v) {
		return mvDao.findAll(k, v);
	}

}
