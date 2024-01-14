package codeup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws ParseException {

        Scanner scan = new Scanner(System.in);

        int num;
        String str;
        int num2;
     
//        System.out.print("num 입력> ");
//        num = scan.nextInt();
//        if (scan.hasNextLine()) {
//        	System.out.println("왕");
//        }
//        System.out.print("str 입력> ");
//        num2 = scan.nextInt();
//        //문제발생 : 개행문자(엔터)가  str에 저장됨
//        str = scan.nextLine();
//
//        System.out.println();
//        System.out.println("num : " + num);
//        System.out.println("str : " + str);
//        scan.close();
        String d = "19930910";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        java.util.Date day = formatter.parse(d);
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(day.getTime());
        System.out.println(sqlDate);
    }
}
