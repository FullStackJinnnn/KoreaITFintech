package view;

import java.util.Scanner;

public class MemberView {
	private Scanner sc;

	public MemberView() {
		this.sc=new Scanner(System.in);
	}

	public String inputMemberID() {
		System.out.println("ID 입력 >>");
		String mid = sc.next();
		return mid;
	}
	public void logout() {
		System.out.print("로그아웃중");
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println();
		System.out.println("로그아웃 완료!");
	}
	
	public void LoginFalse() {
		System.out.println("LOGIN FAIL");
	}
	public void LoginTrue() {
		System.out.println("LOGIN SUCCESS");
	}

	public void signUpFalse() {
		System.out.println("중복되는 ID라서 사용불가");
	}

	public void signUpTrue() {
		System.out.println("회원가입 성공!");
	}

	public String inputMemberPasswd() {
		System.out.println("PW 입력 >>");
		String mpw = sc.next();
		return mpw;
	}
	
	public String inputMembmerName() {
		System.out.println("회원 이름 입력>>");
		String name = sc.next();
		return name;
	}
	
	public void printTrue() {
		System.out.println("SCUCESS");
	}

	public void printFalse() {
		System.out.println("FAIL");
	}
	
	public String inputPresentPW() {
		System.out.println("현재 비밀번호 입력");
		String mpw = sc.next();
		return mpw;
	}
	public String inputNewPw() {
		System.out.println("새 비밀번호 입력");
		String mpw = sc.next();
		return mpw;
	}
	public String inputNewPwAgain() {
		System.out.println("새 비밀번호 확인");
		String mpw = sc.next();
		return mpw;
	}
}
