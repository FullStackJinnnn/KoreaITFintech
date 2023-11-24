package class03;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		
//		랜덤 정수를 5개 저장할수있는 배열이 있습니다
//		1~6까지 랜덤하게 저장해주세요
//		
//		1) 2가 몇번 나왔는지
//		2) 총합이 몇인지
//		3) 평균이 몇인지 >> 0.00 소수점까지 
//		출력해주세요!!!!!!!!!
		
		int count=0;
		int total=0;
		double avg=0;
		int[] randArr = new int[5];
		Random rand = new Random();
		for (int i=0; i<randArr.length; i++) {
			randArr[i] = rand.nextInt(5)+1;
		}
		
		for (int arr : randArr) {
			System.out.print(arr + " ");
		}
		
		
		for (int i=0; i<randArr.length; i++) {
			if (randArr[i] == 2) {
				count ++;
			}
		}
		
		for (int i=0; i<randArr.length; i++) {
			total += randArr[i];
			avg = total/(randArr.length*1.0);
			}
		
		System.out.println("\n\n2가 나온 횟수 : " + count);
		System.out.println("\n총합 : " + total);		
		System.out.print("\n평균 : ");
		System.out.printf("%.2f", avg);
		
	}
}
