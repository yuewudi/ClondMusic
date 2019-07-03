package service.prototype;

import java.util.List;

import entity.Type;

/**
 * 分类的service接口
 * @author 刘昱
 *
 */
public interface ITypeService {
	// --添加歌曲分类
	void addType(String typeName);

	// --删除歌曲分类
	void deleteType(int id);

	// --查找所有歌曲分类
	List<Type> findAll();

	// --更新歌曲分类名
	void updateType(int id,String typeName);
}
