package account;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IVipDao;
import entity.Song;
import entity.User;
import entity.Vip;
import service.prototype.ICollectService;
import service.prototype.ISongService;
import service.prototype.IUserService;
import service.prototype.IVipService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class VipTest2 {
	@Autowired
	private IVipService vipService;
	@Autowired
	private IVipDao vipDao;
	@Test
	public void addVip(){
	vipService.rechargeVip(1, 1);

		}
	@Test
	public void findVip(){
	Vip vip=vipService.findVipByUserId(1);
	System.out.println(vip);
		}
}
