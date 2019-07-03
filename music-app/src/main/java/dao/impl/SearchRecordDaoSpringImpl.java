package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.ISearchRecordDao;
import entity.SearchRecord;
import util.DateUtil;
/**
 * 搜索记录的dao实现
 * @author 刘昱
 *
 */
@Repository
public class SearchRecordDaoSpringImpl implements ISearchRecordDao{
	@Autowired
	private JdbcTemplate jt;
	//--添加搜索记录
	@Override
	public void addSearchRecord(SearchRecord searchRecord) {
		jt.update("insert into t_search_record(user_id,keyword,search_time) " + "values(?,?,?)", 
				searchRecord.getUserId(), searchRecord.getKeyword(),
				DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}
	//--通过id删除搜索记录
	@Override
	public void deleteSearchRecordById(int id) {
		jt.update("delete from t_search_record where id= ?", id);
	}
	//--通过userId删除搜索记录
	@Override
	public void deleteSearchRecordByUserId(int userId) {
		jt.update("delete from t_search_record where user_id= ?", userId);
	}
	//--查找所有搜索记录
	@Override
	public List<SearchRecord> findAll() {
		return jt.query("select * from t_search_record", new BeanPropertyRowMapper<SearchRecord>(SearchRecord.class));
	}
	//--通过id查找搜索记录
	@Override
	public SearchRecord findById(int id) {
		return jt.queryForObject("select * from  t_search_record where id=?", new Object[] { id },
				new BeanPropertyRowMapper<SearchRecord>(SearchRecord.class));
	}
	//--通过userId查找搜索记录
	@Override
	public List<SearchRecord> findByUserId(int userId) {
		return jt.query("select * from t_search_record where user_id=?", 
				new Object[] {userId},
				new BeanPropertyRowMapper<SearchRecord>(SearchRecord.class));
	}
	//--通过userId和keyword查找搜索记录
	@Override
	public List<SearchRecord> findByUserIdAndKeyword(int userId,String keyword){
		return jt.query("select * from  t_search_record where user_id=? and keyword=?", new Object[] { userId,keyword },
				new BeanPropertyRowMapper<SearchRecord>(SearchRecord.class));
	}
	//--更新搜索记录的时间
	@Override
	public void updateSearchRecord(SearchRecord searchRecord) {
		jt.update("update t_search_record set search_time=? where keyword=?", new Object[] {DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"), searchRecord.getKeyword()});
		
	}

}
