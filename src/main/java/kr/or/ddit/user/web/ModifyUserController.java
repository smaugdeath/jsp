package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileuploadUtil;

/**
 * Servlet implementation class ModifyUserController
 */
@WebServlet("/modifyUser")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class ModifyUserController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = LoggerFactory.getLogger(ModifyUserController.class);
    private IUserService service;
    private Date reg_dt;
    
    @Override
      public void init() throws ServletException {
       service = new UserService();
      }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String userId = request.getParameter("userId");
      
      User user = service.getUser(userId);
      
      request.setAttribute("user", user);
      
      request.getRequestDispatcher("/user/modifyUser.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      Part picture = request.getPart("picture");
      
      String userId = request.getParameter("userId");
      User prePath = service.getUser(userId);
      
      //사용자가 파일을 업로드한 경우
      String filename = "";
      String path = "";
      if(picture.getSize()>0) {
         filename = FileuploadUtil.getFilename(picture.getHeader("Content-Disposition"));   //사용자가 업로드한 파일명
         String realFilename = UUID.randomUUID().toString();
         String ext = FileuploadUtil.getFileExtension(picture.getHeader("Content-Disposition"));
         path = FileuploadUtil.getPath() + realFilename + ext;
         
         picture.write(path);
         
         File file = new File(prePath.getRealfilename());
         
         file.delete();
         
      }else {
           filename = prePath.getFilename();
           path = prePath.getRealfilename();
      }
      
      try {
         reg_dt = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("reg_dt"));
      } catch (ParseException e) {
         e.printStackTrace();
      }
      
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
         
         User user = new User(userId,userNm,alias,reg_dt_date,addr1,addr2,zipcode,pass,filename,path);
         int insertCnt = 0;
         
         try {
            insertCnt = service.modifyUser(user);
            //정상: 사용자 상세화면
            if(insertCnt == 1) {
               //request.getRequestDispatcher("/user").forward(request, response);
               response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
            }
         }catch(Exception e) {
            e.printStackTrace();
            doGet(request, response);
         }
      
      }
   }

}