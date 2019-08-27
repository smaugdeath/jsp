package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public class UserDao implements IUserDao{

	/**
	* Method : getUserList
	* 작성자 : PC-24
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	@Override
	public List<User> getUserList(SqlSession sqlSession) {
		//db에서 조회가 되었다고 가정하고 가짜 객체를 리턴
		/*
		List<UserVo> userList = new ArrayList<UserVo>();
		userList.add(new UserVo("brown"));
		userList.add(new UserVo("cony"));
		userList.add(new UserVo("sally"));
		userList.add(new UserVo("moon"));
		userList.add(new UserVo("james"));
		*/
		
		
		List<User> userList = sqlSession.selectList("user.getUserList");		
		
		return userList;
	}

	/**
	* Method : getUser
	* 작성자 : PC-24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : userId를 갖는 사용자 정보 조회
	*/
	@Override
	public User getUser(SqlSession sqlSession, String userId) {
		User userVo = sqlSession.selectOne("user.getUser", userId);
		
		return userVo;
	}

	@Override
	public List<User> getUserListOnlyHalf(SqlSession sqlSession) {
		List<User> userListOnlyHalf = sqlSession.selectList("user.getUserListOnlyHalf");		
		
		return userListOnlyHalf;
	}

	/**
	* Method : getUserPagingList
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Override
	public List<User> getUserPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("user.getUserPagingList", page);
	}

	/**
	* Method : getUserTotalCnt
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 전체 사용자 건수 조회
	*/
	@Override
	public int getUserTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("user.getUserTotalCnt");
	}
	
	/**
	* Method : insertUser
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param user
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(SqlSession sqlSession, User user) {
		int cnt = sqlSession.insert("user.insertUser", user);
		return cnt;
	}

	/**
	* Method : deleteUser
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/	
	@Override
	public int deleteUser(SqlSession sqlSession, String userId) {
		return sqlSession.delete("user.deleteUser", userId);
		
	}

	/**
	* Method : modifyUser
	* 작성자 : PC-24
	* 변경이력 :
	* @param sqlSession
	* @param user
	* @return
	* Method 설명 : 사용자 정보 수정
	*/
	@Override
	public int modifyUser(SqlSession sqlSession, User user) {
		int cnt = sqlSession.update("user.modifyUser", user);
		return cnt;
	}
	
	
	
	

}
