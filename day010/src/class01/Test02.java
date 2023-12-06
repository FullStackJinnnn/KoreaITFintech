package class01;

abstract class Shape { // [추상]
	String name;
	double area;

	Shape(String name) { // name 속성 강제
		this.name = name;
		this.area = 0.0; // 가독성을 위한 대입
	}
	
	abstract void printInfo(); // 추상메서드
	// ▶ 얘 좀 오버라이딩 해줄래?
	// ▶ 오버라이딩 "강제"
	// ▶ 호출될일이 없으므로 {}에 메서드바디가 없음
	
	//메서드는 호출을당하려면 주어가필요하다. 객체화가되어야함 하지만 추상이라서 불가능 -_- 호출절떄 불가능
	//shape 타입의 객체가 .printInfo(); 해야하는데,
	//shape 타입의 객체를 객체화 할 수 없기 때문 !!
	//오로지 overriding을 위한 메서드.
//	void printInfo() {
//		System.out.println(this.name + "은(는) 넓이가" + this.area + "입니다.");
	}

class Circle extends Shape {
	int radius;
	final static double PI = 3.14; // static을 안붙이면 객체마다 독특한 값을 갖는다는 의미
	// final 은 상수~~~

	Circle() {
		this("원");
	}

	Circle(String name) {
		this(name, 1);
	}

	Circle(String name, int radius) {
		super(name);
		this.radius = 1;
		this.area = this.radius * this.radius * Circle.PI;
	}

	@Override
	void printInfo() {
		System.out.println("반지름" + this.radius);
	}
	
	
}

class Rect extends Shape {
	int x;
	int y;
	Rect() {
		this("사각형"); //this() 는 생성자다 ...
	}

	Rect(String name) {
		this(name, 1, 1);
	}

	Rect(String name, int x, int y) {
		super(name);
		this.x = x;
		this.y = y;
		this.area = this.x * this.y;
	}

	@Override
	void printInfo() {
		System.out.println(this.name+"가로"+this.x+" 세로"+this.y);
	}
	
	
}

public class Test02 {
	public static void main(String[] args) {
		
//		Shape s = new Shape();
//		추상클래스로는 객체화 불가능 !!!!!!!!!
//		모든부모클래스가 반드시 추상이어야 한다는 법칙은 없다.
		Shape[] datas=new Shape[3];
		datas[0]=new Circle();
		datas[1]=new Rect();
		
		Circle c=new Circle("도넛");
		datas[2]=c;
		
		for (Shape data:datas) {
			System.out.println(data); //-> 객체의 주소값출력
			data.printInfo();
		}
		 
		// 동적바인딩
		// : 가장 마지막에 재정의한 메서드가 자동으로 호출되는 현상
		// 다형성 실현
		// 메모리에 적재되는것 (컴파일) 과 실행순서는 다르다 
		// 컴파일은 위에서부터 훑어내리고 실행은 호출순서
		// 실행할때는 이미 메모리에 적재되어있기 때문에 메게변수가 가장 많은 생성자가 아래있어도 상관없다.
		
		
		
		
	}
}
