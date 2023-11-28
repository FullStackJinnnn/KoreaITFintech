package class03;

import java.util.Random;
import java.util.Scanner;

public class Test04 {
	
	public static void funcA() {
		//1유형
		Random rand = new Random();
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
		arr[i] = rand.nextInt(5)+1;	
		}
		System.out.print("랜덤 정수는 :");
		for (int datas : arr) {
			System.out.print(datas + " ");
		}
		System.out.print("최대값은 :");
		int max = arr[0]>arr [1]? (arr[0]>arr[2]? arr[0]:arr[2]) : (arr[1]>arr[2]? arr[1]:arr[2]);  
		System.out.println(max);
	}
	
	// 함수의 재사용성 용의함 !!2번
	public static int funcB() {
		//사용자에게 입력받는다!!!!!
	Scanner sc=new Scanner(System.in);
			System.out.println("더할 숫자 2개 입력하세요!!");
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int total = a+b;
			
			return total;

	}
	
	 
	public static int funcC(int a, int b) {
		int c = a<b? a:b;
		System.out.println("더작은값은 :" + c);
		return c;
	}
	
	public static void main(String[] args) {
		funcA();
		System.out.println();
		System.out.println(funcB());
		int num=funcB();
		System.out.println(num);
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("비교할 숫자를 2개 입력하세요");
		int a = sc.nextInt();
		int b = sc.nextInt();
		funcC(a,b);
	}
	
	
	
}
