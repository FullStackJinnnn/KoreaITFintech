
package codeup;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[][] board = new int[10][10];
		for (int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = scan.nextInt();
			}
		}
		
		for (int i=1; i<board.length-1; i++) {
			for(int j=1; j<board[i].length-1; j++) {
				if (board[i][j++]==1) {
				break;
				}
				board[i][j]=9;
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