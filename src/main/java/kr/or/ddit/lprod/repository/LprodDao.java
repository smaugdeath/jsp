package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodDao implements ILprodDao{
	
	

	@Override
	public List<LprodVo> getLprodList(SqlSession sqlSession) {
		
		List<LprodVo> lprodList = sqlSession.selectList("lprod.getLprodList");		
		
		return lprodList;
	}

	@Override
	public List<LprodVo> getLprodPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}

	@Override
	public int getLprodTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("lprod.getLprodTotalCnt");
	}


}
