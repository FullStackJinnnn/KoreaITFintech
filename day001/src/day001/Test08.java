package day001;

public class Test08 {
	public static void main(String[] args) {
		// 삼향(조건) 연산자
		
		// 조건식? T:F 
		
		int result = 100>500? 3:-3;
		System.out.println("result="+result);
		
		int a=10,b=20;
		int c=b++ + ++a;
		int d=c--*2;
		int e=b/d<5? 10:11;
//		a 11
//		b 21
//		c 30
//		d 62
//		e 10
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
//		System.out.println(e);
		
		
	}
}
