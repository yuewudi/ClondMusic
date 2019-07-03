package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import dao.prototype.IMvDao;
import entity.Mv;
import util.DateUtil;


/**
 * 
 * @author 许茹杰17735363779
 *
 */
@Repository
public class MvDaoSpringImpl implements IMvDao {

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void addMv(Mv mv) {
		jt.update("insert into t_mv(mv_name,user_id,mv_time,mv_url,description,status) values(?,?,?,?,?,?)",mv.getMvName(),mv.getUserId(),DateUtil.formate(new Date(), "yyyy-MM-dd HH:mm:ss"),mv.getMvUrl(),mv.getDescription(),1);	
	}

	@Override
	public void deleteMv(int mvid) {
		jt.update("delete from t_mv where id = ?",mvid);
		jt.update("delete from t_mv_comment where mv_id = ?",mvid);
		
	}

	@Override
	public List<Mv> findAll(int offset,int pageSize) {
		return jt.query("select * from t_mv limit ?,?",
				new Object[] {offset,pageSize},
				new BeanPropertyRowMapper<Mv>(Mv.class));
	}

	@Override
	public List<Mv> findByUserId(int userId) {
		return jt.query("select * from t_mv where user_id = ?",
				new Object[] {userId},
				new BeanPropertyRowMapper<Mv>(Mv.class));
	}

	@Override
	public Mv findById(int mvId) {
		return jt.queryForObject("select * from t_mv where id = ?",Mv.class,mvId);
	}

	@Override
	public Mv findByAccount(String MvName) {
		return jt.queryForObject("select * from t_mv where mv_name = ?",Mv.class,MvName);
	}

	@Override
	public void updateMv(Mv mv) {
		jt.update("update mv from set mv_name = ? , mv_time =? , mv_url = ? , description = ? status = ? where id = ?",mv.getMvName(),mv.getMv_time(),mv.getMvUrl(),mv.getDescription(),1,mv.getId());	
	}

	@Override
	public List<Mv> keywordSeek(String mvName) {
		return jt.query("select * from t_mv where mv_name like '%?%' ",
				new Object[] {mvName},
				new BeanPropertyRowMapper<Mv>(Mv.class));
	}

	@Override
	public List<Mv> findAll() {
		return jt.query("select * from t_mv",
				new BeanPropertyRowMapper<Mv>(Mv.class));
	}

}
