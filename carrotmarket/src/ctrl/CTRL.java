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
			logoutVIEW.printMenu();
			logoutVIEW.inputUid();
			logoutVIEW.inputName();
			logoutVIEW.inputNickName();
			logoutVIEW.inputPhoneNumber();
			logoutVIEW.inputBirhday();
			logoutVIEW.inputAddress();
		}
	}
}
