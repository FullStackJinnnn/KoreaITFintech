package view;

import model.MemberDTO;

public class LogoutVIEW extends VIEW {
	
	public void printMenu() {
		System.out.println("6. 회원가입");
		System.out.println("7. 로그인");
	}
	
	public String inputIdnPw() {
		System.out.println("ID & PW 입력 >>");
		String idNPw = sc.next();
		return idNPw;
	}
	
	public String inputNamenGrade() {
		System.out.println("이름 & 등급 입력 >>");
		String nameNGrade = sc.next();
		return nameNGrade;
	}
	
	public void goodBye(MemberDTO data) {
		System.out.println(data.getName()+"님, 잘 가세요 :D");
	}
	
	
	
}
