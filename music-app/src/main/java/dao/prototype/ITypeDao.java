package dao.prototype;

import java.util.List;

import entity.Type;
/**
 * 歌曲分类的dao接口
 * @author 刘昱
 *
 */
public interface ITypeDao {
	//--添加歌曲分类
	void addType(Type type);
	//--通过id删除歌曲分类
	void deleteType(int id);
	//--查找所有歌曲分类
	List<Type> findAll();
	//--通过id查找歌曲分类
	Type findById(int id);
	//--更新歌曲分类
	void updateType(Type type);
}
