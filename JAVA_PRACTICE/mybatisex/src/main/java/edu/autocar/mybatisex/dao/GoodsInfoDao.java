package edu.autocar.mybatisex.dao;

import edu.autocar.mybatisex.database.CrudDao;
import edu.autocar.mybatisex.database.PaginationDao;
import edu.autocar.mybatisex.domain.GoodsInfo;

public interface GoodsInfoDao extends CrudDao<GoodsInfo, String>, PaginationDao<GoodsInfo>{

}
