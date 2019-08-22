package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;

/**
 * Servlet implementation class LprodPagingListController
 */
@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodService();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// page, pagesize 파라미터 받기
		String pageStr = request.getParameter("page");
		String pagesizeStr = request.getParameter("pagesize");
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pagesize = pagesizeStr == null ? 5 : Integer.parseInt(pagesizeStr);
		
		Page p = new Page(page, pagesize);
		request.setAttribute("pageVo", p);
		
		// lprodService 객체를 이용하여 getLprodPagingList를 호출
		// 반환된 사용자 리스트를 request객체에 속성으로 저장
		Map<String, Object> resultMap = lprodService.getLprodPagingList(p);
		List<LprodVo> lprodList = (List<LprodVo>)resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		
		// 조회된 사용자 리스트 정보를 html로 만들어줄 jsp로 요청 위임
		// webapp/lprod/lprodPagingList.jsp
		//			lprodList.jsp 복사
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
		
	}


}
