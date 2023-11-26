package teamam;

import java.util.Scanner;

public class Binarysearch {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//오름차순 배열 생성
		int[] array = new int[8];
		array[0] = -9;;
		array[1] = -4;
		array[2] = 0;
		array[3] = 10;
		array[4] = 38;
		array[5] = 50;
		array[6] = 100;
		array[7] = 1300;
		
		//이진 탐색을 위한 시작 인덱스, 마지막 인덱스 선언 및 대입
		int lowIdx = 0; 
		int highIdx = array.length-1;

	
		// 배열 출력 및 찾는 값 입력
		System.out.print("[ ");
		for (int arrdata : array) {
			System.out.print(arrdata+" ");
		}
		System.out.println("]");
		
		System.out.println("다음 배열중 찾으시는 값을 입력하세요.");
		int key = sc.nextInt(); //찾고자 하는 값 입력
		
		
		
		while (lowIdx <= highIdx) {  //low인덱스가 high인덱스보다 작거나 같을때 까지 반복
			
			// low, high 인덱스가 바뀔 때 마다
			//중간인덱스를 계속 재설정 해서 탐색 범위를 좁혀나간다.			
			int midIdx = (lowIdx + highIdx)/2; 
			if (key==array[midIdx]) { //원하는값 == 중간값 이면 종료
				System.out.println("찾으시는 값 : "+array[midIdx]+"\n찾으시는 값의 인덱스 : "+midIdx);
				break;
			}
			else if (key>array[midIdx]) { //원하는값이 중간값보다 크면
				lowIdx = midIdx+1; // 중간값인덱스 +1을 시작인덱스에 대입.
				}
			else if (key<array[midIdx]) { //원하는값이 중간값보다 작으면
				highIdx = midIdx-1; // 중간값인덱스 -1을 마지막인덱스에 대입.
			}
		}
		System.out.println("찾는 값이 없습니다.");
			
	}
}
