package kr.or.ddit.user.model;

public class UserVo {
	private String usernm; // 사용자 이름
	private String userid; 
	private String pass; 
	
	public UserVo() {
		
	}
	
	
	public UserVo(String userName) {
		this.usernm = userName;
	}

	public String getUserNm() {
		return usernm;
	}

	public void setUserNm(String userName) {
		this.usernm = userName;
	}

	public String getUserId() {
		return userid;
	}

	public void setUserId(String userId) {
		this.userid = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserVo [usernm=" + usernm + ", userid=" + userid + ", pass=" + pass + "]";
	}

	
	
}
