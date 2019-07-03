package service.prototype;

import java.util.List;

import entity.User;

public interface IUserService {
	
	void addUser(User user);
	void deleteUser(int id);
	User findById(int id);
	List<User> findByAccount(String account);
	List<User> findAll();
	void updateUser(User user);
	
}
