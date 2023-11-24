package class04;

public class Test01 {

	public static void main(String[] args) {
	//중첩 제어문
	//중첩 반복문
	//중첩 for문(이중 for문) << 별찍기
	
	// 구구단 문제

	
		//[1]
		for(int a=0; a<5; a++ ) {	
			for (int i=0; i<=a; i++) {
				System.out.print("*");
				}
			System.out.println();
			}
	
		System.out.println("==================");
	
	
		//[2]
		for(int a=0; a<5; a++) { 	
			for (int i=0; i<5-a; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("==================");

	
		//[3]
		for (int a=0; a<5; a++) {
				
			for (int i=0; i<a; i++) {
				System.out.print(" ");
			}
			for (int i=0; i<5-a;
					i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		System.out.println("=================");
		
		// 공백은 0부터 4개 까지 증가
		// 별은 5개부터 1개까지 감소
		for (int a=0; a<5; a++) {
			for (int i=1; i<=5; i++) {
				if (a<i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
}
