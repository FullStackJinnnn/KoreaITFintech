package class02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {

		int stu1 = 80;
		int stu2 = 15;
		int stu3 = 60;

		// int ->4바잍 공간을 만들고 만들면 주소가 나온다 하지만 복잡함으로 stu1로 지정.
		// 상위 코드는 메모리에 공간을 3개를 만든다.
		// 초기화(값 설정이) 되지않은 변수는
		// 출력 xxxx
		// 변수가 생성될 수 있는 공간 위치는 랜덤하다. 주소값은 생성될때마다 바뀜.
		//

		// 배열이란 ?
		// 여러개의 변수를 깔끔하게 정리해서
		// 한 공간에 저장할수있도록 하는 "자료형"
		// 1. 보다 더 많은 공간을 활용할 수 있음
		// 2. 데이터를 접근할때 보다 빠르게 접근가능

		int[] stuArr = new int[3];
		// new 연산자 ★
		// 개발자 전용 메모리 공간(Heap 메모리) 에
		// 데이터를 생성해주세요!~~~
		// = 보다 new 연산자가 먼저다.
		// int 배열 공간을 만든다. -> 주소가나오고 이름을 stuArr이라고 붙임. -> new연산자 (힙 메모리에 만들어달라는 연산)
		// -> int3개짜리 공간을 heap메모리에 생성 그 주소를 stuArr공간에 저장.
		System.out.println(stuArr);
		// -> 주소값이 출력 즉 heap메모리에 생긴 int 3개짜리 공간의 주소값이 stuArr에
		// 담겨있기 때문에 주소값 출력 (hash값)

		stuArr[0] = 80;
		stuArr[1] = 15;
		stuArr[2] = 50;
		// 인덱스(index)
		// 1번 인덱스에는 2번 학생의 정보가 있다.

		System.out.println(Arrays.toString(stuArr));
		// 배열의 길이만큼
		// 배열의 요소 개수 만큼
		// 배열의 크기만큼
		// 배열의 length만큼
		// 배열의 size만큼
		for (int i = 0; i < stuArr.length; i++) {
			System.out.println((i + 1) + "번쨰 학생의 점수는 " + stuArr[i] + "입니다");
		}

		// 5,3 등의 상수를 직접 작성하는 것 == 하드코딩
		// 안좋다!!!!!!!!!!!!!!!!!!!

	}
}
