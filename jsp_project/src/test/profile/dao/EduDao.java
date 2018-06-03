package test.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.profile.dto.EduDto;

// 교육Dao
public class EduDao {
	private static EduDao dao;
	private static SqlSessionFactory factory;
	
	private EduDao() {	}
	
	public static EduDao getInstance() {
		if(dao == null) {
			dao = new EduDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}
		
	
	// 저장(insert)
	public void insert(EduDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.insert("edu.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// 수정(update)
	public void update(EduDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.update("edu.update", dto);
			System.out.println(dto.getStart_date());
			System.out.println(dto.getEnd_date());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// 삭제(delete)
	public void delete(EduDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.delete("edu.delete", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// 교육목록 리턴(select)
	public List<EduDto> getList(String id) {
		SqlSession session = null;
		List<EduDto> list = null;
		try {
			session = factory.openSession();
			list=session.selectList("edu.getList", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	//하나의 정보 리턴
	public EduDto getData(EduDto dto) {
		SqlSession session = null;
		EduDto resultDto = new EduDto();
		try {
			session = factory.openSession();
			resultDto = session.selectOne("edu.getData", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultDto;
	}
}
