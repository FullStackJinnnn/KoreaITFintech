package class03;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		
	//우리가 원하는대로 값 저장하기
    //1. 랜덤값 저장
    //2. 외부에서 값을 입력받는 방법
		
		int[] datas=new int[5];
		Random rand = new Random();// -> Random은 클래스!!!!!도있구나 ..?
		for(int i=0; i<datas.length; i++) {
			datas[i] = rand.nextInt(1000); //Math.rand() 는 0<x<1 사이 랜덤값!
			// rnad.nextInt(1000) 
			// 0~999
		}
		
		System.out.print("[ ");
		for(int data : datas) {
			System.out.print(data + " ");
		}
		System.out.println("]");
		
//		int, double, String 등으느 원시타입이라 바로 갑 저장가능
//		
//		int[](배열),Random(클래스, 객체),.args.clone(). 등은 힙 메모리영역에서 생성하여 사용할수있음 
//		즉 new 연산자를 사용해야만한다!!!

//		=========================================
		
		//Random, Scanner ...등
		// 만들어진 클래스(객체)들이 엄청많음
//		클래스들이 너무 많기때문에
//		서랍에 저장을 예쁘게 정리해놧습니다 ^^
//		패키지(라이브러리)
		
		
		
	}
}
