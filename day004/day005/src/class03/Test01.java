package class03;

public class Test01 {
	
	// input X output O
	// JAVA에서는 output 모든 타입이 가능하지만,
	// 단 1개만 반환할수있음 !
	public static int funcA() {
		System.out.println("funcA()는 5를 반환하는 함수입니다.");
		return 5;
	
	}
	
	public static void main(String[] args) {
		
		funcA();
		System.out.println(funcA());
		// Run-> main, print 수행해야하는 함수 2개임
		// -> funA() -> println()
		// 8-> 16-> 19-> 23->24
		int num = funcA();
		System.out.println("funcA()의");
		
	}
}
