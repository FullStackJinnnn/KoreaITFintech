package view;

import java.util.regex.Pattern;

public class LogoutVIEW extends VIEW {

	public void printMenu() {
		System.out.println("1. 로그인");
	}

	// 이메일 형식
	public String inputUid() {
		while (true) {
			System.out.print("ID 입력 >> ");
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
			System.out.print("이름 입력 >> ");
			String name = sc.next();
			boolean isOnlyKr = Pattern.matches("^[ㄱ-ㅎ|가-힣]*$", name);
			if (!isOnlyKr) {
				System.out.println("한글만 입력해 주세요.");
			} else {
				return name;
			}
		}
	}

	public String inputNickName() {
		while (true) {
			System.out.print("닉네임 입력 >> ");
			String nickName = sc.next();
			boolean isOnlyNonSpecialChar = Pattern.matches("^[0-9a-zA-Zㄱ-ㅎ가-힣]*$", nickName);
			if (!isOnlyNonSpecialChar) {
				System.out.println("특수문자가 포함되어 있습니다.");
			} else {
				return nickName;
			}
		}
	}

	//1900~2023년생까지
	public int inputBirhday() {
		while (true) {
			System.out.print("생년월일 입력 >> ");
		
				String birthday = sc.next();
				boolean isBirthday = Pattern.matches("(19|20)([01]\\d|[2][0-3])(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])", birthday);
				if (!isBirthday) {
					System.out.println("옳바른 생년월일이 아닙니다.");
				} else {
					return Integer.parseInt(birthday);
				}
		}
	}

	public int inputPhoneNumber() {
		while (true) {
			System.out.print("전화번호 입력 >> ");

			String phoneNumber = sc.next();
			boolean isPhoneNumber = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", phoneNumber);
			if (!isPhoneNumber) {
				System.out.println("옳바른 전화번호가 아닙니다.");
			} else {
				return Integer.parseInt(phoneNumber);
			}
		}
	}

	public String inputAddress() {
		System.out.print("주소 입력 >> ");
		String address = sc.next();
		return address;
	}

}
