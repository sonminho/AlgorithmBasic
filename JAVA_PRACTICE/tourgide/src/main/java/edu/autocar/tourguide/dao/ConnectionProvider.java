package edu.autocar.tourguide.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <pre>
 * edu.autocar.tourguide.dao
 * 데이터베이스의 세션을 생성, 관리한다.
 * </pre>
 */
public class ConnectionProvider {
	private static SqlSession sqlSession;
	
	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSession;
	}
}
