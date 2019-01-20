package edu.autocar.tourguide.command;

import edu.autocar.tourguide.dao.ConnectionProvider;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.util.Input;
import edu.autocar.tourguide.util.Print;

/**
 * <pre>
 * edu.autocar.tourguide.command
 * 사용자로부터 관광지 번호를 입력받아
 * 수정할 데이터의 값을 입력받고
 * 데이터베이스의 레코드값을 수정한다. 
 * </pre>
 */
public class UpdateCommand implements Command {

	@Override
	public void execute() throws Exception {
		TourGuideDao dao = new TourGuideDaoImpl();

		String tourNo = Input.getString("수정할 관광지 번호 : ");

		try {
			TourGuide t = dao.selectNo(tourNo);
			if (t != null) { // 수정할 관광지 존재
				Print.print(t);
				System.out.println("==================관광지 수정===============");

				String tourName = Input.getString("관광지명 : ");
				String city = Input.getString("도시명 : ");
				String area = Input.getString("지역명 : ");
				String content = Input.getString("내용 : ");
				String location = Input.getString("위치 : ");
				String homePage = Input.getString("홈페이지URL : ");
				
				t = TourGuide.builder()
						.tourNo(tourNo)
						.tourName(tourName)
						.city(city)
						.area(area)
						.content(content)
						.location(location)
						.homePage(homePage)
						.build();
								
				int result = dao.update(t);
				assert result == 1 : "수정에 실패히였습니다";
				ConnectionProvider.getSqlSession().commit();
				System.out.println("수정 성공");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
