package class01;

import java.util.Scanner;

public class Test02 {

   // 확인용 로직

   // 1) 입력된 정수값이 범위에 해당하나요?
   // 사용자가 정수를 입력함
   // 이 입력값이 a~b 사이의 범위값이 맞는지 확인
   public static boolean funcA(int a,int b) {
      Scanner sc=new Scanner(System.in);
      System.out.print("정수입력 >> ");
      int input=sc.nextInt();

      if(a<=input && input<=b) {
         return true;
  //intput<a && b<input 밖에 어떤일이 일어나던지 아무상관이 없는것 처럼 된다.
  //조건 안에 들어왔을때 true를 주는것이 바람직하다.
      }
      return false;
   }
   // 사용자가 정수를 입력함
   // 이 입력값이 a~b 사이의 범위값이 맞는지 확인
   // a~b 사이의 범위값으로 제대로 입력할때까지 계속하고,
   // 제대로 입력되었다면 main()으로 입력값 반환
   public static int funcB(int a,int b) {
      Scanner sc=new Scanner(System.in);
      int input;
      while(true) {
         System.out.print("정수입력 >> ");
         input=sc.nextInt();
         if(a<=input && input<=b) {
            break;
          //return input 써도 알아서 함수 빠져나가지만 읽기 어렵다.
          //break를 사용해서 이렇게 해주는것이 좋다/
          //break쪽에 return input을 써도 되는데 그러면 나중에 찾기힘들다.
         }
      }
      return input;
   }

   // 2) 특정 배열에 특정 값이 존재하나요?
   // 배열에 어떤 값이 있는지 확인
   // 있으면 T 없으면 F
   public static boolean funcC(int[] datas,int key) {
      boolean flag=false; // 플래그 변수
      
      for(int data:datas) {
         if(data==key) {
            flag=true;
            break;
         // 그냥 break안쓰고 flag로만 판단하는거보다 break를 걸고 
         //true가나오는지 확인해주는 것이 더 예외상황이 발생할 황률이 적다. 
         }
      }
      
      return flag;
   }
   public static int funcD(int[] datas,int key) {
      int keyIndex=-1;
      // 아~ -1이 반환되었네? key 값이 배열에 없구나~~
      
      for(int i=0;i<datas.length;i++) {
         if(datas[i]==key) {
            keyIndex=i;
         }
      }
      
      return keyIndex;
   }   
   
   // 3) 이 배열이 정렬되었나요?
   // 배열이 있을때
   // 정렬되었다면 T 아니면 F
   public static boolean funcE(int[] datas) {
      boolean flag=false;
      
      int i;
      for(i=0;i<datas.length-1;i++) {
         if(datas[i] > datas[i+1]) {
            break;
         }
      }
      if(i>=datas.length-1) {
         flag=true;
      }
      
      return flag;
   }

   public static void main(String[] args) {
      
      int a=1,b=5,c=10;
      int[] datas=new int[5];
      // [ 10 20 30 40 50 ]
      for(int i=0;i<datas.length;i++) {
         datas[i]=(i+1)*10;
      }
      
      /*
      if(funcA(a,b)) {
         System.out.println("맞음");
      }
      else {
         System.out.println("아님");
      }
      System.out.println("제대로 입력한 값은 "+funcB(a,b)+"입니다.");
      */
      
      if(funcC(datas,c)) { // 조건식에 함수가있다? output타입이 boolean이다!
         System.out.println("있음");
      }
      else {
         System.out.println("없음");
      }
      int output=funcD(datas,c);
      if(output!=-1) {
         System.out.println(c+"는 ["+output+"]에 있습니다.");
      }
      else {
         System.out.println(c+"는 없습니다...");
      }
      
      datas[0]=1000;
      if(funcE(datas)) {
         System.out.println("정렬됨");
      }
      else {
         System.out.println("정렬안됨");
      }
   }

}