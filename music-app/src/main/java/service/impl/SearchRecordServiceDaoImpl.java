package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.prototype.ISearchRecordDao;

import entity.SearchRecord;


import service.prototype.ISeachRecordService;


/**
 * 搜索记录service实现类
 * 
 * @author 刘昱
 *
 */
@Service
public class SearchRecordServiceDaoImpl implements ISeachRecordService {

	@Autowired
	private ISearchRecordDao searchRecordDao;
	//--添加或更新搜索记录
	@Override
	public void addOrUpdateSearchRecord(int userId, String keyword) {
		SearchRecord searchRecord=new SearchRecord();
		searchRecord.setUserId(userId);
		searchRecord.setKeyword(keyword);
		if(searchRecordDao.findByUserIdAndKeyword(userId, keyword).size()==1) {
			searchRecord.setSearch_time(new Date());
			searchRecordDao.updateSearchRecord(searchRecord);
		}else {
			searchRecordDao.addSearchRecord(searchRecord);
		}
			
	
	}
	//--通过id删除搜索记录
	@Override
	public void deleteSearchRecordById(int id) {
		searchRecordDao.deleteSearchRecordById(id);
		
	}
	//--通过userId删除搜索记录
	@Override
	public void deleteSearchRecordByUserId(int userId) {
		searchRecordDao.deleteSearchRecordByUserId(userId);
		
	}
	//--查找所有搜索记录
	@Override
	public List<SearchRecord> findAll() {
		return searchRecordDao.findAll();
	}
	//--通过id查找搜索记录
	@Override
	public SearchRecord findById(int id) {
		return searchRecordDao.findById(id);
	}
	//--通过userId查找搜索记录
	@Override
	public List<SearchRecord> findByUserId(int userId) {
		return searchRecordDao.findByUserId(userId);
	}
	
}
