package class02;

//제어문:조건문
//-> 만약 ~ 라면, ~~한다면,~특정조건으르 만족한다면, ...
// 제어문 : 반복문
// -> 여러번,무한,계속,N회,a부터 b까지, 범위,특정조건을 만족하는동안에,
//while 은 몇번 반복할지 모를떄
// for 는 알고있을때까지 반복
public class Test01 {
	public static void main(String[] args) {
		// 0인 i가 있습니다.
		// 이 i값이 +1 될 예정이고,
		// 이 행위를 3이 될때까지 계속 해주세요.
		
		int i=0;
		while(i<=3) { // while(조건식) => 해당 조건식이 T 일때에만 반복문을 수행
			i++;
			System.out.println("i= "+i);
		} // 반복문의 끝블럭을 절대로 그냥 통과 X
		// 반드시 첫블럭으로 돌아간다.
		
		//반복문을 사용하면
		//1. 코드를 재사용할수있다!
		//2. 코드 가독성이 좋아짐
		//3. 개발 비용이 절감 => 영업이익증가 => 회사가 아주좋아함...
		//4. 개발 시간이 단축 => 영업이익증가 => 회사가 아주좋아함...
		//5. 오류가 줄어든다.
	}
}
