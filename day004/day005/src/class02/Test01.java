package class02;

import java.util.Scanner;

//함수 : output 함수명(input)
//3요소
//input,매개변수,args,인자,인수,파라미터,입력값
//output,return,반환값,결과값,출력값
//기낭 -> 해당 함수의 기능을 유추할수있는 이름으로 함수명을 작성!
public class Test01 {
	
	//함수 4유형
	// input X output X
	// 1유형의 함수가 선언(정의)된 상태
	// 함수를 사용하려면 호출해야만함
	public static void hello() {
		System.out.println("안녕하세요!!!");
	}
	
	// input O output X
	// input X output O
	// input O output O
	
	public static void todaydate() {
		System.out.print("2023년 11월 27일");
	}
	public static void writename() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요!!!!!!!!!!!!!");
		String a = sc.next();
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		
		// 수많은 JAVA 기본 함수들이 "호출"하지않았기에 "사용"되고있지않음
		// 수많은 JAVA 기본 함수들은 선언(정의) 만 되어있음
		
		hello(); //선언(정의)된 함수를 호출하는 코드
		//코드를 재사용
		//가독성 좋아짐
		//개발시간 단축 !
		//개발비용 절감 !
		//오류의 파급효과 줄어듦
		//성능향상에 유리
		// -> 반복문, 함수를 잘 사용하고 이해하는 인재 
		System.out.print("오늘의 날짜는~~~ ");
		todaydate();
		System.out.println(" 입니다~~");
		writename();
		
		
	}
}
