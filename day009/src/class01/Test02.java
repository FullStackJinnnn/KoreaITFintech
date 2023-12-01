package class01;
import java.util.Arrays;

class A {
	   // 상속 !!!!
    int data01=55;
    int data02;
    int data03;
    void funA() {
    	System.out.println("메서드01");
    }
    void funB() {
  
    	System.out.println(this.data01 + "메서드02");
    }
}
//이런식으로 생성하면 개념적으로 포함관계 형성
//a객체와 b객체 사이에 형성됨
//모든 b객체들은 클래스A의 특징을 갖게됨.
//클래스 A 개념이 보다더 넓은 개념
//프로그램에는 이런 개념이 굉장히많다.

//모양: 원,네모,세모....
//사람: 학생,사원...
//카드: 신용카드..체크카드,교통카드...
//동물: 강아지,고양이
//포켓몬: 전기, 물, 불....꼬부기,고라파덕,잉어킹

//클래스A
//		상위 클래스
//		부모 클래스
//클래스B
//		하위 클래스
//		자식 클래스
		//--> 자바
	//파이썬은 -> 파생클래스 라고 호칭


//A의 데이터를 B에서도 접근 가능하게 하고싶다.
class B extends A{
	// 데이터 01~05 총 5개의 속성
	// 메서드 01~03 총 3개의 기능
	int data01 = 20;
	void funcB() {
		System.out.println(this.data01+"메서드03");
	}
	
}




//상속관계 extends 키워드
//일단 코딩해보고 부족하거나 틀린부분있으면 그때 고치자!!XXXXXXXXX절 떄 금 지 
//정확하고 올바른 설계가 완성된 후에 코딩을하자.....안그럼망해용
public class Test02 {
    public static void main(String[] args) {
    
    	A aaa=new A();
    	B bbb=new B();
    	
    	aaa.funB();
    	bbb.funB();
    	
    	
    	
   
    }
}