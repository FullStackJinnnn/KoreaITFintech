package itacademy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < a; i++) {
			list.add(sc.nextInt());
		}
		a = sc.nextInt();
		for (int i = 0; i < a; i++) {
			list2.add(sc.nextInt());
		}
		Iterator<Integer> iterator = list2.iterator();
		while (iterator.hasNext()) {
		   int b = iterator.next();
		   if (list.contains(b)) {
			   list2.set(iterator., 1);
		   }
		}
	

	}
}