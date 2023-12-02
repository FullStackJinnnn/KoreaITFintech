
public class Test01 {
	
	// input O output X
	// int타입의 인자가 1개있는 함수다~~
	// JAVA의 모든 타입이 전부 인자로 사용가능함
	// 인자 개수도 여러개 가능함
	public static void plus(int num) {
		//인자로 호출했을때에 사용한 "값"을 받음
		// main()ㅎ마수에서 있던 num의 값이다 라는 사실을 모름!!
		// main()함수에게서 100이라는 "값"을 받았다. -> main에서 선언된 num의 메모리공간 자체를 받지 않는다.
		// 값에 의한 호출(call by value)

		num+=10;
		System.out.println("최종 num= "+num);
	}
	
	
	public static void funA(int a, int b) {
		int temp=10;
		temp=a;
		a=b;
		b=temp;
		System.out.println("funcA()");
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("temp="+temp);
	}
	
	public static void main(String[] args) {
		
		plus(2);
		plus(-5);
		plus(0);
		
		//개발도구(이클립스)를 활용해서 서로 다른 변수임ㅇ르 확인
		// 이름이 우연히 같을뿐, 서로 다르ㅡㄴ 변수!
		// {} 블록 영역(scope)이 서로다름!!!!!
		int num=100;
		plus(num);
		System.out.println("메인함수의 num= " + num);
		
		System.out.println("===================");
		
		int a=1,b=2,temp=3;
		funA(a,b);
		System.out.println("main()");
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("temp="+temp);
	
		//선언(정의) != 호출(사용)
		//인자값 전달시 call by value
		//실행순서는 ↓

	}
}
