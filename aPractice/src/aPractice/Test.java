package aPractice;

import java.util.ArrayList;

//class Test1 {
//	String name;
//}

public class Test {
	public static void main(String[] args) {

		Animal a1 = new Animal();
		Animal a2 = new Animal();
		Animal a3 = new Animal();
	
		a1.setName("루루");
		a1.setType("고양이");
		System.out.println(a1.name + a1.getType());
		
		a2.setName("밀키");
		a2.setType("강아지");
		a1.print();
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		System.out.println(animalList);
		animalList.add(a1);
		System.out.println();
		System.out.println(animalList);
		animalList.add(a2);
		System.out.println();
		System.out.println(animalList);
		System.out.println();
		System.out.println(animalList.get(0));
		System.out.println(animalList.get(1));
		
		for (Animal data : animalList) {
			System.out.println(data);
		}
		
		
		
		
		//어레이리스트 메서드 검색하면 java.util.ArrayList에 내장되어있는 메서드 나온다. 
		//전부 호출가능.
		
		
	}
}
//		Animal a2 = new Animal();
//		Animal a3 = new Animal();
//		Animal a4 = new Animal();
//		Animal a5 = new Animal();
//		Animal a6 = new Animal();
//		Animal a7 = new Animal();
		
		
		
//		a1도 name, species, type
//		a2도 name, species, type
//		a3도 name, species, type
//		
		//System.out.println(a);
//		System.out.println(a1);
//		System.out.println(a1.myToString());
		
		
		//a1.name = "루루";
		
		
//		System.out.println(a1);
//		
//		a2.setName("초코");
//		System.out.println(a2);
//		
//		a3.setType("고양이");
//		
//		a1.setNumber(15);
//		
//		int add = 0;
//		
//		add = a1.getNumber() + 20;
//		System.out.println(add);
		
		
		
		
		
	


//
//class Member {
//	int pk;
//	String name ;
//	int age;
//	
//	public void printMemberName() {
//		System.out.println("이 동물의 이름은 " + this.name + "입니다~");
//	}
//	
//	
//}
//	for (int i=0; i<5; i++) {
//		i = i+1;
//	}

//	@Override 
//	public String toString() {
//		return "Member [pk=" + pk + ", name=" + name + ", age=" + age + "]";
//	}
//	public static void main(String[] args) {
//		System.out.println("?");
//		int a =5; 
//	}


//Client + CTRL 

