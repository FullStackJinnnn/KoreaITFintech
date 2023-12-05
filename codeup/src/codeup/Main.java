
package codeup;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i =2;
		int answer =0;
		while ( i > 0) {
			int a = sc.nextInt();
			int cnt = 0;
			if (a % 2 != 0) {
				while (a > 0) {
					a -= 2;
					cnt++;
				}
				a = cnt;
			} else {
				a = a / 2 * 10;
			}
			answer += a;
			i--;
		}
		System.out.println(answer);
	}
}