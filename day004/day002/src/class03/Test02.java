package class03;

public class Test02 {
	public static void main(String[] args) {
		
	
//	[문제1]
//	정수 3인 a와 1인 b가 있습니다.
//	1부터 3까지 모두 출력해주세요
	int a = 3;
	int b = 1;
	for (int i=b; i<=a; i++) {
		System.out.println(i + " ");
	}
//	
//	[문제2]
//	이번에는 3부터 1까지 -1씩 빼가면서 출력해주세요
	System.out.println("====================");
	for (int i=a; i>=1; i--) {
		System.out.println(i + " ");
	}
	
//			
//	[문제3]
//	1부터 10까지 출력하는데,,
//	단! 홀수만 출력해주세요!!
	System.out.println("====================");
	for (int i=1; i<=10; i++) {
		if (i%2!=0) {
			System.out.println(i + " ");
		}
	}
//	
//	[문제4]
//	i는 3입니다.
//	3부터 무한하게 2씩 증가시키면서 출력해주세요
//	단, i가 1000이 넘어가면 종료
	System.out.println("====================");
	int i = 3;
	while(true) {
		System.out.println(i);
		if (i>1000) {
			break;
		}
		i+=2;

	}

	}
}