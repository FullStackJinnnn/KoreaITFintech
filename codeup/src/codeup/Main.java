
package codeup;


import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
		
	
		double a = scan.nextDouble();
		double b = scan.nextDouble();
		double c = scan.nextDouble();
		double d = a+b+c;
		String s1 = "대박";
		String s2 = "그럭저럭";
		System.out.println((d/100) %2);
		if ((d/100) %2 == 0) {
			bw.write(s1);
		} else {
			bw.write(s2);
		}	
			bw.flush();
		
  

	}
}