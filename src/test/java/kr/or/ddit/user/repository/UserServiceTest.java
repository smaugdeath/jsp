package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

public class UserServiceTest {
	
	private IUserService userService;
	
	@Before
	public void setup() {
		userService = new UserService();
	}

	  /**
	   * Method : test
	   * 작성자 : PC-13
	   * 변경이력 :
	   * Method 설명 : getUserList 테스트
	    */
	   @Test
	   public void test() {
	      /***Given***/

	      /***When***/
	      List<User> userList = userService.getUserList();
	      
	      /***Then***/
	      assertEquals(105, userList.size());
	   }
	   /**
	   * Method : getUserTest
	   * 작성자 : PC-13
	   * 변경이력 :
	   * Method 설명 : 사용자 정보 조회 테스트
	    */
	   @Test
	   public void getUserTest() {
	      /***Given***/
	      String userId = "brown";

	      /***When***/
	      User userVo = userService.getUser(userId);
	      
	      /***Then***/
	      assertEquals("브라운", userVo.getUserNm());
	      assertEquals("brown1234", userVo.getPass());
	   }
	   
	   @Test
	   public void getUserListOnlyHalfTest() {
	      /***Given***/
	      
	      /***When***/
	      List<User> list = userService.getUserListOnlyHalf();
	      
	      /***Then***/
	      assertEquals(50, list.size());
	   }

}
