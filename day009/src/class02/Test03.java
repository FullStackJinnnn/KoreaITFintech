package class02;

import java.util.Random;
import java.util.Scanner;
// 끝값 비교하는것 -> 경계값 검사
class Person {
	String name;
	int age;
	static int cnt = 0;

	Person(String name, int age) {
		this.name = name;
		this.age = age;

	}

	void printInfo() {
		System.out.println(this.name + "님 " + this.age + "살");
	}

	int test() {
		return 0;
	}
}

class Student extends Person {
	int score;

	Student(String name, int age) {
		this(name, age, -1);
	}

	Student(String name, int age, int score) {
		super(name, age);
		this.score = score;

	}

	@Override
	void printInfo() {
		System.out.println(this.name + "학생 " + this.age + "살 " + this.score + "점");
	}

	@Override
	int test() {
		Random rand = new Random();
		if (this.score <= 80) {
			this.score = rand.nextInt(51) + 50;

		}
		return score;
	}

}

class Employee extends Person {
	String dep;

	Employee(String name, int age) {
		this(name, age, "부서입력안함");
	}

	Employee(String name, int age, String dep) {
		super(name, age);
		this.dep = dep;

	}

	@Override
	void printInfo() {
		System.out.println(this.dep + "팀 " + this.name + "님 " + this.age + "살");
	}

}

public class Test03 {
	public static void main(String[] args) {

//		
//		//class 3개
//		사람 학생 직원 무직
//		학생 -> 기능 test  80~100 이면 점수 재설정
//		직원
//		
//		C
//		R
//		U
//		D
//		사람 최대 5명 저장 할 수 있는 공간 1번누르면 사람추가 -> 학생추가야 직원추가야 ?
//				2사람 목록 출력
//				학생 목록 출력후 전체 재시험
//		프로그램 종료

		Person[] pArr = new Person[5];

		while (true) {

			System.out.println("========사람은 5명 저장할수 있습니다.=========");
			System.out.println("1. 사람추가  2. 사람 목록 출력   3. 학생 목록 출력 후 전체 재시험 ");
			Scanner sc = new Scanner(System.in);
			int ans = sc.nextInt();
			if (ans == 1) {
				if (Person.cnt > pArr.length - 1) {
					System.out.println("사람 꽉찼어유");
					continue;
				}
				System.out.println("1. 학생추가 2. 직원추가 ");
				ans = sc.nextInt();
				if (ans == 1) {

					System.out.println("학생의 이름 나이 점수를 입력하세요. ");
					System.out.println("이름 :");
					String name = sc.next();
					System.out.println("나이 :");
					int age = sc.nextInt();
					System.out.println("점수 :");
					int score = sc.nextInt();

					pArr[Person.cnt++] = new Student(name, age, score);
					System.out.println("학생 추가완료!");

				} else {
					System.out.println("직원의 이름 나이 부서를 입력하세요. ");
					System.out.println("이름 :");
					String name = sc.next();
					System.out.println("나이 :");
					int age = sc.nextInt();
					System.out.println("부서 :");
					String dep = sc.next();

					pArr[Person.cnt++] = new Employee(name, age, dep);
					System.out.println("직원 추가완료!");
				}
			} else if (ans == 2) {
				System.out.println("★★현재 사람 목록★★");
				for (int i = 0; i < Person.cnt; i++) {
					pArr[i].printInfo();
				}
				System.out.println();
			} else if (ans == 3) {
				System.out.println("현재 학생 목록");

				for (int i = 0; i < Person.cnt; i++) {
					if (pArr[i] instanceof Student) {
						((Student) pArr[i]).printInfo();
					}
				}
				System.out.println();
				System.out.println("재시험 시작!");
				for (int i = 0; i < Person.cnt; i++) {
					if (pArr[i] instanceof Student) {
						((Student) pArr[i]).test();
					}
				}
				System.out.println("재시험 후 학생 점수");
				for (int i = 0; i < Person.cnt; i++) {
					if (pArr[i] instanceof Student) {
						pArr[i].printInfo();
					}
				}
			}
		}

	}
}
