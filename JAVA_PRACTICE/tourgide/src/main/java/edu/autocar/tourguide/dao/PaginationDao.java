package edu.autocar.tourguide.dao;

import java.util.List;

public interface PaginationDao<T> {
	int getCount() throws Exception;
	List<T> getPage(int start, int end) throws Exception;
}
