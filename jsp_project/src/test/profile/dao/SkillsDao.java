package test.profile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.profile.dto.SkillsDto;

//기술 dao
public class SkillsDao {
	private static SkillsDao dao;
	private static SqlSessionFactory factory;
	private SkillsDao() {}
	public static SkillsDao getInstance() {
		if(dao==null) {
			dao=new SkillsDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	//저장(insert)
	public void insert(SkillsDto dto) {
		SqlSession session = null;
		try {
			session=factory.openSession(true);
			session.insert("skills.insert",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	//수정(update)
	public void update(SkillsDto dto) {
		SqlSession session = null;
		try {
			session=factory.openSession(true);
			session.update("skills.update",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	//삭제(delete)
	public void delete(SkillsDto dto) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			session.delete("skills.delete", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	
	//정보 리턴(select)
	public List<SkillsDto> getList(String id) {
		SqlSession session = null;
		List<SkillsDto> list = null;
		try {
			session = factory.openSession();
			list = session.selectList("skills.getList", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	//하나의 정보 리턴
	public SkillsDto getData(SkillsDto dto) {
		SqlSession session = null;
		SkillsDto resultDto = new SkillsDto();
		try {
			session = factory.openSession();
			resultDto = session.selectOne("skills.getData", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultDto;
	}

}
