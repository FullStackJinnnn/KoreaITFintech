package class01;

import java.util.Iterator;

public class bubblesort {
	public static void main(String[] args) {

		int[] arr = new int[5];
		arr[0] = 3;
		arr[1] = 2;
		arr[2] = 5;
		arr[3] = 1;
		arr[4] = 4;

		for (int a = 0; a < arr.length - 1; a++) {
			for (int i = 0; i < arr.length - 1 - a; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
