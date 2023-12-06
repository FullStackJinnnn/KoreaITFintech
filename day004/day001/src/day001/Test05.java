package day001;

public class Test05 {
	public static void main(String[] args) {
		
		int a=10;
		int b=5;
		int c=a++ - --b;
		System.out.println("c = " + c);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		int d = 5;
		System.out.println("c = " + c);
		
		//= 후위증감 -> 우선순위가 낮음
		
//		=우선순위가 낮음
//		전위증감 우선순위가 매우 높음
//		후위증감 우선순위가 매우 낮음
		
		int num1=12;
		int num2=32;
		int num3=++num2 / num1--;
//		num1 = 11
//		num2 = 33
//		num3 = 2
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
	}
		
}
