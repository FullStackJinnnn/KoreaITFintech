package model;

import java.sql.Date; 

public class MemberDTO {
	private int memberNum; // PK
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String updateNickname; 
	// nickname만 세션에 저장하는 바람에 ...
	// nickname변경할때 매우힘들어서 생성 ㅜ	

	private Date birthday;
	private int ph;
	private String profile;
	private String grade;
	
	//유저닉네임으로 검색해서 마이페이지 가져오기
	//유저ID,PW 검색해서 로그인하기 
	//둘다 SelectOne 이다. 따라서 컨디션으로 구분
	private String searchCondition;
	

	
	public String getUpdateNickname() {
		return updateNickname;
	}
	
	public void setUpdateNickname(String updateNickname) {
		this.updateNickname = updateNickname;
	}
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
