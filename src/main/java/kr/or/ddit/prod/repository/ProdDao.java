package kr.or.ddit.prod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.MybatisUtil;

public class ProdDao implements IProdDao {

	@Override
	public List<ProdVo> getProdList(String lprod_gu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<ProdVo> prodList = sqlSession.selectList("prod.getProdList", lprod_gu);		
		sqlSession.close();
		
		return prodList;
	}

}

