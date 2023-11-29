package class04;

class Student {
	String name;
	int score;
	// 엥? 생성자 어디감???? 
	Student() { //메모리를 반환 -> 아웃풋을 작성을 안하는게 규칙.->기본으로 제공 숨어져있음
		//클래스에서 객체를 생성하는데,
		//아 ..멤머변수 초기화를 강제하고싶다..
		//멤버변수 초기화하는 역할 == 생성자
		//생성자란?
	
		name="이름없음";
		score=0;
		System.out.println("Student 클래스의 기본 생성자");
	}
	
	Student(String n) {
		name=n;
		score=0;
		System.out.println("하나 더 만든 생성자");
	}
    Student(String n, int s) {
		name=n;
		score=s;
		System.out.println("생성자로 멤머변수 초기화 강제");
	}
	
	//생성자를 1개이상 정의하면 기본생성자를 안준다!!!!!!!!! ㅡㅡ 
	
	void printInfo() {
		System.out.println(name+"학생은 "+score+"점입니다.");
	}
}

public class Test01 {
	public static void main(String[] args) {
	
		Student stu1=new Student("티모",13);
//개발자자료형 클래스 / 클래스에서나오는 변수 객체 / new 연산자 / 함수 메서드 X
//Student() 함수에 대하여...
//클래스와 이름이 똑같은 함수가 있다 new 연산자 뒤에서 호출됨.
//멤머변수 초기화하는 역할
//"생성자" 라고 부른다!!!!!! ㅇ아ㅏ아ㅏㅁ맞아 main에서 기본생성자를 만들어준다 !! 숨어있음
// 함수를 호출해서 사용하려면 선언해야함!
// 생성자 없이는 객체를 생성할 수 없다 JAVA는  인자가없는 생성자를 기본으로 제공
// 기본생성자(디폴트 생성자)"
		Student stu2=new Student("가렌");
		Student stu3=new Student();
		stu1.printInfo();
		stu2.printInfo();
		stu3.printInfo();
		// 현재는 멤버변수 초기화를 강제하지않음
		// Student() 인자가 없는 생성자 기본 생성자
	}
}
