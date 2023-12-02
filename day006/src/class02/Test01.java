package class02;

import java.util.Random;
import java.util.Scanner;

public class Test01 {

	public static void programmenu() {
		System.out.println();
		System.out.println(" === 학생부 프로그램 ===");
		System.out.println("1. 추가"); //
		System.out.println("2. 목록출력"); //
		System.out.println("3. 1등출력");
		System.out.println("4. 검색"); //
		System.out.println("5. 변경"); //
		System.out.println("6. 삭제"); //
		System.out.println("7. 50점이상 학생출력"); //
		System.out.println("0. 종료");
		System.out.print("입력 >> ");
	}

	public static int exit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("종료 하시겠 습니까?  y / n");
		String exit = sc.next();
		if (exit.equals("y")) {
			System.out.println();
			System.out.println("프로그램을 종료합니다...");
			return 0;
		}
		return -1;
	}

	public static int addstu(int[] stuArr, int index) { // 샘플 데이터 추가
		Scanner sc = new Scanner(System.in);
		// 학생 추가 유효성검사
		if (index > 2) {
			System.err.println("이미 3명의 학생 정보가 꽉찾습니다. 학생을 삭제하고 입력하세요.");
			return -1;
		}
		while (true) {
			System.out.println("추가하실 " + (index + 1) + "번 학생 점수를 입력해주세요");
			int score = sc.nextInt();
			if (score < 0 || score > 100) {
				System.out.println("학생 점수가 0~100 범위를 벗어났습니다. 다시 입력하세요");
			} else {
				stuArr[index++] = score;
				System.out.println((index) + "번 학생 점수가 추가되었습니다.");
				return index;
			}
		}
	}

	public static void printstuarr(int[] stuArr, int index) {
		System.out.println();
		System.out.println(" === 목록출력 ===");
		if (index == 0) {
			System.err.println("입력된 학생 정보가 없습니다. \n학생 정보를 입력하고 다시 찾아주세요");
		}
		for (int i = 0; i < index; i++) {
			System.out.println((i + 1) + "번학생 : " + stuArr[i] + "점");
		}
		System.out.println();
	}
	//1등출력
	public static void printrank1(int[] stuArr, int index) {
		int max = stuArr[0];
		int maxIndex = 0;
		for (int i=1; i<index; i++) {
			if (max <stuArr[i]) {
				max = stuArr[i];
				maxIndex = i;
			}
		}
		System.out.println("1등학생은 "+(maxIndex+1)+"번 학생이며 "+"점수는 "+stuArr[maxIndex]+"입니다.");
	}
		

	public static void stusearch(int[] stuArr, int index, Scanner sc) {
		if (index == 0) {
			System.err.println("입력된 학생 정보가 없습니다. \n학생 정보를 입력하고 다시 찾아주세요");

		} else {
			while (true) {
				System.out.println("검색할 학생 번호를 입력하세요.");
				int stunum = sc.nextInt();

				if (0 < stunum && stunum <= index) {
					System.out.println("학생 번호 : " + (stunum) + "번\n" + "학생 점수 : " + stuArr[stunum - 1] + " 점");
					break;
				} else {
					System.out.println("입력하신 학생 번호는 입력되지 않았습니다. 다시 입력하세요");
					System.out.println("현재까지 입력된 번호: " + "1~" + (index));
				}
			}
		}
	}

	public static int[] scorechange(int[] stuArr, int index) {
		Scanner sc = new Scanner(System.in);
		if (index == 0) {
			System.err.println("입력된 학생 정보가 없습니다. \n학생 정보를 입력하고 다시 찾아주세요");
			return new int[0];
		} else {
			while (true) {
				System.out.println("점수를 변경할 학생 번호를 입력하세요.");
				int stunum = sc.nextInt();
				if (stunum > index || stunum <= 0) {
					System.out.println("입력하신 학생 번호는 입력되지 않았습니다. 다시 입력하세요");
					System.out.println("현재까지 입력된 번호: " + "1~" + (index));
				}
				for (int i = 0; i < index; i++) {
					if (stunum == (i + 1)) {
						System.out.println(stunum + "번 학생을 선택하셨습니다.");
						System.out.println("현재" + stunum + "번 학생 점수 :" + stuArr[stunum - 1] + "점");
						while (true) {
							System.out.println("변경할 점수를 입력하세요.");
							int newscore = sc.nextInt();
							if (newscore != stuArr[stunum - 1] && newscore >= 0 && newscore <= 100) {
								stuArr[stunum - 1] = newscore;
								System.out.println(stunum + "번 학생 점수가 " + stuArr[stunum - 1] + "점 으로 변경되었습니다.");
								return stuArr;
							} else if (newscore == stuArr[stunum - 1]) {
								System.out.println("기존값과 동일한 점수를 입력하셨습니다.");
								System.out.println("점수를 그대로 유지할-1까요? 맞으면  y 아니면 n 입력");
								String ans = sc.next();
								if (ans.equals("y")) {
									System.out.println("y를 선택했습니다. 기존 점수 유지");
									return stuArr;
								} else if (ans.equals("n")) {
									System.out.println("n을 입력했습니다. 점수를 다시 입력하세요");
								} else {
									System.out.println("잘못입력");
								}
							} else {
								System.err.println("점수가 이상합니다...? 재입력");
							}
						}
					}
				}
			}

		}
	}

	public static int deletestu(int[] stuArr, int index) {
		if (index == 0) {
			System.err.println("삭제할 학생 정보가 없습니다.");
			return -1;
		} else {
			System.out.println((index--) + "번 학생이 삭제되었습니다.");
			return index;
		}
	}
	public static void stuabove50(int[] stuArr, int index) {
		if (index == 0) {
			System.err.println("입력된 학생 정보가 없습니다. \n학생 정보를 입력하고 다시 찾아주세요");
		}
		for (int i=0; i<index; i++) {
			if (stuArr[i] >50) {
				System.out.println("50점이상 :" + (i+1)+" 번 학생");
			}
		}
	}
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] stuArr = new int[3];
		int index = 0; // 현재 저장된 학생 데이터 개수

		while (true) {
			// 학생부 프로그램 출력~
			programmenu();

			int action = sc.nextInt();

			if (action == 0) { // 종료
				int out = exit();
				if (out==0) {
					break;
				}
			} 
			else if (action == 1) {
				index = addstu(stuArr, index);
			}
			else if (action == 2) { // 목록출력
				printstuarr(stuArr, index);
			}
			else if (action == 3) { // 1등출력
				printrank1(stuArr, index);
			}
			else if (action == 4) {
				stusearch(stuArr, index, sc);
			} 
			else if (action == 5) {
				stuArr = scorechange(stuArr, index);
			}
			// 배열내부는 삭제되지 않고 인덱스를 없애는 방향으로 학생이 삭제되는 것 처럼 보이게 한다. 따라서 마지막 학생만 삭제가능
			else if (action == 6) {
				index = deletestu(stuArr, index);
			}
			else if (action == 7) {
				stuabove50(stuArr, index);
			} else {
				System.out.println("번호잘못입력");
			}
		}
		
	}
	

}
