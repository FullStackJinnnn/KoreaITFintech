package class02;

public class Test04 {
	public static void main(String[] args) {
		//[문제1]
		//i가 1입니다.
		//i가 3씩 증가합니다.
		//이런 i의 변화를 출력해주세요.
			//단, 출력되는 값이 1부터
		//i가 20이 넘어갈때까지 계속
		
		int i=1;
		
		while(i<=20) {
			System.out.println("i = " + i );
			i+=3;
		}
		System.out.println("");
		
		//[문제2]
		//i는 3
		//영원히 i를 1씩 마이너스.
		//이런 i의 변화를 출력해주세요.
		
			//단, 출력되는 값은 2부터
		//해당 프로그램은 i가 -5가 되면 종료됩니다.
		
		int j=3;
		while (j>-5) {
			j--;
			System.out.println("i = " + j);
		}
	}
}
