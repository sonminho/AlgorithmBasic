package edu.autocar.tourgide;

import java.util.List;

import org.junit.Test;

import edu.autocar.tourguide.dao.ConnectionProvider;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.util.Input;

public class TourGuideDaoTest {

	public void insertTest() {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			System.out.println("============데이터 추가하기===========");
			String tourName = Input.getString("관광지명 : ");
			String city = Input.getString("도시명 : ");
			String area = Input.getString("지역명 : ");
			String content = Input.getString("내용 : ");
			String location = Input.getString("위치 : ");
			String homePage = Input.getString("홈페이지URL : ");
			
			TourGuide t = TourGuide.builder()
					.tourName(tourName)
					.city(city)
					.area(area)
					.content(content)
					.location(location)
					.homePage(homePage)
					.build();
			int result = dao.insert(t);
			assert result == 1 : "데이터 추가 실패";
			System.out.println("데이터를 성공적으로 추가하였습니다.");
			ConnectionProvider.getSqlSession().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectListTest() {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			List<TourGuide> list = dao.selectList();
			
			for(TourGuide t : list) {
				System.out.println(t);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectOneTest() { // 관광지 번호로 검색(중복 X)
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			String tourNo = Input.getString("조회할 관광지 번호 : ");
			TourGuide t = dao.selectNo(tourNo);
			
			if(t != null)
				System.out.println(t);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTest() {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			
			String tourNo = Input.getString("수정할 관광지 번호 입력 : ");
			
			TourGuide t = dao.selectNo(tourNo);
			System.out.println(t.getTourName());
			System.out.println(t.getCity());
			System.out.println(t.getArea());
			System.out.println(t.getContent());
			System.out.println(t.getLocation());
			System.out.println(t.getHomePage());
			System.out.println("==================관광지 수정하기===============");
			
			String tourName = Input.getString("관광지명 : ");
			String city = Input.getString("도시명 : ");
			String area = Input.getString("지역명 : ");
			String content = Input.getString("내용 : ");
			String location = Input.getString("위치 : ");
			String homePage = Input.getString("홈페이지URL : ");
			
			TourGuide newTourGuide = TourGuide.builder()
					.tourNo(tourNo)
					.tourName(tourName)
					.city(city)
					.area(area)
					.content(content)
					.location(location)
					.homePage(homePage)
					.build();
			
			int result = dao.update(newTourGuide);
			assert result == 1 : "수정 실패하였습니다.";
			ConnectionProvider.getSqlSession().commit();
			System.out.println("수정 완료!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTest() {

		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			String tourNo = Input.getString("삭제할 관광지 번호 : ");
			int result = dao.delete(tourNo);
			assert result == 1 : "삭제 실패하였습니다.";
			ConnectionProvider.getSqlSession().commit();
			System.out.println("성공적으로 삭제되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getCount() {

		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			int count = dao.getCount();
			System.out.println("총 " + count + "개의 행이 존재합니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getPageTest() {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			System.out.println("페이지네이션을 실행합니다.");
			int start = Integer.parseInt(Input.getString("시작 번호 : "));
			int end = Integer.parseInt(Input.getString("끝 번호 : "));
			List<TourGuide> list = dao.getPage(start, end);
			
			if(list.size() > 0) {
				for(TourGuide t : list) {
					System.out.println(t);
				}
			} else {
				System.out.println("행이 존재하지 않습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
