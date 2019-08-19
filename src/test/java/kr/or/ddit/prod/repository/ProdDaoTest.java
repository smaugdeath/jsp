package kr.or.ddit.prod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.prod.model.ProdVo;

public class ProdDaoTest {
	
	@Test
	public void getProdListTest() {
		
		/***Given***/
		IProdDao prodDao = new ProdDao();

		/***When***/
		List<ProdVo> prodList = prodDao.getProdList("P101");

		/***Then***/
		assertEquals(6, prodList.size());

	}

}
