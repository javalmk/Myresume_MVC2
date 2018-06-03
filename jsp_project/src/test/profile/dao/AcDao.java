package test.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.mybatis.SqlMapConfig;
import test.profile.dto.AcDto;

// 수상및 자격증 dao
public class AcDao {
	private static AcDao dao;
	private static SqlSessionFactory factory;

	private AcDao() {
	}

	public static AcDao getInstance() {
		if (dao == null) {
			dao = new AcDao();
			factory = SqlMapConfig.getSqlSession();
		}
		return dao;
	}

	// 저장(insert)
	public void insert(AcDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.insert("ac.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// 수정(update)
	public void update(AcDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.update("ac.update", dto);
			System.out.println("==============수정된당");
			System.out.println(dto.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// 삭제(delete)
	public void delete(AcDto dto) {
		SqlSession session = null;
		try {
			session = factory.openSession(true);
			session.delete("ac.delete", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// 수상경력 리턴(select)
	public List<AcDto> getList(String id) {
		SqlSession session = null;
		List<AcDto> list = null;
		try {
			session = factory.openSession();
			list=session.selectList("ac.getList", id);
			System.out.println("==============");
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	//하나의 정보 리턴
	public AcDto getData(AcDto dto) {
		SqlSession session = null;
		AcDto resultDto = new AcDto();
		try {
			session = factory.openSession();
			resultDto = session.selectOne("ac.getData", dto);
			System.out.println("==============");
			System.out.println(resultDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultDto;
	}
}
