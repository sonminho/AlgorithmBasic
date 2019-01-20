package edu.autocar.tourguide.service;

import edu.autocar.tourguide.command.Command;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

public class TourService {

	TourGuideDao dao = new TourGuideDaoImpl();
	TourGuide t = new TourGuide();

	Command command = this::exit;
	
	public void exit() {
		System.out.println("종료합니다.");
		System.exit(0);
	}
}
