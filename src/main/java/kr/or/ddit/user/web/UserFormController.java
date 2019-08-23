package kr.or.ddit.user.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;


@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = LoggerFactory.getLogger(UserFormController.class);
   private IUserService userService;
   private Date reg_dt;
   
   @Override
   public void init() throws ServletException {
      userService = new UserService();
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
   }

   /**
   * Method : doPost
   * 작성자 : PC-13
   * 변경이력 :
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   * Method 설명 : 사용자 등록 요청
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("utf-8");
      
      try {
         reg_dt = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("reg_dt"));
      } catch (ParseException e) {
         e.printStackTrace();
      }
      
      String userId = request.getParameter("userId");
      String userNm = request.getParameter("userNm");
      String alias = request.getParameter("alias");
      Date reg_dt_date = reg_dt;
      String addr1 = request.getParameter("addr1");
      String addr2 = request.getParameter("addr2");
      String zipcode = request.getParameter("zipcode");
      String pass = request.getParameter("pass");
      
      Pattern p = Pattern.compile("^[a-zA-Z\\d\\.@]{5,20}$");
      
      Matcher m = p.matcher(userId);
      if(!m.find()) {
         request.setAttribute("userIdMsg", "사용자아이디가 잘못 되었습니다");
         doGet(request, response);
      }else {
      
   //      logger.debug("user parameter : {},{},{},{},{},{},{},{}", userId,userNm,alias,reg_dt_date,addr1,addr2,zipcode,pass);
         
         User user = new User(userId,userNm,alias,reg_dt_date,addr1,addr2,zipcode,pass);
         int insertCnt = 0;
         
         try {
            insertCnt = userService.insertUser(user);
            //정상: 사용자 상세화면
            if(insertCnt == 1) {
               //request.getRequestDispatcher("/user").forward(request, response);
               response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
            }
         }catch(Exception e) {
            doGet(request, response);
            
         }
      
      }
   }
}