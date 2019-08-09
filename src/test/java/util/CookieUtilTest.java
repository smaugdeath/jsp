package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {
   
   /**
   * Method : test
   * 작성자 : PC-13
   * 변경이력 :
   * Method 설명 : 쿠키 가져오기 테스트
    */
   @Test
   public void test() {
      /***Given***/
      String cookieString = "userId=brown; rememberMe=Y; test=testValue";
      
      /***When***/
      String userIdCookieValue = CookieUtil.getCookie(cookieString, "userId");
      String rememberMeCookieValue = CookieUtil.getCookie(cookieString, "rememberMe");
      String testCookieValue = CookieUtil.getCookie(cookieString, "test");
      String notExistsCookieValue = CookieUtil.getCookie(cookieString, "notExists");
      
      /***Then***/
      assertEquals("brown", userIdCookieValue);
      assertEquals("Y", rememberMeCookieValue);
      assertEquals("testValue", testCookieValue);
      assertEquals(null, notExistsCookieValue);
   }
}