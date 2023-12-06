package itacademy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hr = sc.nextInt();
		int min = sc.nextInt();
		min -= 45;
		if (min<0) {
			hr--;
			min +=60;
		}
		if (hr<0) {
			hr +=24;
		}
		System.out.println(hr + " "+ min);
		
	}
}