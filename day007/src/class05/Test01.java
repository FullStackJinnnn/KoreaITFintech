package class05;

import java.util.Scanner;

class Person {
	
	String name;
	int age;
	
	void hello() {
		System.out.println(name+"은"+age+"살 입니다.");
	}
	
	int inputAge(Scanner sc) {
		System.out.println("나이를 직접 입력하세요");
		while (true) {
		age = sc.nextInt();
			if(age<1 || age>100) {
			System.out.println("범위를 벗어났습니다 재입력하세요");
			}
			else {
				return age;
			}
		}
	}
	
	String inputName(Scanner sc) {
		System.out.println("이름을 직접 입력하세요");
		while(true) {
			name = sc.next();
			System.out.println("정말 이 이름으로 하시겠습니까?");
			String ans = sc.next();
				if (ans.equals("네")) {
					return name;
				}
				System.out.println("이름을 다시 입력하세요");   
				continue;
			}
		}
	
	Person(String n) {
		name =n;
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

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person p1 = new Person("너구리");
		Person p2 = new Person("개구리");
			
		Person[] pArr = new Person[5];
		for (int i=0; i<pArr.length; i++ ) {
			System.out.println((i+1)+"번째의 이름과 나이를 입력하세요");
			pArr[i] = new Person("defualt");
			pArr[i].inputAge(sc);
			pArr[i].inputName(sc);
		}

		for (Person p : pArr) {
			p.printInfo();
		}
	}
}




