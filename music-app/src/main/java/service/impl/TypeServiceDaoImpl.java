package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.ISongDao;
import dao.prototype.ITypeDao;
import entity.Song;
import entity.Type;
import service.prototype.ITypeService;

/**
 * 分类service实现类
 * 
 * @author 刘昱
 *
 */
@Service
public class TypeServiceDaoImpl implements ITypeService {

	@Autowired
	private ITypeDao typeDao;
	@Autowired
	private ISongDao songDao;

	// --添加歌曲分类
	@Override
	public void addType(String typeName) {
		Type type = new Type();
		type.setTypeName(typeName);
		typeDao.addType(type);
	}

	// --删除歌曲分类
	@Override
	public void deleteType(int id) {
		if(id!=1) {
			List<Song> songs=songDao.findByTypeId(id);
			for(Song song:songs) {
				song.setTypeId(1);
				songDao.updateSong(song);
			}
			typeDao.deleteType(id);
		}
	}

	// --查找所有歌曲分类
	@Override
	public List<Type> findAll() {
		return typeDao.findAll();
	}

	// --更新歌曲分类名
	@Override
	public void updateType(int id,String typeName) {
		Type type=new Type();
		type.setId(id);
		type.setTypeName(typeName);
		typeDao.updateType(type);
	}

}
