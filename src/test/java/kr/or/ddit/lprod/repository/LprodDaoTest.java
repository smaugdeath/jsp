package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	private ILprodDao lprodDao;
	private SqlSession sqlSession;
	
	//테스트에 공통적으로 필요한 자원을 생성 / 초기화
	@Before
	public void setup() {
	   logger.debug("before");
	   lprodDao = new LprodDao();
	   sqlSession = MybatisUtil.getSession();
	}
	
	//테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
	   logger.debug("after");
	   sqlSession.close();
	}

	@Test
	public void getLprodListTest() {
		
		/***Given***/
		
		
		/***When***/
		List<LprodVo> lprodList = lprodDao.getLprodList(sqlSession);

		/***Then***/
		assertEquals(10, lprodList.size());

	}

	@Test
	public void getLprodPagingListTest() {
	/***Given***/
	Page page = new Page();
	page.setPage(1);
	page.setSize(5);
	
	/***When***/
	List<LprodVo> lprodList = lprodDao.getLprodPagingList(sqlSession, page);
	
	/***Then***/
	assertEquals(5, lprodList.size());
	assertEquals("P101", lprodList.get(0).getLprod_gu());

	}
	   
	@Test
	public void getLprodTotalCnt() {
	/***Given***/
	   

	/***When***/
	int totalCnt = lprodDao.getLprodTotalCnt(sqlSession);
	   
	/***Then***/
	assertEquals(10, totalCnt);
	}
}
