
package codeup;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[][] board = new int[19][19];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int input = scan.nextInt();
				board[i][j] = input;
			}
		}
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();

		for (int i = 1; i <= a; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			for (int j = 1; j <= 19; j++) // 가로 줄 흑<->백 바꾸기
			{
				if (board[x][j] == 0) {
					board[x][j] = 1;
				} else {
					board[x][j] = 0;
				}
			}
			for (int j = 1; j <= 19; j++) // 세로 줄 흑<->백 바꾸기
			{
				if (board[j][y] == 0) {
					board[j][y] = 1;
				} else {
					board[j][y] = 0;
				}
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
			System.out.print(board[i][j] + " ");
			}
		System.out.println();
		}
	}
}