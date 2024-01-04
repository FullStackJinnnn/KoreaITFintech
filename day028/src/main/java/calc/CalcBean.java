package calc; //이거패키지 꼭 마들어야지 웹에서 부를 수 있다.

// 안만들면 웹에서 절때 안불러짐!!!!!!!!

// Bean 이란?
// 웹에서 한가지 기능을 담당하는 클래스
// 그 클래스의 객체를 의미함
// 일종의 기능 단위
public class CalcBean {
	// 멤버변수는 웹에서의 네임과 이름을 맞춰주는게 좋다
	private int num1;
	private int num2;
	private String op;
	private int result;

	public void calc() {
		if (op == null) {
			return;
		}
		if (op.equals("+")) {
			result = num1 + num2;
		} else {
			result = num1 - num2;
		}
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
