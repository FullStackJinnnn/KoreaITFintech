package class01;

import java.util.ArrayList;
import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		Random rand = new Random();
		int ranNum = rand.nextInt(21) + 10;
		int total=0;
		double avg=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < ranNum; i++) {
			if (i % 2 != 0) {
				list.add(i);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i);
		}
		avg = total*1.0/list.size();
		System.out.println(list);
		System.out.println(total);
		System.out.printf("%.02f",avg);
		
		
		
	}
}
