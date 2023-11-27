package class03;

import java.util.Random;

public class Test02 {

	public static void funcB(int a, int b) {
		// 둘의 합을 console에 출력
		int total = a + b;
		System.out.println(a + "+" + b + "=" + total);

	}

	public static double funcC() {
		// 랜덤정수 3개를(랜덤 범위 1~10)을 생성하고
		Random rand = new Random();

		int[] datas = new int[3];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = (rand.nextInt(10) + 1);
		}
		// 생성된 3개의 함수 평균값을 출력
		int total = 0;
		for (int data : datas) {
			total += data;
		}
		System.out.println("total= " + total);
		double avg = total * 1.0 / datas.length;
		System.out.println("avg= " + avg);

		return avg;
	}

	public static void funcD(int a, int b) {
		if (a > b) {
			System.out.println("더큰값은 :" + a);
		} else if (a < b) {
			System.out.println("더큰값은 :" + b);
		} else {
			System.out.println("같은값! :" + a);
			;
		}
	}

	public static void main(String[] args) {

		funcB(5, 10);
		funcB(-2, 15);
		System.out.println("=================");
		System.out.println(funcC()); // funcC함수내에 print 2번출력하고 return된값 출력 총 3번

		double a = funcC(); // func함수내에 print2번 출력
		System.out.println(a); // return 값 출력

		System.out.println("===============");

		funcD(5, 9);
		funcD(5, 5);
		funcD(8, 3);
		funcD(-5, 8);
		funcD(999, 1);

		// !! 메서드를 만들기 전에 메서드 시그니쳐를 확인하자!!!!!!!!!

	}
}
