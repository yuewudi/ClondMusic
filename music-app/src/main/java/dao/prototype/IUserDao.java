package dao.prototype;

import java.util.List;

import entity.User;

public interface IUserDao {
	//添加用户
	void addUser(User user);
	//删除用户
	void deleteUser(int id);
	//查询所有所有的用户
	List<User> findAll();
	//通过ID查询一个用户
	User findById(int id);
	//通过账号查询一个用户
	List<User> findByAccount(String account);
	//更新个人资料
	void updateUser(User user);
}
