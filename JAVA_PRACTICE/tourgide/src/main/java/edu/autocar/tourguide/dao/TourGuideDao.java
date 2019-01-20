package edu.autocar.tourguide.dao;

import java.util.List;

import edu.autocar.tourguide.domain.TourGuide;

public interface TourGuideDao extends CrudDao<TourGuide, String>, PaginationDao<TourGuide> {
	TourGuide selectNo(String tour_no) throws Exception;
	List<TourGuide> selectName(TourGuide t) throws Exception;
	List<TourGuide> selectCity(String city) throws Exception;
	List<String> getCity() throws Exception;
}
