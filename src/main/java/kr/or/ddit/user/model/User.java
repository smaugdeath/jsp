package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
   private static final Logger logger = LoggerFactory.getLogger(User.class);
   private String userNm; // 사용자 이름
   private String userId;
   private String pass;
   private String alias;
   private Date reg_dt;
   private String addr1;
   private String addr2;
   private String zipcode;
   
   public User() {
   }
   
   public User(String userId, String userNm, String alias, Date reg_dt_date, String addr1, String addr2,
         String zipcode, String pass) {
      this.userNm = userNm;
      this.userId = userId;
      this.alias = alias;
      this.reg_dt = reg_dt_date;
      this.addr1 = addr1;
      this.addr2 = addr2;
      this.zipcode = zipcode;
      this.pass = pass;
   }

   public User(String userName) {
      this.userNm = userName;
   }
   
   public String getAddr1() {
      return addr1;
   }

   public void setAddr1(String addr1) {
      this.addr1 = addr1;
   }

   public String getAddr2() {
      return addr2;
   }

   public void setAddr2(String addr2) {
      this.addr2 = addr2;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getAlias() {
      return alias;
   }

   public void setAlias(String alias) {
      this.alias = alias;
   }

   public Date getReg_dt() {
      return reg_dt;
   }
   
   public String getReg_dt_fmt() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      return sdf.format(reg_dt);
   }

   public void setReg_dt(Date reg_dt) {
      this.reg_dt = reg_dt;
   }


   public String getUserNm() {
      return userNm;
   }

   public void setUserNm(String userName) {
      userNm = userName;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getPass() {
      return pass;
   }

   public void setPass(String pass) {
      this.pass = pass;
   }

   @Override
   public String toString() {
      return "User [userNm=" + userNm + ", userId=" + userId + ", pass=" + pass + ", alias=" + alias + ", reg_dt="
            + reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + "]";
   }

   public boolean checkLoginValidate(String userId, String pass) {
      return userId.equals(this.getUserId()) && pass.equals(this.getPass());
   }

}