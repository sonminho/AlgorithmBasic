package edu.autocar.mybatisex;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.mybatisex.database.ConnectionProvider;

public class SessionTest {
	
	public static void main(String[] args) {
		SqlSession session = ConnectionProvider.getSqlSession();
		
		/*
		 * if(session != null) { System.out.println("세션 생성 성공"); } else {
		 * System.out.println("세션 생성 실패"); }
		 */
		
		assert session != null : "세션 생성 실패";
		
		System.out.println("세션 생성 성공");
		session.close();
	}
	
}
