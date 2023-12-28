package view;

import java.util.regex.Pattern;

public class CommonVIEW extends VIEW {

	public void printMenu() {
		System.out.println("2. 글쓰기");
		System.out.println("3. 판매글");
		System.out.println("4. 카메라리뷰");
		System.out.println("5. 카메라정보공유");
		System.out.println("6. 사진자랑게시판");
		System.out.println("7. 자유게시판");
		System.out.println("===========================");
	}

	public void printCategoryMenu() {
		System.out.println("1. 판매글");
		System.out.println("2. 카메라리뷰");
		System.out.println("3. 카메라정보공유");
		System.out.println("4. 사진자랑게시판");
		System.out.println("5. 자유게시판");
	}

	// 로그아웃뷰에는 ID중복체크 printInfo() 있음
	public void printInfo() {
		System.out.println("해당 메뉴는 로그인후에 이용하실수있습니다.");
	}

	// 회원가입, 회원탈퇴 둘다쓰여서 common에 둠
	public String inputUpw() {
		System.out.print("PW 입력해 주세요 >> ");
		String upw = sc.next();
		return upw;
	}

	// 문자열 입력받기
	public String inputString(String msg) {
		System.out.print(msg);
		return sc.next();
	}

	// 번호 입력받기 및 범위 유효성 검사
	public int inputNum(String msg, int min, int max) {
		System.out.print(msg); // min 최소값, max최대값을 사용자에게 출력하기 위해 사용된 변수
		String rangeStr;
		if (min == max) {
			rangeStr = "( " + min + " )";
		} else {
			rangeStr = "(" + min + " ~ " + max + ")";
		}
		System.out.print(rangeStr + " >> ");
		while (true) {
			try {
				int chooseNum = sc.nextInt();
				if (chooseNum >= min && chooseNum <= max) {
					return chooseNum;

				} else {
					System.out.print(rangeStr + " 입력 가능합니다. >>");
				}
			} catch (Exception e) {
				System.out.print("'정수'만 입력가능합니다. >>");
				sc.nextLine();
			}
		}
	}

	public void printNoData() {
		System.out.println("해당 정보는 없습니다...");
	}

	public void printSignup() {
		System.out.println("회원가입 되었습니다.");
	}

	public void printwithdraw() {
		System.out.println("탈퇴가 성공적으로 완료되었습니다.");
	}

	public void printLogin() {
		System.out.println("로그인 되었습니다.");
	}

	public void printLogout() {
		System.out.println("로그아웃 되었습니다.");
	}

	public void printLoginFail() {
		System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
	}

	public void printTrue() {
		System.out.println("성공!");
	}

	public void printFalse() {
		System.out.println("실패...");
	}

	public void printDatas(ArrayList<BoardDTO> datas) {
		if (datas == null || datas.size() <= 0) {
			System.out.println("출력할 데이터가 없습니다!");
		}
		for (BoardDTO data : datas) {
			System.out.println(data);
		}
	}

	public void printData(BoardDTO data) {
		if (data == null || data.getUid() == 0) {
			System.out.println("출력할 데이터가 없습니다!");
		}
		System.out.println(data);
	}

}
