package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IUserDao;
import entity.User;
import service.prototype.IUserService;

@Service
public class UserServiceDaoImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;	

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public User findById(int id) {
	
		return userDao.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public List<User> findByAccount(String account) {
	
		return userDao.findByAccount(account);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

}
