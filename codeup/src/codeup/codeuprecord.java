package codeup;

import java.util.Arrays;
import java.util.Scanner;

public class codeuprecord {
	public static void main(String[] args) {			
	
//		//1099
//		Scanner scan = new Scanner(System.in);
//
//		int[][] board = new int[10][10];
//		for (int i=0; i<board.length; i++) {
//			for(int j=0; j<board[i].length; j++) {
//				board[i][j] = scan.nextInt();
//			}
//		}
//		int exitcnt = 0;
//		int antx = 1 ;
//		for (int i=1; i<board.length; i++) {
//			for(int j=antx; j<board[i].length; j++) {
//				if (board[i][j]==1) {
//					antx = j-1;
//					break;
//				}
//				else if (board[i][j] == 2) {
//				board[i][j]=9;
//				exitcnt++;
//				break;
//				}
//				else {
//				board[i][j]=9;
//				}
//			}
//			if (exitcnt ==1) {
//				break;
//			}
//			
//		}
//		
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		//1098
//
//		Scanner scan = new Scanner(System.in);
//
//		int w = scan.nextInt();
//		int h = scan.nextInt();
//		int[][] board = new int[w][h];
//		int n = scan.nextInt();
//		for (int a = 1; a <= n; a++) {
//			int l = scan.nextInt(); // 길아
//			int d = scan.nextInt(); // 방향
//			int row = scan.nextInt(); // 행 시작위치
//			int column = scan.nextInt(); // 열 시작위치. (왼쪽 위 끝은 1행 1열이다.)
//
//			if (d == 0) {
//				for (int i = 1; i <= l; i++) {
//					board[row - 1][column - 1 + (i - 1)] = 1;
//
//				}
//			} else {
//				for (int i = 1; i <= l; i++) {
//					board[row - 1 + (i - 1)][column - 1] = 1;
//
//				}
//
//			}
//		}
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		//1097
//
//		Scanner scan = new Scanner(System.in);
//
//		int[][] board = new int[19][19];
//
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				int input = scan.nextInt();
//				board[i][j] = input;
//			}
//		}
//		int a = scan.nextInt();
//		
//		for (int i = 1; i <= a; i++) {
//			int x = scan.nextInt();
//			int y = scan.nextInt();
//			for (int j = 0; j < 19; j++) // 가로 줄 흑<->백 바꾸기
//			{
//				if (board[x-1][j] == 0) {
//					board[x-1][j] = 1;
//				} else {
//					board[x-1][j] = 0;
//				}
//			}
//			for (int j = 0; j < 19; j++) // 세로 줄 흑<->백 바꾸기
//			{
//				if (board[j][y-1] == 0) {
//					board[j][y-1] = 1;
//				} else {
//					board[j][y-1] = 0;
//				}
//			}
//		}
//		
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//			System.out.print(board[i][j] + " ");
//			}
//				System.out.println();
//		}
//		
		//-------if else 문 모음-----------------------
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//
//		int a = scan.nextInt();
//		if (a<10) {
//			System.out.println("small");
//		}
//		
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//
//		int a = scan.nextInt();
//		if (a<10) {
//			System.out.println("small");
//		} else {
//			System.out.println("big");
//		}
//			
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//
//		int a = scan.nextInt();
//		int b = scan.nextInt();
//		if (a>b) {
//			System.out.println(">");
//		} else if (a<b){
//			System.out.println("<");
//		} else {
//			System.out.println("=");
//			
//		}
//			
////utf-8로 인코딩해서 출력하는법..? codeup은 utf-8 한글만 지원하는가보다!
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
//		double a = scan.nextDouble();
//		double b = scan.nextDouble();
//	
//        String S1 = (a%2==0)?"짝수":"홀수";
//	   	String S2 = (b%2==0)?"짝수":"홀수";
//	    String S3 = ((a+b)%2==0)?"짝수":"홀수";
//	    
//	   	bw.write(S1+"+"+S2+"="+S3);
//	   	bw.flush();
//
//	   	
//	   	///창문그리기 1008번 번외편
//	   	
//	   	
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
//
//	
//        String S1 = "\u250C\u252C\u2510\n\u251C\u253C\u2524\n\u2514\u2534\u2518";
//
//	    
//	   	bw.write(S1);
//	   	bw.flush();
//
//	   	
//	   	
//	   	
//
//import java.util.Scanner;
//import java.util.*;
//import java.io.*;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
//		
//	
//		double a = scan.nextDouble();
//		double b = scan.nextDouble();
//		double c = scan.nextDouble();
//		double d = a-b+c;
//		String s1 = "대박";
//		String s2 = "그럭저럭";
//		
//		if (d%10 == 0) {
//			bw.write(s1);
//		} else {
//			bw.write(s2);
//		}
//		 	bw.flush();
//  
//
//
//import java.util.Scanner;
//import java.util.*;
//import java.io.*;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
//		
//	
//		double a = scan.nextDouble();
//		double b = scan.nextDouble();
//		double c = scan.nextDouble();
//		int d = (int)(a+b+c);
//		String s1 = "대박";
//		String s2 = "그럭저럭";
//
//		if ((d/100) %2 == 0) {
//			bw.write(s1);
//		} else {
//			bw.write(s2);
//		}	
//			bw.flush();
//		
//

//import java.util.Scanner;

//		Scanner scan = new Scanner(System.in);
//		String a = scan.next();
//		int b = scan.nextInt();
//		int c = scan.nextInt();
//		
//
//
//	
//		String str1 = String.format("%02d", b);
//		String str2 = String.format("%03d", c);
//		System.out.println(a+str1+str2);
//	
//
//		
//
//		Scanner scan = new Scanner(System.in);
//		int[] arr = new int[3];
//		for (int i= 0;  i< arr.length; i++) {
//			arr[i] = scan.nextInt();
//		}
//		Arrays.sort(arr);
//		System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
//		
//
//
//		Scanner scan = new Scanner(System.in);
//		int hr = scan.nextInt();
//		int m = scan.nextInt();
//		
//		if(m<30) {
//			if(hr==0) {
//				hr = hr +23;
//				m = m-30+60;
//			} else {
//				hr = hr-1;
//				m = m-30+60;	
//			}
//		}
//		else {
//			m = m-30;
//		}
//  
//		System.out.println(hr+" "+m);
//		import java.util.Arrays;
//		import java.util.Scanner;
//
//		public class Main {
//			public static void main(String[] args) {
//				Scanner scan = new Scanner(System.in);
//				int a = scan.nextInt();
//				int b = 0;
//				int c = 0;
//				
//				b = a/10;
//				c = a%10;
//				
//				a = (c*10 + b) * 2 ;
//				if (a>100) {
//					a -= 100;
//				}
//				if (a>50) {
//				System.out.println(a+"\nOH MY GOD");
//				} else {
//				System.out.println(a+"\nGOOD");
//				}
//		
//		import java.io.BufferedReader;
//		import java.io.BufferedWriter;
//		import java.io.IOException;
//		import java.io.InputStreamReader;
//		import java.io.OutputStreamWriter;
//		import java.util.Scanner;
//		
//		public class Main {
//			public static void main(String[] args) throws IOException {
//				Scanner scan = new Scanner(System.in);
//				BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
//				double a = scan.nextDouble();
//		
//			
//		        String S1 = (a>0)? "양수": ((a<0)? "음수":"0");
//		
//			    
//			   	bw.write(S1);
//			   	bw.flush();
//	
//	
//		import java.util.Arrays;
//		import java.util.Scanner;
//		
//		public class Main {
//			public static void main(String[] args) {
//				Scanner scan = new Scanner(System.in);
//				int a = scan.nextInt();	
//			    switch (a/10) {
//			        case 10: 
//			        case 9: System.out.println("A"); break;
//			        case 8: System.out.println("B"); break;
//			        case 7: System.out.println("C"); break;
//			        case 6: System.out.println("D"); break;
//			        default: System.out.println("F");
//			   
//
//
//		import java.util.Scanner;
//		
//		public class Main {
//			public static void main(String[] args) {
//				Scanner scan = new Scanner(System.in);
//				int a = scan.nextInt();
//			if(a/10!=1){	
//				if (a%10==1) {
//					System.out.println(a+"st");
//				}
//				else if (a%10==2) {
//					System.out.println(a+"nd");
//				}
//				else if (a%10==3) {
//					System.out.println(a+"rd");
//				}
//			else {
//					System.out.println(a+"th");
//				}                
//			}	else {
//					System.out.println(a+"th");
//				}
//		
//		import java.io.BufferedReader;
//		import java.io.BufferedWriter;
//		import java.io.IOException;
//		import java.io.InputStreamReader;
//		import java.io.OutputStreamWriter;
//		import java.util.Scanner;
//		import java.util.Arrays;
//		import java.util.Scanner;
//		
//		public class Main {
//			public static void main(String[] args) throws IOException {
//				Scanner scan = new Scanner(System.in);
//				BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
//				int a = scan.nextInt();
//				int b = scan.nextInt();
//				int c = scan.nextInt();
//				int d = scan.nextInt();
//				int e = a+b+c+d;
//				String s1 ="";
//				switch (e) {
//				case 0 : s1 = "모";
//				bw.write(s1);
//				bw.flush();
//				break;
//			
//				case 1 : s1 = "도";
//				bw.write(s1);
//				bw.flush();
//				break;
//				case 2 : s1 = "개";
//				bw.write(s1);
//				bw.flush();
//				break;
//				case 3 : s1 = "걸";
//				bw.write(s1);
//				bw.flush();
//				break;
//				case 4 :s1 = "윷";
//				bw.write(s1);
//				bw.flush();
//				break;
//				}
//		
//	}
//}

		
		
		

//import java.util.Scanner;

//		Scanner scan = new Scanner(System.in);
//		String a = scan.next();
//		int b = scan.nextInt();
//		int c = scan.nextInt();
//		
//
//
//	
//		String str1 = String.format("%02d", b);
//		String str2 = String.format("%03d", c);
//		System.out.println(a+str1+str2);
//	
//
//		
//
//		Scanner scan = new Scanner(System.in);
//		int[] arr = new int[3];
//		for (int i= 0;  i< arr.length; i++) {
//			arr[i] = scan.nextInt();
//		}
//		Arrays.sort(arr);
//		System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
//		
//
//
//		Scanner scan = new Scanner(System.in);
//		int hr = scan.nextInt();
//		int m = scan.nextInt();
//		
//		if(m<30) {
//			if(hr==0) {
//				hr = hr +23;
//				m = m-30+60;
//			} else {
//				hr = hr-1;
//				m = m-30+60;	
//			}
//		}
//		else {
//			m = m-30;
//		}
//  
//		System.out.println(hr+" "+m);

//// 1254
//		import java.util.Scanner;
//
//		public class Main {
//			public static void main(String[] args) {
//				
//				Scanner sc = new Scanner(System.in) ;
//				String a = sc.next();
//				String b = sc.next();
//				char c = a.charAt(0);
//				char d = b.charAt(0);
//				for (int i=c; i<=d; i++) {
//					System.out.print((char)i+" ");
//				}
//			}
//		}
//		
//// 1255
//		import java.util.Scanner;
//
//		public class Main {
//			public static void main(String[] args) {
//
//				Scanner sc = new Scanner(System.in);
//				Double a = sc.nextDouble();
//				Double b = sc.nextDouble();
//				for (Double i = a; i <= b; i = i + 0.01) {
//					System.out.printf("%.02f",i);
//					System.out.print(" ");
//
//				}
//
//			}
//		}
//// 1261
//		package codeup;
//
//		import java.util.Scanner;
//
//		public class Main {
//			public static void main(String[] args) {
//
//				Scanner sc = new Scanner(System.in);
//				for (int i = 0; i <= 9; i ++) {
//					int a = sc.nextInt();
//					if (a%5==0) {
//						System.out.println(a);
//						break;
//				}
//					else if (i==9) {
//						System.out.println(0);
//					}
//				}
//
//			}
//		}
//// 1270
//		import java.util.Scanner;
//
//		public class Main {
//			public static void main(String[] args) {
//
//				Scanner sc = new Scanner(System.in);
//				int a = sc.nextInt();
//				int cnt = 0;
//				for (int i = 0; i <= a; i++) {
//					if (i % 10 == 1) {
//						cnt++;
//					}
//				}
//				System.out.println(cnt);
//			}
//		}
//// 1272
//		
//		package codeup;
//
//		import java.util.Scanner;
//
//		public class Main {
//			public static void main(String[] args) {
//
//				Scanner sc = new Scanner(System.in);
//				int i =2;
//				int answer =0;
//				while ( i > 0) {
//					int a = sc.nextInt();
//					int cnt = 0;
//					if (a % 2 != 0) {
//						while (a > 0) {
//							a -= 2;
//							cnt++;
//						}
//						a = cnt;
//					} else {
//						a = a / 2 * 10;
//					}
//					answer += a;
//					i--;
//				}
//				System.out.println(answer);
//			}
//		}\
	}
}