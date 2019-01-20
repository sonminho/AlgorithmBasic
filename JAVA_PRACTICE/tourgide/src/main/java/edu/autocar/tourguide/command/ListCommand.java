package edu.autocar.tourguide.command;

import java.util.List;

import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.util.Input;
import edu.autocar.tourguide.util.Print;

/**
 * <pre>
 * edu.autocar.tourguide.command
 * 관광지 리스트출력 클래스이다.
 * 1. 전체출력
 * 2. 관광지 번호로 출력
 * 3. 관광지 이름로 출력
 * 4. 페이지네이션으로 출력
 * 5. 지역별로 출력
 * </pre>
 */
public class ListCommand implements Command {

	@Override
	public void execute() throws Exception {
		int option = Integer.parseInt(Input.getString("<[1] 전체 출력>, <[2] 관광지 번호>, <[3] 관광지 이름>,"
				+ " <[4] 페이지 조회>, <[5] 지역명> : "));
		
		switch(option) {
		case 1:
			selectAllLists(); 
			break;
		case 2:
			selectByNo();
			break;
		case 3:
			selectByName();
			break;
		case 4:
			selectPage();
			break;
		case 5:
			selectCity();
			break;
		default:
				return;
		}
	}

	private void selectCity() {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			List<String> cityList = dao.getCity();
			
			System.out.println();
			for(int i = 0; i < cityList.size(); i++) {
				System.out.println(" [ " + (i+1) + " ] "+ cityList.get(i));
			}
			
			int no = Integer.parseInt(Input.getString("\n선택 : "));
			System.out.println("\n" + cityList.get(no-1) + "을 선택하셨습니다.\n");
			
			List<TourGuide> tourList = dao.selectCity(cityList.get(no-1));
			Print.print(tourList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAllLists() {
		TourGuideDao dao = new TourGuideDaoImpl();

		try {
			List<TourGuide> list = dao.selectList();

			if(list.size() > 0) {
				Print.print(list);
			} else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByName() {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			String tourName = Input.getString("\n조회할 관광지 이름 : ");
			TourGuide t = new TourGuide();
			t.setTourName(tourName);
			
			List<TourGuide> list = dao.selectName(t);
			
			if(list.size() > 0) {
				Print.print(list);
			} else {
				System.out.println("\n조회할 항목이 없습니다.\n");
				return;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByNo() {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			String tourNo = Input.getString("\n조회할 관광지 번호 : ");
			TourGuide t = dao.selectNo(tourNo);
			
			if(t != null) {
				System.out.println("\n[관광지명] : " + t.getTourName());
				System.out.println("[위치] : " + t.getLocation());
				System.out.println("[내용] : " + t.getContent() + "\n");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectPage() {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try {
			int count = dao.getCount();
			int maxPage = count/10; // 10
			
			if(count%10 != 0)
				maxPage++;
			
			int page = 1;
						
			while(true) {
				System.out.println("\n현재 페이지 [" + page +"]\n");
				List<TourGuide> list = dao.getPage((page-1)*10 + 1, (page)*10);
								
				Print.print(list);
				
				String btn = Input.getString("<[P] 이전페이지>, <[N] 다음페이지>, <[Q] 종료> : ");
				
				switch(btn.toUpperCase()) {
				case("P"):
					page = page-1 >= 1 ? page-1 : 1;
					break;
				case("N"):
					page = page+1 <= maxPage ? page+1 : maxPage;
					break;
				case("Q"):
					System.out.println("페이지네이션을 종료합니다.\n");
					return;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
