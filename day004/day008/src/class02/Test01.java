package class02;

class Point {
	int x;
	int y;

	Point() {
		//System.out.println(" 로그"); --> 멤버변수 초기화가 안되었는데 뭔가 하면 안된다.
		// 초기화하는코드가 제일 먼저다!!!!
		this(0,0);
		System.out.println(" 로그1");
	}

	Point(int x) {
		this(x,x); // this()는 생성자를 의미한다. 2개의 메게변수를 가진 생성자 호출!!!!
		System.out.println(" 로그2");
	}

	Point(int x, int y) { //인자 가장많은 생성자부터 생성
		this.x =x; // 멤버변수 x = 매게변수 x
		this.y =y; // -> 파이선 self와 비슷하다 this.x 는 멤버변수의 x를 뜻함
		// 모든 멤버변수앞에는 반드시 this를 붙일것 !
		// this를 안붙여도 되는것은 전체 스코프를 참조해서 자바가 알아서 확인한다 -->>> 느림
		// 항상붙여라 ㅡㅡ!!! 메게변수랑 멤버변수명이 달라도 붙이세용
		//생성자 많이만들면 힘드네 ..? 
		//재사용가능????
		System.out.println(" 로그3");
	}
	void printInfo() {
		System.out.println("점 ("+this.x+","+this.y+")입니다.");
	}
	
	void move(int x) {
		this.x+=x;
		this.y+=x;
	}
}

public class Test01 {

	public static void main(String[] args) {

		Point point01 = new Point(); // (0,0)
		System.out.println(" 로그4");
		Point point02 = new Point(10); // (10,10)
		System.out.println(" 로그5");
		Point point03 = new Point(1, 2); // (1,2)
		System.out.println(" 로그6");
		
		point03.move(10);
		
		
		
		
		
		
		point01.printInfo();
		point02.printInfo();
		point03.printInfo();
	}

}
