package dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.ITypeDao;
import entity.Type;

/**
 * 歌曲分类的dao实现
 * @author 刘昱
 *
 */
@Repository
public class TypeDaoSpringImpl  implements ITypeDao{
	
	@Autowired
	private JdbcTemplate jt;
	//--添加歌曲分类
	@Override
	public void addType(Type type) {
		jt.update(
				"insert into t_type(type_name) "
				+ "values(?)",
				type.getTypeName());
		
	}
	//--通过id删除歌曲分类
	@Override
	public void deleteType(int id) {
		jt.update("delete from t_type where id = ?", id);
	}
	//--查找所有歌曲分类
	@Override
	public List<Type> findAll() {
		return jt.query("select * from t_type",
				new BeanPropertyRowMapper<Type>(Type.class));
	}
	//--通过id查找歌曲分类
	@Override
	public Type findById(int id) {
		return jt.queryForObject("select * from t_type where id=?", 
				new Object[] {id},
				new BeanPropertyRowMapper<Type>(Type.class));
	}
	//--更新歌曲分类
	@Override
	public void updateType(Type type) {
		jt.update(
				"update t_type set "
				+ "type_name=?"
				+ "where id=?",
				new Object[]{
					type.getTypeName(),
					type.getId()
		});
	}
}
