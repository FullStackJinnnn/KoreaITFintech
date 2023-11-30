
class Circle {
	double area;
	// 각각의 객체마다 다른값인가? -> 멤버변수(속성)  각각의 객체마다 다 같은값 -> static 클래스 소속 
	// 어떠한 클래스의 모든 객체가 다 동일한 멤버변수값을 가질때에 우리는 그 멤버변수를 공유자원이라고 하며 객체와 무관하므로 static을 붙임
	// static이 붙은건 더이상 멤버변수가 아니다...
	// 그러므로 멤버변수를 초기화하는 생성자에서 초기화 X
	// 클래스에서 초기화
	// 멤버변수가 아니게 됨으로 PI 에 this는 안붙인다.
	static final double PI= 3.14; // 불변하는 변수는 전부 대문자로 바꾸기... -> 상수
	// 멤버변수는 객체 (Instacne) 소속 
	// 모든 원이라면 전부다 3.14
	// 이러한 멤버변수를 공유자원 이라고 한다.
	// 객체와 무관하게 
	//int radius; ? 필요한가용 도 멤버변수로 받자!!!!!
	int radius;
	String name;
	
	Circle () {
		
	}
	Circle (String name) {
		this(name,1);
			
		}
	
	Circle(int radius) {
	this("원", radius);
	}
	
	Circle(String name, int radius) {
	this.name = name;
	this.area = radius * radius * Circle.PI; //-> this.radius 로 바꾸고 PI는 클래스 소속이기 때문에 CirCle.PI
		
	}
	//메서드는 보통 생성자 다음에 선언
	void printInfo() {
		//항상 thio 붙이기.
		System.out.println(this.name+"는(은) 넓이가 "+area+"입니다.");
	}
	
	
	void changeRadius(int radius) {
		this.radius =radius;
		this.area=this.radius*this.radius*Circle.PI;
	}
}

class ColorPoint {
	int x;
	int y;
	String color;
	
	ColorPoint() {
		this(0,0); // 인자가 없을때 인자 2개만 입력해도 44번 라인으로 넘어가서 defualt값을 줄 수 있다.
		//하드코딩 최소화!!!
		}
	
	ColorPoint(String color) {
		this(color,0,0);
	}
	ColorPoint(int x, int y) {
		this("검정",x,y);
	}
	
	ColorPoint(String color,int  x,int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	void printInfo() {
		System.out.println(this.color+"색 점은 ("+this.x+","+this.y+")에 있습니다.");
	}
	
	void changeColor(String color) {
		this.color = color;
	}
	
	void move(int x,int y){
		this.x+=x;
		this.y+=y;
	}
}


public class Test03 {
	public static void main(String[] args) {
		ColorPoint cp1 = new ColorPoint();
		ColorPoint cp2 = new ColorPoint(1,2);
		ColorPoint cp3 = new ColorPoint("분홍");
		ColorPoint cp4 = new ColorPoint("빨강",3,5) ;
	
		cp1.move(10, 5);
		cp1.changeColor("빨강");
		
		
		cp1.printInfo();
		cp2.printInfo();
		cp3.printInfo();
		cp4.printInfo();
		
		
		System.out.println();
		System.out.println();
		
		Circle c1 = new Circle(10);
		Circle c2 = new Circle("도넛");
		Circle c3 = new Circle("피자",12);
		Circle c4 = new Circle();
		
		c1.changeRadius(33);
		
		c1.printInfo();
		c2.printInfo();
		c3.printInfo();
		c4.printInfo();
		c4.printInfo();
		c4.printInfo();
		c4.printInfo();
		c4.printInfo();
		c4.printInfo();
		c4.printInfo();
		
		System.out.println();
		System.out.println();
		
		ColorPoint[] cpArr = new ColorPoint[5];
		
		for (int i=0; i<cpArr.length; i++) {
			cpArr[i] = new ColorPoint(i,(i+3));
		}
		
		for (ColorPoint datas : cpArr) {
			datas.printInfo();
		}
		
		
		
		
	}
}
