package class01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {

	public static int numreturn() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 >> ");
		int num = sc.nextInt();
		return num;
		
	}
	
	public static void main(String[] args) {

		int num;
		try {
			int a = 10, b = 3;
			System.out.println(a / b);

			System.out.println("-----");

			int[] datas = new int[3];
			System.out.println(datas[1]);

			System.out.println("-----");

			Scanner sc = new Scanner(System.in);
			System.out.print("정수입력 >> ");
			int action = sc.nextInt();
			while (true) {
				action = sc.nextInt();
			
				if (action == 1) {
					System.out.println("1");
					break;
				}
				else if ( action ==2 ) {
					System.out.println("2");
					break;
				}
			}
			//System.out.println("num= " + num);
		} catch (ArithmeticException e) {
			System.out.println("0으로는 나눌수없습니다!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위초과로 출력 불가능합니다!");
		} catch (InputMismatchException e) {
			System.out.println("num을 100으로 초기화합니다...");
//			num = 100;
//			System.out.println("num= " + num);
		}

	}

}
