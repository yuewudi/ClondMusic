package account;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Song;
import entity.User;
import service.prototype.ICollectService;
import service.prototype.ISongService;
import service.prototype.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class UserTest {
	@Autowired
	private IUserService userService;
	@Autowired
	private ISongService songService;
	
	@Autowired
	private ICollectService collectSerice;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	@Test
	public void testFindAll(){
		List<User> users = userService.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	@Test 
	public void testFindById(){
	
		User user = userService.findById(1);
		System.out.println(user);
	}
	
	
	@Test
	public void testFindByAccount(){
		List<User> user= userService.findByAccount("123123");
		System.out.println(user);
	}

	
	@Test
	public void testFindcollect(){
		List<Song> songs = collectSerice.fingByUserId(1);
		for (Song song : songs) {
			System.out.println(song);
		}
	}
	
	
	@Test
	public void testUpdateUser(){
		User user= new User();
		user.setNickName("www");
		user.setDescription("sfdsfdfd");
		user.setSex(true);
		user.setId(1);
		userService.updateUser(user);
	}
	
	
	
	
	/*@Test
	public void testadd(){
		User user = new User();
		user.setAccount("123123123");
		user.setPassword("123123123");
		userService.addUser(user);

	}*/
}
