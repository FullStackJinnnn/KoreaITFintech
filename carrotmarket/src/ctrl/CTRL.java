package ctrl;

import java.util.ArrayList;

import model.BoardDAO;
import model.MemberDAO;
import view.CommonVIEW;
import view.LoginVIEW;
import view.LogoutVIEW;
import view.VIEW;


public class CTRL {

	private CommonVIEW commonVIEW;
	private LoginVIEW loginVIEW;
	private LogoutVIEW logoutVIEW;
	
	public CTRL() {
	
		commonVIEW=new CommonVIEW();
		loginVIEW=new LoginVIEW();
		logoutVIEW=new LogoutVIEW();
	
	}

	
	public void start() {
		while(true) {
//			logoutVIEW.printMenu();
//			commonVIEW.printMenu();
			
			loginVIEW.printMenu();
			commonVIEW.printMenu();
			
//			
//			loginVIEW.printUserInfo();
//			int action = commonVIEW.inputNum("번호를 입력해주세요", 1, 13);
//			if (action == 10) {
//				loginVIEW.printBoardUpdate();
//				commonVIEW.inputNum("번호를 입력해주세요", 1, 2);
//			} else if (action == 11) {
//				loginVIEW.printBoardUpdate();
//				commonVIEW.inputNum("번호를 입력해주세요", 1, 2);
//			}
//			logoutVIEW.printMenu();
//			logoutVIEW.inputUid();
//			logoutVIEW.inputName();
//			logoutVIEW.inputNickName();
//			logoutVIEW.inputPhoneNumber();
//			logoutVIEW.inputBirhday();
//			logoutVIEW.inputAddress();
			break;
		}
	}
}
