package class01;

public class Test01 {
	public static void main(String[] args) {
		
		// [문제]
		// 10,7,2가 저장된 변수가 3개 있습니다.
		// 세 변수 a,b,c의 총합을 출력해주세요.
		// "10,7,2의 총합은 19입니다."
		// 그리고
		// 세 변수의 평균값을 출력해주세요.
		// "10,7,2의 평균은 6.333333입니다."
		// 만약, 평균값이 5이상이라면
		// 평균이 높습니다!
		// 만약 평균값이 5미만이라면
		// 평균이 낮습니다...
		// 라고 출력해주세요!~~
		int a=10, b=7, c=2;
		int total = a+b+c;
		//double avg = (double)total/3;
		double avg = total*1.0/3;
		// 6.0이 나오는 이유? => 연산자 우선순위 떄문!!!
		// 이문제해결방법 ?
		// total값을 가장 먼저 double로 변환(형변환,캐스팅)
		// *1.0 하기
		
		System.out.println(a+","+b+","+c+"의 총합은"+total+"입니다.");
		System.out.print(a+","+b+","+c+"의 평균은");
		System.out.printf("%.6f",avg);
		System.out.print("입니다.\n");
	
		if (avg>=5) {
			System.out.println("평균이 높습니다!");
		} else {
			System.out.println("평균이 낮습니다!");
		}
		
	}
}
