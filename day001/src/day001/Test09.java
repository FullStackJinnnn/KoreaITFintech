package day001;

public class Test09 {
	public static void main(String[] args) {
		
	
		int num = 10;
		
		// num가 양수면 양수입니다.
		// 음수면 음수입니다.
		
		// 코드의 흐름을 제어할수있는 문법 == 제어문
		// 제어문의 한종류 if문(조건문) : 선택의 순간에 활용 
		if(num>0) {
			System.out.println(num+ " 은 양수입니다.");	
		}
		else if(num<0) { // 연산자가 하나줄어듦 == 속도 향상
			System.out.println(num + "은 음수입니다.");
		}
		else {
			System.out.println("0 입니다.");
		}
	
		String answer = num>0 ? num + " 은 양수입니다.": num + " 은 음수입니다";
		System.out.println(answer);
		
	}
	
}
