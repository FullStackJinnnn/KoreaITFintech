package class02;

class Point {
	int x;
	int y;
	Point(){
		this(0,0);
	}
	
	Point(int x) {
		this(x,x);
	}
	
	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	void move(int x) {
		this.x+=x;
		this.y+=x;
	
	}
	
	void printInfo() {
		System.out.println("점이 ("+this.x+","+this.y+")");
	}
}

class ColorPoint extends Point {
	String color;
	
	
	
	
	ColorPoint() {
		this(0,0);
		//생성자에서 부모메서드 호출 하지말자.. 가능은함
		// 생성자는 멤버변수 초기화가 목적.
	}
	ColorPoint(String color) {
		this(color,0,0);
	}
	ColorPoint(int x,int y) {
		this("검정",x,y);
	}
	//가장 이상적 활용
	ColorPoint(String color,int x,int y) {
		super(x,y); //부모생성자를 이용한 xy값 초기화 그이후 이 생성자를 이용한 메게변수가 작은 생성자 초기화
		this.color=color;
	}
	void printInfo() {
		System.out.println(this.color+"점이 ("+this.x+","+this.y+")");
	} // 기존에 부모가 사용하던 메서드는 더이상 사용 X 재정의를 했다.
	
	// 정리!
	// 오버로딩은 함수명이동일하고 메서드 시그니쳐가 다른것 > 상속관계 X 상속에서 안배움
	// 함수명 중복정의 허용
	// 함수가 N개
	
	//vs 오버라이딩
	// 함수명이동일
	//메서드 시그니쳐가 같음
	//상속 관계 O
	//메서드 재정의
	// 메서드가 1개 ---> 팀편성 시험에 나온다.
		
	
}



public class Test01 {
	
	public static void main(String[] args) {
	//자식클래스 입장에서 
	//부모클래스가 가진 printInfo()라는 기능을 사용하고는 싶은데... 뭔가 동작방법이...내마음에 안드네 ..?
	

	// => 메서드 재정의 : 기존에 부모가 사용하던 메서드는 더이상 사용 X
		ColorPoint cp1 = new ColorPoint();
		ColorPoint cp2 = new ColorPoint("분홍");
		ColorPoint cp3 = new ColorPoint("노랑",1,1); 
		
		Point p1 = new Point();
		p1.printInfo();
		cp1.printInfo();
		cp2.printInfo();
		
		cp2.move(1);
		cp2.printInfo();
		cp3.printInfo();
		
		
		
	}
}
