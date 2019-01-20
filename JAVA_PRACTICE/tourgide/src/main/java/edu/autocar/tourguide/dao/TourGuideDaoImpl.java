package edu.autocar.tourguide.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.tourguide.domain.TourGuide;

public class TourGuideDaoImpl implements TourGuideDao{
	private static String namespace = "edu.autocar.tourguide.dao.TourGuideDao.";
	
	SqlSession session;
	
	public TourGuideDaoImpl() {
		session = ConnectionProvider.getSqlSession();
	}
	
	@Override
	public List<TourGuide> selectList() throws Exception {
		return session.selectList(namespace + "selectList");
	}

	@Override
	public TourGuide selectNo(String tourNo) throws Exception {
		return session.selectOne(namespace + "selectNo", Integer.parseInt(tourNo));
	}

	@Override
	public List<TourGuide> selectName(TourGuide t) throws Exception {
		return session.selectList(namespace + "selectName", t);
	}
	
	@Override
	public List<String> getCity() throws Exception {
		return session.selectList(namespace + "getCity");
	}
	
	@Override
	public int insert(TourGuide tourGuide) throws Exception {
		return session.insert(namespace + "insert", tourGuide);
	}

	@Override
	public int update(TourGuide tourGuide) throws Exception {
		return session.update(namespace + "update", tourGuide);
	}

	@Override
	public int delete(String tourNo) throws Exception {
		return session.delete(namespace + "delete", Integer.parseInt(tourNo));
	}

	@Override
	public int getCount() throws Exception {
		return session.selectOne(namespace + "getCount");
	}

	@Override
	public List<TourGuide> getPage(int start, int end) throws Exception {
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		return session.selectList(namespace + "getPage", map);
	}

	
	@Override
	public List<TourGuide> selectCity(String city) throws Exception {
		return session.selectList(namespace + "selectCity", city);
	}

	

}
