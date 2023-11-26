
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
		int exitcnt = 0;
		int antx = 1 ;
		for (int i=1; i<board.length; i++) {
			for(int j=antx; j<board[i].length; j++) {
				if (board[i][j]==1) {
					antx = j-1;
					break;
				}
				else if (board[i][j] == 2) {
				board[i][j]=9;
				exitcnt++;
				break;
				}
				else {
				board[i][j]=9;
				}
			}
			if (exitcnt ==1) {
				break;
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