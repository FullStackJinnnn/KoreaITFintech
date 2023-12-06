package class02;

import java.util.Scanner;

// Class 선언(정의)하는 방법
class Student{ // "학생"이라는 자료형 정의(선언)완료
	//"학생"이라는 자료형은
	// 이름,나이,점수를 가지고있음
	//class안의 정의된 것들을 맴버변수라고 부른다!!!!!!
	// 다른말로는 ... 필드, 속성. attribute, property !!
	
	//public은 공개범위 -> 나중에설명
	//static == 객체와 무관하게 라는뜻!!!!!!!!!!!!다시외우자
	//		클래스(객체)에 포함되는 함수(메서드)들에게는 static이 붙지않음!
			
	String name;
	int age;
	int score;
	
	void printInfo() {// ->객체와 관련이 있기 떄문에 static이 붙지않는다.
		System.out.println();
		System.out.println("Student클래스 안의 메서드 printInfo()에서 출력함");
		System.out.println(name);
		System.out.println(age);
		System.out.println(score);//scope가 맞아 떨어진다. 사용가능!
		

	}
}



public class Test01 {

	//클래스(Class)란 ? ★★★★★★
//		JAVA의 기본단위
//		자료형의 일종 ex) 이름, 나이, 번호를 가지고있는 학생 클래스!
//		JAVA에서 이미 수많은 클래스들을 미리 만들어놨지만,
//			ex) Random, Scanner, ...
//		개발자(우리)가 새로 정의할수 있음!
//		대문자로 시작하는것이 규칙 -> class 가 제일중요!!
//		따라서 함수(메서드),변수명 드은 대문자 XXX
	
//	원시타입들은 new xxxxx
// 배열, 클래스 객체(우리가 만든 자료형)들은 
//	"개발자 영역(heap 메모리 영역)"을 사용해야하기 때문에 new 사용(O)
	
	
	int a =0;
	
// Q. 학생 1명의 이름,나이,점수 어케저장함 ??
	//-> 배열, 원시타입 사용불가
// A. "학생"이라는 자료형이 필요한 순간!!
	
	public static void main(String[] args) {
		
//	int[] StuDatas = new int[3];
//	String[] proNameDatas=new String[5];
//	double x,y;
//	Student stu; //"학생"이라는 자료형필요함
//	Student[] stuDatas=new Student[3]; //"학생배열"
	// 학생 ===>> "클래스(Class)"라고 부르는 개념
	
	//"학생"이라는 자료형의 변수를 생성해보자!
	Test01 ts = new Test01();
	ts.a = 5;
	System.out.println(ts.a);
	double d=3.14;
	int[] datas=new int[3];
	datas[0]=0;
	Student stu=new Student(); // stu를 바로 객체라고 부른다!!!★★★★★
	//상위코드의 뜻은 개발자가 만든 자료형 Student 클래스 타입의 변수 stu 객체를 
	//new 연산자를 사용해서 heap 메모리 영엯에 생성하겠습니다!!!!!
	

	//Scanner sc = new Scanner(); // sc 는 ! Scanner 클래스 타입의 변수 sc 객체 선언 or 생성
	stu.name = "개구리"; // .(점 연산자) -> 맴버접근연산자 or 맴버변수접근연산자
	stu.age= 20; 
	stu.score=100;
	System.out.println(stu.name);
	System.out.println(stu);//-> 객체를 담고있는 클래스의 주소가나온다!! 배열처럼 heap 메모리 주소 
	//class02.Student@ ~~~~~~ 클래스주소!
	stu.printInfo();
	
	Student teemo=new Student();
	teemo.name="티모";
	teemo.age=16;
	teemo.score=71;
	teemo.printInfo();
	//매우완전중요☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
	//어떻게 둘다 메서드시그니쳐가 같은 printInfo인데 다른 출력을 할까?
	// 객체지향언어를 사용하면
	// "누가 함수(메서드)를 호출했느냐"에 따라 결과가 달라집니다!!!!!
	//-->함수(메서드)에게 주어(주체)가 생기는 언어
	//멤버함수 -> 메서드라고부른다!! 아무도 멤버함수라고 부르지않음
	
	//일반적인 함수는 주어(주체)가 없고
	//메서드(멤버함수)는 주어(주체)가 있다.
	//★ 함수!= 메서드 ★
	
	//	같은 메서드인데 다른 결과가 나오는 현상
	//	 == 다형성
	//	 == 다형성이 실현(구현)되었다.

	

	
	
	
	
	
	}
}
