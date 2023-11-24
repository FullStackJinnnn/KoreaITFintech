package class02;

public class Test02 {
	public static void main(String[] args) {
		
	
	
//	물건이 4개있습니다.
//	각각의 물건은
//	500
//	700
//	1200
//	950원 입니다.
//	
//	물건의 가격을 저장하고
//	1번 물건은 500원 입니다.
//	이렇게 출력해주세요.
//	1~4 총 합 가격으느 xxxx원 입니다.
		
		// 배열을 사용할수있는 3가지 조건
		// 1. 관련된 데이터
		// 2. 같은 타입의 데이터들인가 ? : 자바는 같아야함 / 파이썬은 달라도도힘
		// 3. 데이터의 개수를 정확히 알고있어야한다. 
		int[] martArr = new int[4];
		int total = 0;
		martArr[0] = 500;
		martArr[1] = 700;
		martArr[2] = 1200;
		martArr[3] = 950;
		for (int i=0; i<martArr.length; i++) {
		total += martArr[i];
		System.out.println((i+1)+"번 물건의 가격은 "+ martArr[i]+"원 입니다." );
		}
		System.out.println();
		System.out.println("1~4번 상품의 총 합 가격은 " + total + "원 입니다.");
		
		// 특정배열의 value만 궁금할때
		// forEach문 (향상된 for문)
//		for(자료형 임의의 변수 : 배열명) {
//		
//		}
		System.out.println();
		total = 0;
		for(int price :martArr) {
			total+=price;
			System.out.println("현재 price:" + price);
		}
		
		System.out.println("1~4번 상품의 총 합 가격은 " + total + "원 입니다.");
		
	}
}
