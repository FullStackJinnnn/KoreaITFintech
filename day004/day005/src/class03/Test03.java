package class03;

public class Test03 {
	// input O output O
	// 인자가 int 타입 2개,
	// output이 int 1개인 funcA() 함수가 있다!
	public static int funcA(int a, int b) {
		int result = a+b;
		System.out.println("a+b= "+ result);
		return result;
	}
	
	
	
	public static void main(String[] args) {
	
		System.out.println(funcA(10,20));
		
		int result=funcA(1,2);
		System.out.println(result);
		
		
	}
	
}
