package edu.autocar.mybatisex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.Member;

public class MemberDaoImpl implements MemberDao {
	
	static final String namespace = "edu.autocar.mybatisex.dao.MemberDao.";
	
	SqlSession sqlSession;
	
	public MemberDaoImpl() {
		sqlSession = ConnectionProvider.getSqlSession();
	}
	
	@Override
	public int getCount() throws Exception {
		return sqlSession.selectOne(namespace + "getCount");
	}

	@Override
	public List<Member> selectList() throws Exception {
		return sqlSession.selectList(namespace + "selectList");
	}

	@Override
	public List<Member> getPage(int start, int end) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList(namespace + "getPage", map);
	}	

	@Override
	public Member selectOne(String userId) throws Exception {
		return sqlSession.selectOne(namespace + "selectOne", userId);
	}

	@Override
	public int insert(Member member) throws Exception {		
		return sqlSession.insert(namespace + "insert", member);
	}

	@Override
	public int update(Member member) throws Exception {		
		return sqlSession.update(namespace + "update", member);
	}

	@Override
	public int delete(String userId) throws Exception {
		return sqlSession.delete(namespace + "delete", userId);
	}

}
