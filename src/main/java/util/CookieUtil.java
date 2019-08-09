package util;

public class CookieUtil {
   
   public static String getCookie(String cookieString, String cookieId) {
      String[] strArr = cookieString.split(";");
      
      String str = "";
      for(String e : strArr) {
         String temp = e.substring(0, e.indexOf("=")).trim();
         if(temp.equals(cookieId)) {
            str = e.substring(e.indexOf("=")+1).trim();
            break;
         }
         str = null;
      }
      return str;
   }

}