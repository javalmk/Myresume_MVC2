package test.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.profile.dto.ExpsDto;

// 경험 Dao
public class ExpsDao {
	private static ExpsDao dao;
	private static SqlSessionFactory factory;
	
	private ExpsDao() {	}
	
	public static ExpsDao getInstance() {
		if(dao == null) {
			dao = new ExpsDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}
		
	
	// 저장(insert)
	public void insert(ExpsDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.insert("exps.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// 수정(update)
	public void update(ExpsDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.update("exps.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// 삭제(delete)
	public void delete(ExpsDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.delete("exps.delete", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			String a = "a";
		}
	}
	
	// 경험목록 리턴(select)
	public List<ExpsDto> getList(String id) {
		SqlSession session = null;
		List<ExpsDto> list = null;
		try {
			session = factory.openSession();
			list = session.selectList("exps.getList", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	//하나의 정보 리턴
	public ExpsDto getData(ExpsDto dto) {
		SqlSession session = null;
		ExpsDto resultDto = new ExpsDto();
		try {
			session = factory.openSession();
			resultDto = session.selectOne("exps.getData", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultDto;
	}
}
