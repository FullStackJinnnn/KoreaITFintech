package class01;

import java.util.ArrayList;

// [컬렉션 프레임워크]

// 프레임워크
//	ex)컬렉션,Spring, Mybatis,JPA,... 개발자에게봄이찾아와따...
//	뼈대, 틀, 구조, ...abstract
//	개발자들에게 뼈대를 제공해주겠다. 라는 컨셉
// 개발 편의성을 제공
// "하라는대로! 쓰라는대로! 
// 1) 개발자들의 실력이 상향 평준화
// 2) 유지보수 용이 ★ 최고목표 ★

//컬렉션 프레임워크
	// 배열같은 자료형(자료구조)들을 제공하는 라이브러리
	// JAVA에서 기본 제공해줌
	// [배열리스트], 링크리스트, 집합, [맵], 트리, ..........

//배열리스트
	//향상된 배열
	//서로 관련된 데이터들을 저장할수있는 자료향
	//같은 자료형 X == > 서로다른 자료형들을 같은 공간(메모리)에 저장하는게 맞나 ? 
	// 별로 효율이 좋을 것 같지 않다.
	// ==> 같은 자료형 저장을 "강제" !!!!!!
	// ==> "제네릭" 
	// 결론) 배열리스트는 반드시 제네릭과 함께 사용해야한다!!!!
	// 자료형 섞이면 뭐가 좋겠숴...
	//개수 X
	//저장할 개수 X

public class Test01 {
	public static void main(String[] args) {
		
		ArrayList<Integer> datas = new ArrayList<Integer>(); // 강제중
		datas.add(190);
		System.out.println(datas);
		datas.add(0, 11);
		datas.add(1, 13);
		datas.add(0, 5);
		boolean ans = datas.contains(13);
		boolean ans2 = datas.contains(50);
		System.out.println(ans);
		System.out.println(ans2);
		System.out.println(datas.get(0));
		System.out.println(datas.isEmpty());
		datas.remove(0);
		System.out.println(datas);
		System.out.println(datas.size());
		datas.clear();
		
		System.out.println(datas); //헉 주소값을 알려주지않고 공백을 보여준다!!
		
	}
}
