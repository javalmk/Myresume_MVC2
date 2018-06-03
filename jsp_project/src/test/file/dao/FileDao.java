package test.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.file.dto.FileDto;
import test.mybatis.SqlMapConfig;

public class FileDao {
	private static SqlSessionFactory factory;
	private static FileDao dao;
	private FileDao() {}
	//FileDao 객체를 리턴해주는 static 맴버 메소드
	public static FileDao getInstance() {
		if(dao==null) {
			dao=new FileDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}

	//파일의 정보를 삭제하는 메소드
	public void delete(String id) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			session.delete("file.delete", id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//파일의 정보를 리턴해주는 메소드
	public FileDto getData(String id) {
		SqlSession session=null;
		FileDto dto=null;
		try {
			session=factory.openSession();
			/*
			 *  parameterType : int
			 *  resultType : FileDto
			 */
			dto=session.selectOne("file.getData", id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	
	//파일 정보를 저장하는 메소드
	public void insert(FileDto dto) {
		SqlSession session=null;
		try {
			session=factory.openSession(true);
			/*
			 *  Mapper namespace : file
			 *  sql id : insert
			 *  parameterType : FileDto
			 */
			session.insert("file.insert", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	

}















