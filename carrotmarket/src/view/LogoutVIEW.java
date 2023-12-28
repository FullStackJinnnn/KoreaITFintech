package view;

import java.util.regex.Pattern;

public class LogoutVIEW extends VIEW {

	public void printMenu() {
		System.out.println("========메인 메뉴 출력========");
		System.out.println("1. 로그인");
	}

	// 이메일 형식
	public String inputUid() {
		while (true) {
			System.out.print("ID를 입력해 주세요 >> ");
			String uid = sc.next();
			boolean isEmail = Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", uid);
			if (!isEmail) {
				System.out.println("옳바른 이메일이 아닙니다.");
			} else {
				return uid;
			}
		}
	}

	public void printInfo() {
		System.out.println("중복되는 ID입니다. 다시 입력해주세요.");
	}

	public String inputName() {
		while (true) {
			System.out.print("이름을 입력해 주세요 >> ");
			String name = sc.next();
			boolean isOnlyKr = Pattern.matches("^[a-zA-Z가-힣]*$", name);
			if (!isOnlyKr) {
				System.out.println("문자만 입력해 주세요.");
			} else {
				return name;
			}
		}
	}

	public String inputNickName() {
		while (true) {
			System.out.print("닉네임을 입력해 주세요 >> ");
			String nickName = sc.next();
			boolean isOnlyNonSpecialChar = Pattern.matches("^[0-9a-zA-Zㄱ-ㅎ가-힣]*$", nickName);
			if (!isOnlyNonSpecialChar) {
				System.out.println("특수문자가 포함되어 있습니다.");
			} else {
				return nickName;
			}
		}
	}

	// 1900~2023년생까지
	public int inputBirhday() {
		while (true) {
			System.out.print("생년월일을 입력해 주세요 (예: 19900101) >> ");

			String birthday = sc.next();// 1900년 부터~ 2024년 까지
			boolean isBirthday = Pattern.matches("^(19[0-9][0-9]|20[0-2][0-4])(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])$",
					birthday);
			if (!isBirthday) {
				System.out.println("옳바른 생년월일이 아닙니다.");
			} else {
				return Integer.parseInt(birthday);
			}
		}
	}

	public int inputPhoneNumber() {
		while (true) {
			System.out.print("전화번호를 입력해 주세요 >> ");

			String phoneNumber = sc.next();
			boolean isPhoneNumber = Pattern.matches("^010(?:\\d{3}|\\d{4})\\d{4}$", phoneNumber);
			if (!isPhoneNumber) {
				System.out.println("옳바른 전화번호가 아닙니다.");
			} else {
				return Integer.parseInt(phoneNumber);
			}
		}
	}

	public String inputAddress() {
		System.out.print("주소를 입력해 주세요 >> ");
		String address = sc.next();
		return address;
	}

}
