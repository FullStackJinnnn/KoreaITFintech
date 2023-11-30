package class02;

import java.util.Random;
import java.util.Scanner;

class Pokemon {
	int lv;
	int exp;
	String name;

	Pokemon(String name) {
		this(name, 5);
	}

	Pokemon(String name, int lv) {
		this.name = name;
		this.lv = lv;
	}

	void expPlus(int ranExp) {
		this.exp += ranExp;
	}

	void lvup(int lvcnt) {
		this.lv += lvcnt;
	}

	void printInfo() {
		System.out.println(name + " Lv." + lv + "[" + exp + "/100]입니다.");
	}

	void gameStart() {

		Random rand = new Random();

		while (true) {
			int ranExp;
			int lvcnt;
			lvcnt = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println(this.name + " 레벨업 게입 시작 1 or 0");
			int ans = sc.nextInt();
			if (ans == 1) {
				boolean ranDom = rand.nextBoolean();
				if (ranDom == false) {
					System.out.println("꽝! 아무것도 없습니다....");
				} else {
					ranExp = rand.nextInt(450) + 50;

					expPlus(ranExp);
					System.out.println("축하합니다!!!\n얻은 경험치 = " + ranExp);

					if (this.exp > 100) {
						while (this.exp > 100) {
							this.exp -= 100;
							lvcnt++;
							lvup(lvcnt);
							if (this.lv > 30) {
								this.lv = 30;
								this.exp = 0;
								break;
							}
						}
						System.out.println("우왕 " + this.name + "레벨 " + lvcnt + "UP!!!!!!!!");
						printInfo();
					} else {
						System.out.println("아쉽게 레벨업은 못했네요");
						printInfo();
					}

					System.out.println("");
					System.out.println("");

					if (this.lv >= 30) {
						System.out.println("축하합니다!" + this.name + "★☆★☆☆★만렙★☆★☆★☆");
						System.out.println("진화시키겠습니까 ?! 숫자를 입력하세요 1.네 / 0.아니오");
						ans = sc.nextInt();
						if (ans == 1) {

							System.out.println("얼라리..?" + this.name + "의 변화가...!");
							System.out.print("축하합니다!" + this.name + "는( 은 ) ");
							if (this.name.equals("피카츄")) {
								this.name = "라이츄";
								System.out.println(this.name + "( 으 )로 진화했다!");
							} else if (this.name.equals("파이리")) {
								this.name = "리자드";
								this.lv = 1;
								this.exp = 0;
								System.out.println(this.name + "( 으 )로 진화했다!");
							} else if (this.name.equals("꼬부기")) {
								this.name = "어니부기";
								this.lv = 1;
								this.exp = 0;
								System.out.println(this.name + "( 으 )로 진화했다!");
							} else if (this.name.equals("리자드")) {
								this.name = "리자몽";
								this.lv = 30;
								this.exp = 0;
								System.out.println(this.name + "( 으 )로 진화했다!");
							} else {
								this.name = "꼬북왕";
								this.lv = 30;
								this.exp = 0;
								System.out.println(this.name + "( 으 )로 진화했다!");
							}

							if (this.lv == 1) {
								continue;
							}
						}
						break;
					}

				}
			} else {
				System.out.println("=====게임종료=====");
				break;
			}
		}
	}
}

public class Test03 {
	public static void main(String[] args) {
		Pokemon[] pocs = new Pokemon[3];
		pocs[0] = new Pokemon("피카츄");
		pocs[1] = new Pokemon("파이리");
		pocs[2] = new Pokemon("꼬부기");
		System.out.println("============현재 가진 포켓몬=============");
//		for (int i = 0; i < pocs.length; i++) {
		for (Pokemon datas : pocs) {
			//pocs[i].printInfo();
			datas.printInfo();
		}
		System.out.println("====================================");
		System.out.println("어떤 포켓몬을 레벨업 시킬까요 ?! 숫자로 선택하세요");
		System.out.println("1. 피카츄 2. 파이리 3. 꼬부기");
		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
		switch (answer) {
		case 1:
			pocs[answer - 1].gameStart();
			break;
		case 2:
			pocs[answer - 1].gameStart();
			break;
		case 3:
			pocs[answer - 1].gameStart();
			break;
		}

	}
}
