package test.users.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.mybatis.SqlMapConfig;
import test.users.dto.TB_USERDto;

public class TB_USERDao {
	private static TB_USERDao dao;
	private static SqlSessionFactory factory;
	private TB_USERDao(){}
	public static TB_USERDao getInstance(){
		if(dao==null){
			dao=new TB_USERDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	
	// 회원 정보 저장 하는 메소드
	public void insert(TB_USERDto dto) {
		SqlSession session=factory.openSession(true);
		try {
			session.selectList("users.insert",dto);
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	// 회원정보 리스트
	public List<TB_USERDto> getList(TB_USERDto dto){
		SqlSession session=null;
		List<TB_USERDto> list=null;
		try {
			session=factory.openSession();
			list=session.selectList("users.getList",dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	// 로그인 
	public boolean isValid(TB_USERDto dto) {
		SqlSession session=factory.openSession();
		String id=null;
		try {
			id=session.selectOne("users.isValid",dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(id==null) {
			return false;
		}else {
			return true;
		}
	}
	
	// 한명의 정보 리턴
	public TB_USERDto getData(String id) {
		SqlSession session=factory.openSession();
		TB_USERDto dto = null;
		try {
			dto=session.selectOne("users.getData",id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
}
