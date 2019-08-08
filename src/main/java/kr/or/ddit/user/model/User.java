package kr.or.ddit.user.model;

public class User {
   private String userNm;   //사용자 이름
   private String userId;
   private String pass;
   
   public User() {
   }

   public User(String userName) {
      this.userNm = userName;
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
      return "UserVo [userName=" + userNm + ", userId=" + userId + ", pass=" + pass + "]";
   }
   
   public boolean checkLoginValidate(String userId, String pass) {
      return userId.equals(this.getUserId()) && pass.equals(this.getPass());
   }
   
}