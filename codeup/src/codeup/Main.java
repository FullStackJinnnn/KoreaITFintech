package codeup;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num;
        String str;
        int num2;
     
        System.out.print("num 입력> ");
        num = scan.nextInt();
        if (scan.hasNextLine()) {
        	System.out.println("왕");
        }
        System.out.print("str 입력> ");
        num2 = scan.nextInt();
        //문제발생 : 개행문자(엔터)가  str에 저장됨
        str = scan.nextLine();

        System.out.println();
        System.out.println("num : " + num);
        System.out.println("str : " + str);
        scan.close();
    }
}
