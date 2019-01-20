package edu.autocar.tourguide.dao;

import java.util.List;

public interface CrudDao<T, K> {
	List<T> selectList() throws Exception;
	int insert(T t) throws Exception;
	int update(T t) throws Exception;
	int delete(K k) throws Exception;
}
