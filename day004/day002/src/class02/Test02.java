package class02;

public class Test02 {
	public static void main(String[] args) {
		
		int i=1;
		//무한루프, 무한반복문
		// = 반복문은 조건식을 어떻게, 작성하느냐에 따라, "무한"실행할수도있어 유의!!!!!!!!!!!
		while(i<5) { 
			i++;
			i*=-1;
			
			System.out.println("i= "+i);
		}
		System.out.println("최종 i= "+i);
		// * 무한은 항상 ........조심.....
		// 디버깅표의 중요성 ★★★★★★★★★★★★★★★★★★★★★★
	}
}
