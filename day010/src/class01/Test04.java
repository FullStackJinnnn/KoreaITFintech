package class01;

abstract class Pokemon {
	int lv;
	String name;
    // 부모가 가진 멤버변수를 모두 초기화 하고 시작하는 것이 좋다. 내려가면서 자식이 super를 사용해 초기화.
	// 코드가 짧아지고 가독성이 좋아짐 ? 
	// 즉 모든 부모 멤버변수를 메게변수로 가진 생성자를 만들어주자!!!!! ~_~
	Pokemon(int lv) {
		this.lv = lv;
	}

	abstract void attack();

	abstract void hello();

	void printInfo() { //세상모든포켓몬은 같은출력을한다 오버라이딩 X
		System.out.println(this.name + " Lv" + this.lv);
	}
}

class Elec extends Pokemon {
	Elec(int lv) {
		super(lv);
	}

	@Override
	void attack() {
		System.out.println("백만볼트!!!");
	}

	@Override
	void hello() {
	}

}
// name을 생성자를 만들때마다 초기화해줘야하는 불편함 발생.
// 따라서 name도 부모클래스에서 받아와 
class Pica extends Elec {
	Pica() {
		this(5);
	}

	Pica(int lv) {
		super(lv); 
		this.name = "피카츄";
	}

	@Override
	void hello() {
		System.out.println("피카피카");
	}

}

class Ry extends Elec {
	Ry() {
		this(5);
	}

	Ry(int lv) {
		super(lv);
		this.name = "라이츄";
	}

	@Override
	void hello() {
		System.out.println("라이라이");
	}

}

public class Test04 {
	public static void main(String[] args) {

		Pica p1 = new Pica();
		Pica p2 = new Pica(11);
		Ry r1 = new Ry();
		p1.printInfo();
		r1.printInfo();
		p2.printInfo();
		p1.attack();
		r1.attack();
		p1.hello();
		r1.hello();


	}
}
