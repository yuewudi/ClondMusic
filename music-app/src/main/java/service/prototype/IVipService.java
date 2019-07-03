package service.prototype;

import java.util.List;

import entity.Vip;
/**
 * 会员service实现
 * @author 刘昱
 *
 */
public interface IVipService {
	//充值会员
	void rechargeVip(int userId,int month);
	//会员到期
	void expireVip(int id);
	//--查找所有vip记录
	List<Vip> findAll();
	//--查找所有未到期的vip
	List<Vip> findVipAll();
	//--根据id查找vip
	Vip findById(int id);
	//--根据userId查找当前未到期vip
	Vip findVipByUserId(int userId);
}
