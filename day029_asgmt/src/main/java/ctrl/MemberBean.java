package ctrl;


import java.text.ParseException;
import java.text.SimpleDateFormat;

//여기는 ....DAO DTO로부터 데이터를 받아 
//필요한 메서드, 멤버변수를 선언해서 계산을 하는곳! 기능구현
//CTRL 같은 느낌 ..?
import model.MemberDAO;
import model.MemberDTO;

public class MemberBean {
	// 회원가입하려면 멤버변수 댕많이필요하다
	// 웹브라우저에 출력하기위한 msg 변수 하나선언~
	private int memberNum; // PK
	private String id;
	private String pw;
	private String updatePw;
	private String name;

	private String nickname;
	private String updateNickname;

	private String birthday;
	private int ph;
	private String profile;
	private String grade;
	
	private String msg = "";
	public String getUpdatePw() {
		return updatePw;
	}
	
	public void setUpdatePw(String updatePw) {
		this.updatePw = updatePw;
	}

	public String getUpdateNickname() {
		return updateNickname;
	}
	
	public void setUpdateNickname(String updateNickname) {
		this.updateNickname = updateNickname;
	}
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	// private String grade; -> grade는 쿼리문에 의해 '신입'으로 고정


	// 회원가입해서 DB에 데이터넣기!
	public boolean register() throws ParseException {
		
		// 회원가입창 들어갔을때, register.jsp 스스로에게 POST방식으로 전달하기 때문에
		// 처음 입력안된 상태가 INSERT가 되어버려 cannot insert NULL 에러가 나온다.
		MemberDAO mDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();

		if (id == null) {
			msg = "";
			return false;
		}
		String birth = birthday;
		System.out.println(birth);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date parsedDate = format.parse(birthday);
		System.out.println(parsedDate);
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		System.out.println(sqlDate);
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setNickname(nickname);
		memberDTO.setBirthday(sqlDate);
		memberDTO.setPh(ph);
		memberDTO.setProfile(profile);
		memberDTO.setGrade(grade);
		System.out.println(memberDTO);
		boolean flag = mDAO.insert(memberDTO);
		if (!flag) {
			msg = "<font color='green'>회원가입 실패 :(</font>";
			return false;
		} else {
			msg = "<font color='red'>회원가입 성공! :D</font>";
			return true;
		}

	}

	public MemberDTO login() {
		MemberDAO mDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setSearchCondition("login");
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO = mDAO.selectOne(memberDTO);
		if (memberDTO == null) {
			msg = "<font color='red'>로그인 실패</font>";
			return memberDTO;
		} else {
			msg = "<font color='green'로그인성공~ :D</font>";
			return memberDTO;
		}

	}

	public MemberDTO myInfo() {
		MemberDAO mDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setSearchCondition("userCheck");
		memberDTO.setNickname(nickname);
		memberDTO = mDAO.selectOne(memberDTO);
		return memberDTO;
	}
	
	

	public boolean updateNickname() {
		if (updateNickname == null) {
			msg = "";
			return false;
		}
		MemberDAO mDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		MemberDTO data = new MemberDTO();
		memberDTO.setSearchCondition("userCheck");
		memberDTO.setNickname(updateNickname);
		data = mDAO.selectOne(memberDTO);
		if (data == null) {
			memberDTO.setNickname(nickname);
			memberDTO.setUpdateNickname(updateNickname);
			memberDTO.setSearchCondition("updateNickname");
 			mDAO.update(memberDTO);
			return true;
		} else {
			msg = "<font color='red'>중복된 닉네임</font>";
			System.out.println(msg);
			return false;
		
		}
	}
	
	public int updatePw() {
		if (pw == null) {
			msg = "";
			return -1;
		}
		MemberDAO mDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		MemberDTO data = new MemberDTO();
		memberDTO.setSearchCondition("userCheck");
		memberDTO.setNickname(nickname);
		data=mDAO.selectOne(memberDTO);
		memberDTO.setPw(pw);
		if (memberDTO.getPw().equals(data.getPw())) {
			memberDTO.setSearchCondition("updatePw");
			memberDTO.setPw(updatePw);
			boolean flag = mDAO.update(memberDTO);
			if (!flag) {
				msg = "<font color='red'>틀린 비밀번호</font>";
				return 0;
			} else {
				msg = "<font color='red'>변경 성공</font>";
				return 1;
			}
		}
		return 0;
	}

	public boolean withdraw() {
		if (pw == null) {
			msg = "";
			return false;
		}
		MemberDAO mDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setSearchCondition("withdraw");
		memberDTO.setNickname(nickname);
		memberDTO.setPw(pw);
		boolean flag = mDAO.update(memberDTO);
		if (!flag) {
			msg = "<font color='red'>틀린 비밀번호</font>";
			return false;
		} else {
			msg = "<font color='red'>탈퇴 성공</font>";
			return true;
		}
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MemberBean [memberNum=" + memberNum + ", id=" + id + ", pw=" + pw + ", updatePw=" + updatePw + ", name="
				+ name + ", nickname=" + nickname + ", updateNickname=" + updateNickname + ", birthday=" + birthday
				+ ", ph=" + ph + ", profile=" + profile + ", grade=" + grade + ", msg=" + msg + "]";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
