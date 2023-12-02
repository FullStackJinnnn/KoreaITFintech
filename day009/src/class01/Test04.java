package class01;

class Pokemon{
	String type;
	Pokemon(String type) {
		this.type=type;
	}
	void printInfo() {
		System.out.println(this.type);
	}
}

class Pikachu extends Pokemon{
	String name;
	Pikachu() {
		this("피카츄");
	}
	Pikachu(String name) {
		//super(); -> 부모의 기본생성자가 없어서 자동으로 호출못한다ㅠ 
		//해결방안
		//1.부모 클래스에게 기본생성자를 만들어주는줌 --> 이거 사용하면안된다!!!!
		// 자식을 만들때에러가나서 부모를 건들이는것은, 설계를 안했거나 못했거나 하는것이다.
		// 개발을하다가 이전내용을 변경해야하는 일이생기면 아~내가 설계 부족하구나 !!!
		// 코드작성을 멈추고 설계를 다시 점검
		
		//2. 부모에게 존재하는 다른 생성자를 호출해서  부모클래스에 선언된 멤버변수를 초기화한다!!!!!!
		//기본생성자말고 있는생성자 사용하자. 멤버변수만 초기화하면 된다.
		//모든 멤버변수를 초기화 할수있다면. 에러가 안난다!!!!!!!!!!!
		super("전기");
		this.name =name;
	}
}


public class Test04 {
	public static void main(String[] args) {
	
	}
}
