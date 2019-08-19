package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.repository.LprodDao;

/**
 * Servlet implementation class LprodListController
 */
@WebServlet("/lprodList")
public class LprodListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LprodDao lprodDao = new LprodDao();
		List<LprodVo> lprodList = lprodDao.getLprodList();
		
		request.setAttribute("lprodList", lprodList);
		
		request.getRequestDispatcher("/lprod/lprodList.jsp").forward(request, response);
		
	}

	

}
