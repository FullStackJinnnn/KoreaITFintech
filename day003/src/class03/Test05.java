package class03;

import java.util.Random;

public class Test05 {

	public static void main(String[] args) {
		
		// 일반검색
		// 1~10중에 5개의 정수를 저장
		
		Random rand = new Random();
		int[] datas=new int[5];
		for (int i=0; i<datas.length; i++) {
			datas[i]=rand.nextInt(10) +1;
		}
		for(int data: datas) {
			System.out.print(data + " ");
		}
		System.out.println();
		
		
		int key=2; //우리가 찾을 함수
		
		int keyIndex=-1; // 우리가 찾을 함수가 존재하는 위치.index
		//초기화는 무조건 0으로 해주는것이 아니다. 지금같은 상황은 초기화가 없는게 맞다.
		// 검색시 초기화값은 "대상의 범위가 아닌값"으로 해야합니다!!!!!
		for (int i=0; i<datas.length; i++) {
			if(key == datas[i]) {
				keyIndex=i;
				System.out.println("찾았다!");
				break; // 찾았으면 즉시 종료
			}
		}
		
		//찾는값이 없을 수 있기 때문에 if문으로 조건을 설정해줘야한다.
		if(keyIndex>=0) {
		System.out.println("찾는 값"+key+ "["+keyIndex+"]에 있습니다.");
		} else {
			System.out.println(key+"는 없습니다........");
		}
		
		
	}
	
}
