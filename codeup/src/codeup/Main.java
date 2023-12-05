
package codeup;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {
	static int lotto(int[] lottoNum, int[] userLotto) {
		
		int bonus = 0;
		int answer = 0;
		int count = 0;
		for (int i = 0; i < lottoNum.length-1; i++) {
			for (int j = 0; j < userLotto.length; j++) {
				if (lottoNum[i] == userLotto[j]) {
					count++;
				}
			}
		}
		for (int i = 0; i < lottoNum.length; i++) {
				if (lottoNum[lottoNum.length-1] == userLotto[i]) {
					bonus++;
				}
		}
					
		
		if (count < 3) {
			return 0;
		} else if (count == 3) {
			return 5;
		} else if (count == 4) {
			return 4;
		} else if (count == 5 && bonus ==1) {
			return 3;
		} else if (count == 6) {
			return 1;
		} else if (count == 5) {
			return 2;
		} else return-1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] num = new int[7];
		int[] user = new int[6];
		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();
		}
		for (int j = 0; j < user.length; j++) {
			user[j] = scan.nextInt();
		}
		int answer = lotto(num, user);
		System.out.println(answer);

	}
}