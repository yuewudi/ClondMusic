package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IVipDao;
import entity.Vip;
import util.DateUtil;
/**
 * 会员的dao实现
 * @author 刘昱
 *
 */
@Repository
public class VipDaoSpringImpl implements IVipDao {

	@Autowired
	private JdbcTemplate jt;
	// --添加vip
	@Override
	public void addVip(Vip vip) {
		jt.update("insert into t_vip(user_id,status,start_time,end_time) " + "values(?,?,?,?)", vip.getUserId(), 1,
				DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"),
				DateUtil.formate(vip.getEnd_time(), "yyyy-MM-dd HH:mm:ss"));
	}

	// --删除vip
	@Override
	public void deleteVip(int id) {
		jt.update("delete from t_vip where id= ?", id);
	}

	// --查找所有vip
	@Override
	public List<Vip> findAll() {
		return jt.query("select * from t_vip", new BeanPropertyRowMapper<Vip>(Vip.class));
	}

	// --查找某种状态的所有vip
	@Override
	public List<Vip> findByStatus(boolean status) {
		return jt.query("select * from t_vip where status=?", 
				new Object[] {status},
				new BeanPropertyRowMapper<Vip>(Vip.class));
	}

	// --根据id查找vip
	@Override
	public Vip findById(int id) {
		return jt.queryForObject("select * from t_vip where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Vip>(Vip.class));
	}

	// --根据userId查找vip
	@Override
	public List<Vip> findByUserId(int userId) {
		return jt.query("select * from t_vip where user_id=?", 
				new Object[] {userId},
				new BeanPropertyRowMapper<Vip>(Vip.class));
	}

	// --根据userId查找某种状态的所有vip
	@Override
	public List<Vip> findByUserIdAndStatus(int userId, boolean status) {
		return jt.query("select * from t_vip where user_id=? and status=?", 
				new Object[] {userId,status},
				new BeanPropertyRowMapper<Vip>(Vip.class));
	}

	// --更新vip状态
	@Override
	public void updateVip(Vip vip) {
		jt.update("update t_vip set status=?,end_time=? where id=?", new Object[] { vip.isStatus(), vip.getEnd_time(),vip.getId() });
	}

}
