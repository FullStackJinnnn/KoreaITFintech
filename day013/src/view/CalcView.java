package view;

import java.util.ArrayList;
import java.util.Scanner;

public class CalcView {

	private Scanner sc; // -> view 밖에서 사용할일이없어서 getter setter static 안쓴다.
	private ArrayList<String> datas;
	public CalcView() {
		this.sc = new Scanner(System.in);
		datas=new ArrayList<String>();
		datas.add("+");
		datas.add("-");
		datas.add("*");
		datas.add("x");
		datas.add("X");
	}

	// 사용자와의 input,output만을 고려하는 파트

	// 사용자가 제공받아야 하는 문구를 제작
	public void printInputInteger(int num) {
		System.out.println("정수 " + num + " 입력 >>");
	}

	public void printInputOp() {
		System.out.println("연산자 입력>> ");
	}

	public void printResult(int num1, String op, int num2, int result) {
		System.out.println("결과는 " + num1 + " " + op + " " + num2 + " = " + result + " 입니다.");
	}

	// 사용자의 입력을 받아야 하는 부분을 제작
	public int inputInteger() {
		int num;
		while (true) {
			try {
				num = sc.nextInt();

				break;
			} catch (Exception e) {
				sc.nextLine(); // => 잘못 입력했어? 버퍼 비워줘\
				System.out.println("[로그] 정수만 입력 가능합니다.");
			}

		}
		return num;
	}

	public String inputStringOp() {
		
		String op;
		while (true) {
			op = sc.next();
			if(datas.contains(op)) {
				break;
			}
			System.out.println("[로그] 없는 연산자이거나 아직 개발되지않은 연산자입니다.");
		}
		return op;

	}

}
