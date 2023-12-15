package model;

public class MemberDTO {
	// PK란? 시스템이 부여하는 값
	// 유일한 값이어야함!!!!!
	
	// ID의 경우, 사용자가 생성함
	// "ID 중복검사"
	private String mid; // PK
	private String mpw;
	private String name;
	private String mpwCheck;
	
	
	public String getMpwCheck() {
		return mpwCheck;
	}
	public void setMpwCheck(String mpwCheck) {
		this.mpwCheck = mpwCheck;
	}
	private String searchCondition;
	
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ID =" + mid + "PW =" + mpw + ", 이름 =" + name + "]";
	}
}
