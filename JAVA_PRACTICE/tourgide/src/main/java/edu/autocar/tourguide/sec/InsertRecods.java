package edu.autocar.tourguide.sec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import edu.autocar.tourguide.dao.ConnectionProvider;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

/**
 * <pre>
 * edu.autocar.tourguide.sec
 * 텍스트 파일을 읽어와
 * 파싱 후 데이터베이스에 추가, 커밋
 * </pre>
 */
public class InsertRecods {
	public static void main(String[] args) {
		TourGuideDao dao = new TourGuideDaoImpl();
		
		try(FileReader fr = new FileReader("C:/temp/tour100.txt");
				BufferedReader br = new BufferedReader(fr)) {
			
			String inLine = br.readLine();

			while((inLine = br.readLine()) != null) {
				inLine.replace("\"", "");
				StringTokenizer stk = new StringTokenizer(inLine, "\t");
				TourGuide t = new TourGuide();
				t.setTourName(stk.nextToken());
				t.setCity(stk.nextToken());
				t.setArea(stk.nextToken());
				t.setContent(stk.nextToken());
				t.setLocation(stk.nextToken());
				t.setHomePage(stk.nextToken());
				dao.insert(t);
				ConnectionProvider.getSqlSession().commit();
			}
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
