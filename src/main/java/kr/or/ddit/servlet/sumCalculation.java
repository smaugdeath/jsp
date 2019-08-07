package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      int start = Integer.parseInt(request.getParameter("start"));
      int end = Integer.parseInt(request.getParameter("end"));
      
      int result = 0;
      for(int i=Math.min(start, end); i<=Math.max(start, end); i++) {
         result += i;
      }
      
      logger.debug("sumResult : {}", result);
      
      HttpSession session = request.getSession();
      session.setAttribute("sumResult", result);
      
      request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
   }

}