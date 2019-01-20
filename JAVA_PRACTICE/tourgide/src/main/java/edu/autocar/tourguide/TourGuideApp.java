package edu.autocar.tourguide;

import edu.autocar.tourguide.command.ListCommand;
import edu.autocar.tourguide.command.ScheduleCommand;
import edu.autocar.tourguide.command.UpdateCommand;
import edu.autocar.tourguide.menu.MenuBar;
import edu.autocar.tourguide.menu.MenuItem;
import edu.autocar.tourguide.service.TourService;

/**
 * @author 손민호
 * <pr>
 * TourGuide 애플리케이션 클래스
 * 운영에 필요한 메뉴를 구성하고, 메뉴 명령을 실행하는 애플리케이션이 기동됨
 * </pr> 
 */
public class TourGuideApp extends App {
	TourService service;
	
	TourGuideApp() {
		super();
	}
	
	@Override
	protected void createMenu(MenuBar menubar) {
		//menubar.add(new MenuItem("종료", "E", new ExitCommand()));
		//menubar.add(new MenuItem("종료", "E", () -> {System.exit(0);} ));
		//menubar.add(new MenuItem("종료", "E", this::exit)); // 메서드 참조
		menubar.add(new MenuItem("종료", "E", service::exit)); // 메서드 참조
		menubar.add(new MenuItem("목록", "L", new ListCommand()));		
		menubar.add(new MenuItem("수정", "U", new UpdateCommand()));
		menubar.add(new MenuItem("스케쥴", "H", new ScheduleCommand()));
//		Runnable exitCommand = this::exit;		
//		try {
//			exitCommand.run();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	/* (non-Javadoc)
	 * @see edu.autocar.tourguide.App#init()
	 */
	@Override
	protected void init() {
		service = new TourService();
	}
	
	/**
	 * 애플리케이션 종료 메서드
	 * 데이터베이스 연결을 끊어준다.
	 */
	public void exit() {
		System.out.println("종료합니다.");
		System.exit(0);
	}
	
	public static void main(String[] args) throws Exception {
		App app = new TourGuideApp();
		app.run();
	}
}
