package edu.autocar.tourguide.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;
import edu.autocar.tourguide.util.Input;

/**
 * <pre>
 * edu.autocar.tourguide.command
 * 사용자로부터 여행 계획을 입력받아
 * 데이터베이스의 레코드 값들을 참조 후
 * 파일에 출력한다. 
 * </pre>
 */
public class ScheduleCommand implements Command{

	@Override
	public void execute() throws Exception {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		String title = Input.getString("[ 제목 ] : ");
		String schedule = Input.getString("[ 일정 ] : ");
		String travelDestination = Input.getString("[ 여행지 ] (ex. 1,5,7) : ");
		String fileName = Input.getString("[ 파일명 ] : ");
				
		try {
			StringTokenizer stkDst = new StringTokenizer(travelDestination, ",");
		
			int n = stkDst.countTokens();
			
			List<Integer> travelList = new ArrayList<>();
			HashSet<Integer> hashSet = new HashSet<>();
			
			while(n-- > 0) {
				hashSet.add(Integer.parseInt(stkDst.nextToken()));
			}
			
			Iterator<Integer> iterator = hashSet.iterator();
			
			while(iterator.hasNext()) {
				travelList.add(iterator.next());
			}
			
			BufferedWriter out = new BufferedWriter(new FileWriter("C:/temp/" + fileName + ".txt"));
			out.write(title+"\r\n");
			out.write(schedule+"\r\n");
			out.write(travelDestination+"\r\n");
			out.close();
			System.out.println("\n여행지 입력 완료\n");
			
			out = new BufferedWriter(new FileWriter("C:/temp/" + fileName + ".txt"));
			out.write("제목 : " + title + "\r\n");
			out.write("일정 : " + schedule + "\r\n");
			
			for(int i = 0; i < travelList.size(); i++) {
				TourGuide t = new TourGuide();
				t = dao.selectNo(travelList.get(i)+"");
				
				if(t != null) {
					out.write("===========================================\r\n");
					out.write("여행지 " + (t.getTourNo()) + "\r\n");
					out.write("위치" + t.getLocation() + "\r\n");
					out.write("관광지명 : " + t.getTourName() + "\r\n");
					out.write(t.getContent() + "\r\n");
					out.write("===========================================\r\n");
				}
			}
			out.close();
			System.out.println("\n여행 상세 내용 입력 완료\n");
		} catch(Exception e) {
			System.out.println("잘못된 여행지 입력입니다.");
			return;
		}
	}
}
