
package codeup;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int hr = scan.nextInt();
		int m = scan.nextInt();
		int hr2 =0;
		int m2  =0;
		
	
	     hr2=hr;
	     m2=m-30;
	      if(m2<0) {
	         m2+=60;
	         hr2--;
	      }
	      if(hr2<0) {
	         hr2+=12;
	      }
	      System.out.println(hr2+" "+m2);
	    

		}
}