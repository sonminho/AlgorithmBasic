package edu.autocar.mybatisex;

import java.util.List;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import edu.autocar.mybatisex.dao.GoodsInfoDao;
import edu.autocar.mybatisex.dao.GoodsInfoDaoImpl;
import edu.autocar.mybatisex.domain.GoodsInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 메서드 이름 순으로 테스트를 진행하도록 하는 어노테이션
public class GoodsInfoTest {
	@Test
	public void t1getCountTest() throws Exception {
		GoodsInfoDao dao = new GoodsInfoDaoImpl();
		
		try {
			int result = dao.getCount();
			assert result > 0 : "전체 행 개수 추출 실패";
			System.out.println(result + "행이 존재합니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t2selectTest() throws Exception {
		GoodsInfoDao dao = new GoodsInfoDaoImpl();
		
		try {
			List<GoodsInfo> list = dao.selectList();
			for(GoodsInfo goodsInfo : list) {
				System.out.println(goodsInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectOneTest() throws Exception {
		GoodsInfoDao dao = new GoodsInfoDaoImpl();
		
		try {
			GoodsInfo gInfo = dao.selectOne("10004");
			System.out.println(gInfo);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void t3insertTest() throws Exception {
		GoodsInfoDao dao = new GoodsInfoDaoImpl();
		
		try {
			GoodsInfo gInfo = GoodsInfo.builder()
					.code("10011")
					.name("에어팟")
					.price(19800)
					.maker("애플")
					.build();
			int result = dao.insert(gInfo);
			assert result == 1 : "데이터 추가 실패";
			System.out.println("데이터 추가 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t4updateTest() throws Exception {
		GoodsInfoDao dao = new GoodsInfoDaoImpl();
		
		try {
			GoodsInfo gInfo = GoodsInfo.builder()
					.code("10011")
					.name("에어팟2세대")
					.price(19800)
					.maker("애플")
					.build();
			int result = dao.update(gInfo);
			assert result == 1 : "데이터 수정 실패";
			System.out.println("데이터 수정 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void t5deleteTest() throws Exception {
		GoodsInfoDao dao = new GoodsInfoDaoImpl();
		
		try {
			int result = dao.delete("10011");
			assert result == 1 : "데이터 삭제 실패";
			System.out.println("데이터 삭제 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void t6getPage() throws Exception {
		GoodsInfoDao dao = new GoodsInfoDaoImpl();
		
		try {
			List<GoodsInfo> gList = dao.getPage(3, 6);
			assert gList.size() > 0 : "페이지 네이션 실패";
			for(GoodsInfo gInfo : gList) {
				System.out.println(gInfo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@After
	public void afterTest() {
		System.out.println("================================================================");
	}
}
