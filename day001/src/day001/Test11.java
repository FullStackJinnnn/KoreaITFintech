package day001;

public class Test11 {
	public static void main(String[] args) {
		//문제풀이
		// "한글코딩" : 의사코딩,스도우코딩,...
		// 그냥 코딩을 작성하는데에는 반드시 한계가 존재함
		// "협업" << 다른사람이 모르는데 ...???

		// 1: num을 정의(1~100사이의 양수 정수)
		// 2: num이 짝수일까?
		// 2~2: 짝수라면 짝수입니다 출력
		// 3: num이 홀수일까?
		// 3-2: 홀수라면 홀수입니다 출력
		int num=33;
		boolean flag=num%2==0?true:false;
		//플래그 변수: 주로 T,F 확인지표가 되는 변수를 의미함
		
		if(flag) {
			System.out.println(num + "은 (는)짝수입니다.");
		} else {
			System.out.println(num + "은 (는)홀수입니다.");
		}
	}
}
