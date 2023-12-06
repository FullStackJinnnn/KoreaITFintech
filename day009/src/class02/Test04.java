package class02;

import java.util.Random;
import java.util.Scanner;

class Person {
   String name;
   int age;
   Person(String name,int age){
      this.name=name;
      this.age=age;
   }
   void printInfo() {
      System.out.println(this.name+"님 "+this.age+"살");
   }
}
class Student extends Person {
   int score;
   Student(String name,int age){
      this(name,age,new Random().nextInt(101));
   }
   Student(String name,int age,int score){
      super(name,age);
      this.score=score;
   }
   @Override
   void printInfo() {
      System.out.println(this.name+"학생 "+this.age+"살 "+this.score+"점");
   }
   void test() {
      this.score=new Random().nextInt(101-this.score)+this.score;
      System.out.println(this.name+"학생이 재시험을 봤습니당~^^");
   }
}
class Emp extends Person {
   String dep;
   Emp(String name,int age){
      this(name,age,"인턴");
   }
   Emp(String name,int age,String dep){
      super(name,age);
      this.dep=dep;
   }
   @Override
   void printInfo() {
      System.out.println(this.dep+"팀 "+this.name+"님 "+this.age+"살");
   }
}

public class Test04 {

   public static void main(String[] args) {

      Person[] datas=new Person[5];
      int index=0;

      Scanner sc=new Scanner(System.in);

      while(true) {
         System.out.println("1. 사람 추가");
         System.out.println("2. 사람 목록 출력");
         System.out.println("3. 전체 재시험");
         System.out.println("4. 프로그램 종료");
         System.out.print("입력 >> ");
         int action=sc.nextInt();
         if(action==1) {
            while(true) {
               System.out.println("1. 학생 추가");
               System.out.println("2. 직원 추가");
               System.out.print("입력 >> ");
               action=sc.nextInt();
               if(1<=action && action<=2) {
                  break;
               }
               System.out.println("다시입력해주세요!");
            }
            if(action==1) { // 학생 추가
               System.out.print("이름입력 >> ");
               String name=sc.next();
               System.out.print("나이입력 >> ");
               int age=sc.nextInt();
               // 성적입력 >> 
               datas[index++]=new Student(name,age);
            }
            else if(action==2) { // 직원 추가
               System.out.print("이름입력 >> ");
               String name=sc.next();
               System.out.print("나이입력 >> ");
               int age=sc.nextInt();
               // 부서입력 >> 
               datas[index++]=new Emp(name,age);
            }
         }
         else if(action==2) {
            if(index<=0) {
               System.out.println("데이터없음!");
               continue;
            }
            for(int i=0;i<index;i++) {
               datas[i].printInfo();
            }
         }
         else if(action==3) {
            for(int i=0;i<index;i++) {
               if(datas[i] instanceof Student) {
                  datas[i].printInfo();
                  Student stu=(Student)datas[i]; // 강제 형변환, 캐스팅
                  stu.test();
               }
            }
         }
         else {
            break;
         }
      }

   }

}