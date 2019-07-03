package dao.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IUserDao;
import entity.User;

@Repository
public class UserDaoSpringImpl implements IUserDao{
	
	//获取 
	@Autowired
	private JdbcTemplate jt;

	@Override
	public void addUser(User user) {
		String sql = "insert into t_user(account,password,create_date,header) values(?,?,?,?)";
		Object[] obj = new Object[]{user.getAccount(),user.getPassword(),user.getcreate_date(),user.getHeader()};
		jt.update(sql,obj);
		
	}

	@Override
	public void deleteUser(int id) {
		
		jt.update("delete from t_user where id = ?", 3);
		
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from t_user";
		List<User> users = jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return users;
		
	}

	@Override
	public User findById(int id) {

		
		return jt.queryForObject("select * from t_user where id =?", new BeanPropertyRowMapper<User>(User.class),id);
	}

	@Override
	public void updateUser(User user) {
		
		String sql = "update t_user set nick_name=?,description=?,sex=?,phone=?,header=? where id ="+user.getId();
		Object[] obj = new Object[]{user.getNickName(),user.getDescription(),user.isSex(),user.getPhone(),user.getHeader()};
		jt.update(sql,obj);
		
		
	}

	@Override
	public List<User> findByAccount(String account) {
		String sql="select * from t_user where account=?";
		List<User> user = jt.query(sql,new BeanPropertyRowMapper<User>(User.class),account);
		
		return user;
	}
	

}
