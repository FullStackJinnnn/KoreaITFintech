package codeup;

import java.util.Scanner;

public class codeuprecord {
	public static void main(String[] args) {			
	
		//1099
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
		
		//1098

		Scanner scan = new Scanner(System.in);

		int w = scan.nextInt();
		int h = scan.nextInt();
		int[][] board = new int[w][h];
		int n = scan.nextInt();
		for (int a = 1; a <= n; a++) {
			int l = scan.nextInt(); // 길아
			int d = scan.nextInt(); // 방향
			int row = scan.nextInt(); // 행 시작위치
			int column = scan.nextInt(); // 열 시작위치. (왼쪽 위 끝은 1행 1열이다.)

			if (d == 0) {
				for (int i = 1; i <= l; i++) {
					board[row - 1][column - 1 + (i - 1)] = 1;

				}
			} else {
				for (int i = 1; i <= l; i++) {
					board[row - 1 + (i - 1)][column - 1] = 1;

				}

			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
		//1097

		Scanner scan = new Scanner(System.in);

		int[][] board = new int[19][19];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int input = scan.nextInt();
				board[i][j] = input;
			}
		}
		int a = scan.nextInt();
		
		for (int i = 1; i <= a; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			for (int j = 0; j < 19; j++) // 가로 줄 흑<->백 바꾸기
			{
				if (board[x-1][j] == 0) {
					board[x-1][j] = 1;
				} else {
					board[x-1][j] = 0;
				}
			}
			for (int j = 0; j < 19; j++) // 세로 줄 흑<->백 바꾸기
			{
				if (board[j][y-1] == 0) {
					board[j][y-1] = 1;
				} else {
					board[j][y-1] = 0;
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
