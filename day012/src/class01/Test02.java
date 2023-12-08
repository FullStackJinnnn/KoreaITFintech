package class01;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("정수입력 >>");
			try {
				int ans = sc.nextInt();
				if (ans < 1 || ans > 10) {
					System.out.println("1~10 사이로 입력해주세요!");
				} else {
					System.out.println(ans + "를 입력했습니다 :D");
					break;
				}
			} catch (Exception e) {
				sc.nextLine(); //버퍼 공간에 있는 잘못 입력된 값을 제거하는 역할 --> 안써주면 잘못된 입력값이 남아있어서 무한루프돈다.
				System.out.println("정수를 입력해주세요!");
				continue;
			}
		}

		
//		
//		int[] arr = new int[5];
//		arr[0] = 10;
//		arr[1] = 1;
//		arr[2] = 2;
//		arr[3] = 0;
//		arr[4] = -2;
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수입력");
//		int ans = sc.nextInt();
//		System.out.println("(100/배열리스트의" +ans+"번째정수)의 결과를 출력해주세요");
//		try {
//		System.out.println("100/"+arr[ans-1]+"="+(100/arr[ans-1]));
//		}
//		catch(Exception e) {
//			System.out.println("100/0 의 경우 0으로 나눌 수 없습니다.");
//		}
	}
}



