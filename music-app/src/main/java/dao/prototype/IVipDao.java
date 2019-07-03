package dao.prototype;

import java.util.List;

import entity.Vip;
/**
 * 会员的dao接口
 * @author 刘昱
 *
 */
public interface IVipDao {
	//--添加vip
	void addVip(Vip vip);
	//--删除vip
	void deleteVip(int id);
	//--查找所有vip
	List<Vip> findAll();
	//--查找某种状态的所有vip
	List<Vip> findByStatus(boolean status);
	//--根据id查找vip
	Vip findById(int id);
	//--根据userId查找vip
	List<Vip> findByUserId(int userId);
	//--根据userId查找某种状态的所有vip
	List<Vip> findByUserIdAndStatus(int userId,boolean status);
	//--更新vip
	void updateVip(Vip vip);
}
