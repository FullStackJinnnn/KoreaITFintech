package model;


//사용자와는 전혀 상호작요을 하지않기 떄문에
// syuo()가 단한개도 없다는 특징이 있다 !!!!!!!! 
// view에서 유저에게 입력받은것을 인자로받아 기능구현!!!


public class CalcModel {

	public int func01(int num1, int num2) {
		return num1 + num2;
	}

	public int func02(int num1, int num2) {
		return num1 - num2;
	}

	public int func03(int num1, int num2) {
		return num1 * num2;
	}
}
