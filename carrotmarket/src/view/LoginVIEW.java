package view;

//import model.UserDTO;

public class LoginVIEW extends VIEW {

	public void printMenu() {
		System.out.println("========메인 메뉴 출력========");
		System.out.println("1. 유저 정보 조회");
	}

	public void printUserInfo() {
		System.out.println("========유저 정보 조회========");
		System.out.println("1. 프로필 사진");
		System.out.println("2. 사용자 닉네임");
		System.out.println("3. 사용자 닉네임 변경");
		System.out.println("4. 사용자 아이디");
		System.out.println("5. 사용자 비번 변경");
		System.out.println("6. 사용자 주소");
		System.out.println("7. 사용자 주소 변경");
		System.out.println("8. 사용자 전화번호");
		System.out.println("9. 사용자 전화번호 변경");
		System.out.println("10. 자신이 작성한 글");
		System.out.println("11. 자신이 작성한 댓글");
		System.out.println("12. 회원 탈퇴");
		System.out.println("13. 자신이 좋아요 누른 글 보기");
		System.out.println("===========================");
	}

	public void printBoardUpdate() {
		System.out.println("1. 수정");
		System.out.println("2. 삭제");
	}

//	public void hello(UserDTO data) {
//		System.out.println(data.getName()+"님, 안녕하세요! :D");
//	}
}
