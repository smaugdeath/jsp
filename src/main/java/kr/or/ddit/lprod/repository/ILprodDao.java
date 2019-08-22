package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;

public interface ILprodDao {
	
	List<LprodVo> getLprodList(SqlSession sqlSession);
	
	List<LprodVo> getLprodPagingList(SqlSession sqlSession, Page page);
	
	int getLprodTotalCnt(SqlSession sqlSession);
	

}
