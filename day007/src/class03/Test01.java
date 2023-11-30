package class03;


// "책"이라는 자료형이 필요해
// == "책" 클래스 정의;

class Book{
	String title;
	String writer;
	int price;
	void printInfo() {
		System.out.println("제목: "+title);
		System.out.println("작가: "+writer);
		System.out.println("가격: "+price);
	}
}



public class Test01 {

	public static void main(String[] args) {
		Book book1=new Book();
		Book book2=new Book();
		book2.title="어린왕자";
		book2.writer="생택쥐페리";
		book2.price=10000;
		
		book1.printInfo();
		book2.printInfo();
		
		// heap 메모리 영역의 특징
		// -> 0, null 로 자동초기화 해준다. 개발자가 귀찮아할거라고 생각함
		String[] datas=new String[3];
		int[] datas2=new int[3];
		System.out.println(datas[0]);
		System.out.println(datas2[0]);
		 //->null이 들어가있다
	   //->0이 들어가있다
		
		//개발자 메모리 영역(heap 메모리 영역)에 변수를 생성하면 자동 초기화 해준다!!!
		
		
		// 원시타입인 변수들은 초기화하지않으면 값이 아무것도없다 Null X 0 X 둘다아님 진짜 빈공간 그잡채
        // ->에러발생 아무것도 실행못함.
//		int nun1;
//		int num2=10;
//		
//		String str1;
//		String str2="hello";
//		
//		System.out.println(num1); --> 에러
//		System.out.println(num2);
//		System.out.println(str1);
//		System.out.println(str2);
		
		//아 ....멤버변수 초기화를 강제해줬으면 좋겠다..."
//		★ 강제
//		~~~ 기능 덕분에 ~~를 "강제" 할수있다.
//		좋은거다 많이쓰는것이다
//		자유도가 높으면 사람이 많아질수록 결과물이 제각각이다.
//		프로그래밍 언어에는 하먄안되거나 반드시해야하는 것들은 "강제"하는 기능이 많이 있다.
//		
	}
}
