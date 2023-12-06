package class05;

import java.util.Scanner;

class Person {

	String name;
	int age;

	void hello() {
		System.out.println(name + "은" + age + "살 입니다.");
	}
// 문제의도는 입력 자체의 기능을를 메서드에 넣어두는것. Scanner를 안에선언
// 항상 return break; 같이쓰자 ㅜ
	int inputAge(Scanner sc) {
		int age;
		System.out.println("나이를 직접 입력하세요");
		while (true) {
			age = sc.nextInt();
			if (age < 1 || age > 100) {
				
				System.out.println("범위를 벗어났습니다 재입력하세요");
			} else {
				break;
			}
		}
		return age;
	}

	Person() {
		name = "입력없음";
		age = -1;
	}

	Person(String n) {
		name = n;
		age = 20;
	}

	Person(String n, int s) {
		name = n;
		age = s;
	}

	void printInfo() {
		System.out.println("이름: " + name + ", 나이: " + age);
	}

}
// 로그찍기 ★★★★★★★★★★★★★
// 항상 프린트문을 통해서 원인파악을 생각해보자.

public class Test01 {
	public static String inputName(Scanner sc) {
		String name;
		System.out.println("이름을 직접 입력하세요");
		while (true) {
			name = sc.next();
			System.out.println("정말 이 이름으로 하시겠습니까?");
			String ans = sc.next();
			if (ans.equals("네")) {
				break;
			}
			System.out.println("이름을 다시 입력하세요");
			continue;
			
		}
		return name;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person p1 = new Person(inputName(sc));
		Person p2 = new Person("개구리");
		

		// 1) 사람객체를 미리 생성한 다음 저장
		// 2) 저장할때에 사람객체를 생성 <-
		
		Person[] pArr = new Person[5];
		for (int i = 0; i < pArr.length; i++) {
			System.out.println((i + 1) + "번째의 이름과 나이를 입력하세요");
			pArr[i] = new Person();
			pArr[i].name = inputName(sc);
			pArr[i].inputAge(sc);
		}

		for (Person p : pArr) {
			System.out.println("이름: " + p.name + ", 나이: " + p.age);
		}
	}
}
