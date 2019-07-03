package service.prototype;

import java.util.List;

import entity.SearchRecord;
/**
 * 搜索记录的service接口
 * @author 刘昱
 *
 */
public interface ISeachRecordService {
	
	//--添加或更新搜索记录
	void addOrUpdateSearchRecord(int userId, String keyword);
	//--通过id删除搜索记录
	void deleteSearchRecordById(int id);
	//--通过userId删除搜索记录
	void deleteSearchRecordByUserId(int userId);
	//--查找所有搜索记录
	List<SearchRecord> findAll();
	//--通过id查找搜索记录
	SearchRecord findById(int id);
	//--通过userId查找搜索记录
	List<SearchRecord> findByUserId(int userId);
	
}
