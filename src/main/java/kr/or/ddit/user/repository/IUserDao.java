package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;

public interface IUserDao {
	
	/**
	* Method : getUserList
	* 작성자 : PC-24
	* 변경이력 :
	 * @param sqlSession 
	* @return
	* Method 설명 : 전체 사용자 리스트 조회
	*/
	List<User> getUserList(SqlSession sqlSession);

	/**
	* Method : getUser
	* 작성자 : PC-24
	* 변경이력 :
	 * @param sqlSession 
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	User getUser(SqlSession sqlSession, String userId);
	
	/**
	* Method : getUserListOnlyHalf
	* 작성자 : PC-24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 리스트중 50명 임의 조회
	*/
	List<User> getUserListOnlyHalf(SqlSession sqlSession);
	
}
