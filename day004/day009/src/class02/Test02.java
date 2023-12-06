package class02;


class Pokemon {
	String type;
	int lv;
	int exp;
	String name;
	Pokemon(String type) { //이놈으로 객체를 만들 마음은 없고 type 멤버변수 값을 강제하기 위함
		this.type=type;
		this.lv=5;
		this.exp=0;
		this.name="포케몬";
	}
	
	void attack() {
		System.out.println(" [ 로 그 ] ");
		System.out.println("포켓몬 클래스의 attack()");
		System.out.println("아직 구현 X");
	}
	
	void hello() {
		System.out.println(" [ 로 그 ] ");
		System.out.println("포켓몬 클래스의 hello()");
		System.out.println("아직 구현 X");
	
	}
}

class Elec extends Pokemon {

	Elec() {
		super("전기");
		
	}

	@Override // @ annotation(어노테이션) : 코드 가독성 향상, 메모리 성능 향상, 주로 설정 사항에 대해서 추가
	//컴터가 얘를 제일먼저 확인, 바로 재정의된걸 알수있음
	void attack() {
		System.out.println("백만만볼트 !!!~~~~~");
	}
	
}

class Picachu extends Elec {
	Picachu() {
		this("피카츄");
	}
	Picachu(String name) {
		this.name = name;
	}
	@Override
	void hello() {
		System.out.println("피카피카 -_-!!");
	}
	
}

class Water extends Pokemon {
	Water() {
		super("물타입");
	}

	@Override
	void attack() {
		// TODO Auto-generated method stub
		System.out.println("물대포!!!!~~");
	}
}
class Squirtle extends Water {
	Squirtle() {
		this("꼬부기");
	}
	Squirtle(String name){
		this.name=name;
	}
	@Override
	void hello() {
		// TODO Auto-generated method stub
		System.out.println("꼬북꼬북!!!!!");
	}
	
}
	
	






//public class Test02 {
//
//		public static void main(String[] args) {
//			
//			Picachu pika= new Picachu();
//			Squirtle sq = new Squirtle();
//			pika.attack();
//			pika.hello();
//			sq.attack();
//			sq.hello();
			// 가장 최근에 정의된(오버라이딩된) 메서드가 자동호출됨
			// == 다형성이 실현되었다. 여러개의 상태 ....
			
			// 클래스는 자료형이다!
			// 몬스터볼 6개 포켓몬 6개 
//			picachu[] datas = new picachu[6] --> 피카츄만 데려다님
//			pokemon[] datas2=new pokemon[6] 이라 해야  다양한 포켓몬 데리ㅏ고다님
//			datas[0] = new picachu();
//			
//			ex)
//			dobule[] datas=new double[6];
//			datas[0] =10; -> 더큰 개념안에 작은개념이 들어갈수있다
//		}
//	}
