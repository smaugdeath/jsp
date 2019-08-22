package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;

public class LprodServiceTest {
	
	private ILprodService lprodService;
	
	@Before
	public void setup() {
		lprodService = new LprodService();
	}

	@Test
	public void getLprodListTest() {
	/***Given***/
	

	/***When***/
	List<LprodVo> lprodList = lprodService.getLprodList();

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
	Map<String, Object> resultMap = lprodService.getLprodPagingList(page); 
	List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
	int paginationSize = (Integer) resultMap.get("paginationSize");

	/***Then***/
	assertEquals(5, lprodList.size());
	assertEquals(2, paginationSize);
	}

}
