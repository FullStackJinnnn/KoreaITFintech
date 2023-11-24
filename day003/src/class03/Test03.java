package class03;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		
		//3개의 랜덤 정수를 저장해주세요.
		// 랜덤값은 1~10까지 중에서 저장됩니다.
		
		int[] data = new int[3];
		Random rand = new Random(); //중복도 나온다.
		for (int i=0; i<data.length; i++) {
			data[i] = rand.nextInt(10) + 1;
		}
		System.out.print("[ ");
		for (int arr : data) {
			System.out.print(arr + " ");
		}
		System.out.println("]");
	
	}
}
