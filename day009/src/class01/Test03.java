package class01;

class Point {
	int x;
	int y;
	Point(){
		this(0,0);
		System.out.println("로그1");
	}
	Point(int x,int y) {
		this.x=x;
		this.y=y;
		System.out.println("로그2");
	
	}
	void move(int x) {
		this.x+=x;
		this.y+=x;

	}
	void printInfo() {
		System.out.println("점 ("+this.x+","+this.y+")입니다.");
	}
}

//보통 자식클래스를 아래에 작성
//색갈 점은 점의 한 종류다~_~ 점에서 가져오자
class ColorPoint extends Point {
	//점이 갖고있지 않았던거만 구현하자 !!!!
	String color;
	ColorPoint(String color) {
		this(color,0,0);
		System.out.println("로그3");
	}
	
	ColorPoint(int x, int y) {
		this("검정",x,y);
		System.out.println("로그4");
	}
	
	ColorPoint(String color, int x, int y) {
		
		//댕헷갈림!!!!!!!!
		//모든 자식 클래스의 생성자 가장 첫줄에는 부모클래스의 기본생성자가 자동호출된다!!!!!
		//--> 부모의 기본생성자 호출 떄문에 로그 215 찍힌다!!!
		
		super(); //-> 부모()라는 뜻이며 부모 == 부모 생성자 함수
		this.color=color;
		this.x=x;
		this.y=y;
		System.out.println("로그5");
		
	}
	
}
// 심화필기~ why ?
//붕어빵틀 붕어빵
//클래스로 객체 생성
//부모클래스의기본생성자 자동호출 이유 ?
//자식클래스에는 부모클래스가 가지고있는 멤버변수를 초기화할수있는능력이 없어서 ㅠㅠ
//부모클래스의 기본생성자를 호출해야만 자식클래스가 부모클래스의 멤버변수를 초기화할수있다.

//생성자의 역할이 멤버변수 초기화인데,
// 부모클래스가 갖고있었던 멤버변수를 초기화하는 역할을 부모 클래스의 생성자로 갖고있으니...
//호출할 수 밖에 없다. 메모리 원리 때문에 모든언어 다 적용된다. 



public class Test03 {
	public static void main(String[] args) {
		ColorPoint cp= new ColorPoint("분홍",1,2);
		cp.printInfo();
		cp.move(10);
		cp.printInfo();
	}
}
