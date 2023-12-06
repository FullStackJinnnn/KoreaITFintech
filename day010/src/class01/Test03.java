package class01;
// 추상클래스 & 인터페이스 !!!!!!!할말 짱많은데 학문적으로 들어가면 끝도없다 !!! 개발할땐 많이안씀 -_- 
// 사이트를 참고할때 학문인지 개발인지 확인하자.....

//추상클래스 어떻게 등장했는가 ?!?!?
//동화재생 ----
//기존에 이미 많은 자식 클래스들이 있었는데,
//이들의 부모 클래스가 없어서 
//[부모 클래스]를 정의하기위해 탄생
//▶ 객체를 정의하는데에는 관심 XXX
// 		객체생성이 불가능 -> 객체생성을 안할 클래스들한테 붙인다.
//		ex) [추상]포켓몬- [추상\전기,물 - 피카츄,꼬부기
		//포켓몬,전기,물 객체는 없다 -_-
//		ex)	[추상]챔피언-티모,아리,아무무 
//		챔피언이라는 객체는 없다 티모만있을뿐...
//		ex) [추상]모양-원,네모,세모,별...
//		ex) [추상]동물-강아지,고양이,사슴,알파카...
//		ex) 사람-학생,직원 -> 사람은 객체가 있다!!!!!!ㅁㅊ 상위중에 추상이 아닐수도 있는것이 존재한다.
//▶ 클래스를 정의하는데에 관심이 있음 !!!!!!!!★★★

//추상클래스를 사용하는 이유
// 1. 객체화를 막기위함
// 2. 추상메서드를 사용하기 위함
//		▶ 메서드 오버라이딩

abstract class Animal {
	String type;
	String name;
	Animal(String type) {
		this(type,"type");
	}
	Animal(String type,String name){
		this.type=type;
		this.name=name;
	}
	abstract void hello();
	// 추상메서드를 가진 클래스는 반드시 추상메서드 !!
	
}
	
class Dog extends Animal {

	Dog() {
		this("강아지");
	}
	Dog(String name) {
		super("강아지",name);
	}
	@Override //왕 메서드 오버라이딩강제화 개발자가 안까먹는다
	void hello() {
		System.out.println("멍멍!");
	}
}

public class Test03 {
	public static void main(String[] args) {
		
	}
}
