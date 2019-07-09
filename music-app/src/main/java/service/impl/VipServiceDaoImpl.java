package service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IVipDao;
import entity.Vip;
import service.prototype.IVipService;
import util.DateUtil;

/**
 * 会员service实现
 * 
 * @author 刘昱
 *
 */
@Service
public class VipServiceDaoImpl implements IVipService {

	@Autowired
	private IVipDao vipDao;
	//充值会员
	@Override
	public void rechargeVip(int userId, int month) {
		Vip vip = new Vip();
		//充值天数
		int days = month * 30;
		//如果没有现在这个用户的会员记录
		if (vipDao.findByUserIdAndStatus(userId, true).size() == 0) {
			//新建会员记录
			//设置会员记录的会员id
			vip.setUserId(userId);
			
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.add(Calendar.DAY_OF_MONTH, days);
			//到期时间
			Date date = c.getTime();
			//设置会员记录到期时间
			vip.setEnd_time(date);
			//添加会员
			vipDao.addVip(vip);
		}else {
			//获取当前会员
			vip=vipDao.findByUserIdAndStatus(userId, true).get(0);
			Calendar c = Calendar.getInstance();
			c.setTime(vip.getEnd_time());
			c.add(Calendar.DAY_OF_MONTH, days);
			//到期时间
			Date date = c.getTime();
			//设置会员记录到期时间
			vip.setEnd_time(date);
			//更新会员
			vipDao.updateVip(vip);
		}

	}
	//会员到期
	@Override
	public void expireVip(int id) {
		//查找会员
		Vip vip=vipDao.findById(id);
		//更新会员状态为false
		vip.setStatus(false);
		vipDao.updateVip(vip);
	}
	//--查找所有vip记录
	@Override
	public List<Vip> findAll() {
		
		return vipDao.findAll();
	}
	//查找所有未过期vip记录
	@Override
	public List<Vip> findVipAll() {
		
		return vipDao.findByStatus(true);
	}
	//--根据id查找vip
	@Override
	public Vip findById(int id) {
		
		return vipDao.findById(id);
	}
	//--根据userId查找当前未到期vip
	@Override
	public Vip findVipByUserId(int userId) {
		if(vipDao.findByUserIdAndStatus(userId, true).size()==0) {
			return null;
		}else {
			return vipDao.findByUserIdAndStatus(userId, true).get(0);
		}

	}

}
