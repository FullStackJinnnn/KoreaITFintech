package controller;

import model.CalcModel;
import view.CalcView;

// Ctrl는 절대로 자신스스로 뭘하지않고 다빌려다쓴ㄷ가

public class CalcCtrl {
	
	private CalcModel model; // 객체 멤버변수
	private CalcView view; // 객체 멤버변수
	
	public CalcCtrl() {
		model=new CalcModel(); //객체 멤버변수 초기화
		view=new CalcView(); //객체 멤버변수 초기화
	}
	
	public void startApp() {
		view.printInputInteger(1);
		int num1=view.inputInteger();
		
		view.printInputOp();
		String op=view.inputStringOp();
		
		view.printInputInteger(2);
		int num2=view.inputInteger();
		
		
		int result;
		if(op.equals("+")) {
			result=model.func01(num1, num2);
		}
		else if(op.equals("-")) {
			result=model.func02(num1, num2);
		}
		else {
			result=model.func03(num1, num2);
		}
		
		view.printResult(num1, op, num2, result);
		
		
		
	}
}
