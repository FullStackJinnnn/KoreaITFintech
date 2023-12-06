package class03;

import java.util.Arrays;

//자료구조 : 데이터 관리를 유이하게 해보자!
//			다양한 자료형을 공부함
//			메모리 관리 용이 >> 배열
//알고리즘 : 문제를 좋게 해결하는 과정을 생각해보자!
//			자료형과 관련된 로직을 공부함
//			효율성,속도가 빨라짐, 성능이 좋아짐
// [배열과 관련된 알고리즘(로직)]
// 1. 최대값(최소값) 찾기 알고리즘
// 2. 탐색(검색) 알고리즘 : search / 일반 검색, 최적화된 검색 ->이진탐색이 제일빠름
// 탐색 알고리즘을 사용하려면
// 특히 최적화된 검색을 하려면 ★
// => 정렬을 반드시 선행해야만합니다!!!!!!!!! -> 우리조는 정렬이 되어있는 상태로 진행해야한다.

// 3. 정렬 알고리즘 : 빠른 탐색(검색)을 위한 전제조건
// 4. 중복제거 알고리즘 : 랜덤값으로 배열을 저장한다면 중복이될수있음! >> 중복값이 안나오도록 코딩해주세요!


public class Test01 {
	public static void main(String[] args) {
		
		// 1. 최대값 찾기 알고리즘 
		// 5개의 서로다른 정수 데이터를 저장한 배열이 존재합니다.
		// 가장 큰 값을 가진 index의 위치와
		// 그 값(가장 큰 값)을 출력해주세요!!!
		
		int[] numArr = new int[5];
		for (int i=0; i<numArr.length; i++) {
			numArr[i] = (int) (Math.random()*100+1);
		}
		System.out.println(Arrays.toString(numArr));
		int maxIndex=0;
	
		// max 현재 에쌍중인 가장 큰 값
		
		// maxIndex -> max가 저장된 index 위치
		
		// O(권장) 비교를 [1] index부터 [4] index까지
		// 비교를 2번째 데이터부터 5번째 데이터까지
		// for 문 !
		for (int i=1; i<numArr.length; i++) {
			if (numArr[maxIndex] <numArr[i]) {
				numArr[maxIndex] = numArr[i];
				maxIndex = i;
			}
		}
		System.out.println("최대값 : " + numArr[maxIndex]);
		System.out.println("최대값인덱스 : " + maxIndex);
		// ==> 디버깅표 그리기 ㅠㅠ
		
		
		System.out.println("====================");
		
//		[ 10 2 5 -3 1 ]
//		최소값을 찾아주세요
//		
//		최소값은
//		3번 index에 있는 -3입니다!
		
		int[] Arr = new int[5];
		Arr[0] = 10;
		Arr[1] = 2;
		Arr[2] = 5;
		Arr[3] = -3;
		Arr[4] = 1;
		
		System.out.println(Arrays.toString(Arr));
		
		int minIndex = 0;
		
		for (int i=1; i<Arr.length; i++) {
			if (Arr[minIndex] > Arr[i]) {
				Arr[minIndex] = Arr[i];
				minIndex = i;
			}
		}

		System.out.print("최소값은\n" + minIndex +"번 index에 있는" + Arr[minIndex] + "입니다!");
		
		
		
		
		
	}
}
