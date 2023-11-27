package class07;

public class Test01 {

	// 1번 함수
	// 정수 3개를 인자로 받아와서,
	// 3개를 각각 +1씩 하고
	// 3개의 정수의 총합을 Console에 출력하는 함수

	// 2번 함수
	// 정수배열 1개를 인자로 받아와서.
	// 배열의 모든 요소를 각각 +1씩 하고
	// 배열의 모든 요소의 총합을 Console에 출력하는 함수

	public static void printTotal(int a, int b, int c) {
		a++;
		b += 1;
		c = c + 1;
		int total = a + b + c;
		System.out.println("funcA() 총합= " + total);
	}
	// 2번 함수
	// 정수배열 1개를 인자로 받아와서, -> input
	// 배열의 모든 요소를 각각 +1씩 하고
	// 배열의 모든 요소의 총합을 Console에 출력하는 함수 -> output

	public static void printTotal(int[] datas) {
		for (int i = 0; i < datas.length; i++) {
			datas[i]++;
		}
		int total = 0;
		for (int data : datas) {
			total += data;
		}
		System.out.println("funcB() 총합=" + total);

	}

	public static void main(String[] args) {

		int a = 10, b = 20, c = 30;
		printTotal(a, b, c); // 값에 의한 호출
		// 변수 a,b,c에 대한 정보가 전달 XXX
		System.out.println("main()의 현재 a,b,c값을 출력");
		System.out.println("a= " + a);
		System.out.println("b= " + b);
		System.out.println("c= " + c);

		int arr[] = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10;
		}
		// [ 10 10 10 10 10 ]
		printTotal(arr); // 참조에 의한 호출(call by reference)
		// heap(힙) 메모리 영역의 주소값이 전달 O
		// 실제 메모리에 접근가능함!!!!!
		System.out.println("main()의 현재 numArr 상태를 출력");
		for (int num : arr) {
			System.out.print(num + " ");
		}

		// 결론★ 함수 호출 방식에는 크게 2가지가 있는데,
		// 1)값에 의한 호출(call by value)
//			원시 타입 데이터가 인자일때
//			int,double,String,boolean..a.
//		2) 참조에 의한 호출(call by reference)
//			new 연산자를 사용하여 만든 변수가 인자일때
//			int[], 배열, 객체,.a..a
//			참조에 의한 호출은 heap 메모리의 주소값을 보내는것 떄문에 발생하므로
//			원본 손실될 수 있음 주의!!!!!!!!!!!

//void func(int a, int[] b) --> a는 값에의한 호출 b는 참조에 의한 호출

//★★★★★오버로딩★★★★기능
//Java는 함수명 중복사용을 허용
//	단,
//	input과 output이 서로 달라야하고,
//	기능이 같아야합니다!

		// ★★★오버라이딩이나온다 나중에★★★
//JAVA에서 input(or output)을 보고 알아서 판단해서 호출합니다!~~

	}
}
