package edu.autocar.mybatisex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.GoodsInfo;

public class GoodsInfoDaoImpl implements GoodsInfoDao {
	
	private static String namespace = "edu.autocar.mybatisex.dao.GoodsInfoDao.";
	
	SqlSession session;
	
	public GoodsInfoDaoImpl() {
		session = ConnectionProvider.getSqlSession();
	}
	
	@Override
	public List<GoodsInfo> selectList() throws Exception {
		return session.selectList(namespace + "selectList");
	}

	@Override
	public GoodsInfo selectOne(String code) throws Exception {
		return session.selectOne(namespace + "selectOne", code);
	}

	@Override
	public int insert(GoodsInfo goodsInfo) throws Exception {
		return session.insert(namespace + "insert", goodsInfo);
	}

	@Override
	public int update(GoodsInfo goodsInfo) throws Exception {
		return session.update(namespace + "update", goodsInfo);
	}

	@Override
	public int delete(String code) throws Exception {
		return session.delete(namespace + "delete", code);
	}

	@Override
	public int getCount() throws Exception {
		return session.selectOne(namespace + "getCount");
	}
	
	@Override
	public List<GoodsInfo> getPage(int start, int end) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return session.selectList(namespace + "getPage", map);
	}

}
