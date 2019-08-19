package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.repository.ProdDao;

/**
 * Servlet implementation class ProdListController
 */
@WebServlet("/prodList")
public class ProdListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdDao prodDao = new ProdDao();
		//parameter
		String lprod_gu = request.getParameter("lprod_gu");
		
		List<ProdVo> prodList = prodDao.getProdList(lprod_gu);
		
		request.setAttribute("prodList", prodList);
		
		request.getRequestDispatcher("/prod/prodList.jsp").forward(request, response);
	}

}
