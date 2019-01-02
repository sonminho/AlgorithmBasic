package edu.autocar.mybatisex.dao;

import edu.autocar.mybatisex.database.CrudDao;
import edu.autocar.mybatisex.database.PaginationDao;
import edu.autocar.mybatisex.domain.Member;

public interface MemberDao extends CrudDao<Member, String>, PaginationDao<Member>{
	
}
