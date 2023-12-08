// 1차 수정(ver 1.1) > 김진영
// - 차량 구매 부분 모듈화
// - 슈퍼카 roof 개폐기능 추가
// - 선택차량 시동 on/off기능 추가
// 2차 수정(ver1.2) > 정석진
// - 일반차량과 슈퍼카의 시동상태가 동일하게 변하는 내용 수정
// - 전기차량의 메소드 내부 엔진상태변화를 통제하는 변수의 미사용
// 3차 수정(ver 1.3) > 하정희
// - 연료충전 부분이 충전완료이후 초기메뉴로 넘어가지지 않는 현상 수정
// 4차 수정(ver 1.4)
// - 차량정보입력함수 파라미터 3개에서 1개로 수정(코드 경량화)
// 5차 수정(ver 1.5) > 김진영
// - 연료/베터리 충전시 차 선택 기능 추가
package class01;

import java.util.Scanner;

class Car {
	// 멤버변수
	String color;
	String brand;
	String model;
	int price;
	int fuel;
	boolean engine;

	// 생성자
	Car(String color, String brand, String model, String price) {
		this.color = color;
		this.brand = brand;
		this.model = model;
		this.price = Integer.parseInt(price) / 10000000;
		this.fuel = 30;
	}

	// 메서드
	void on() {
		this.engine = true;
		System.out.println("시동이 켜졌습니다");
	}

	void off() {
		this.engine = false;
		System.out.println("시동이 꺼졌습니다");
	}

	void fill() {
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 연료 잔량" + this.fuel + "입니다.");
		System.out.println("충전가능 범위 " + "0 ~ " + (100 - this.fuel));
		System.out.println("연료를 얼마나 충전하시겠습니까?");
		while (true) {
			int answer = sc.nextInt();
			if (0 <= answer && answer <= 100 - this.fuel) {
				this.fuel += answer;
				System.out.println("충전이 완료 되었습니다. 현재 연료 잔량 " + this.fuel + " 입니다.");
				break;
			} else {
				System.out.println("충전가능한 범위를 초과하였습니다 다시입력하세요");
			}
		}
	}

	void printInfo(int i) {
		System.out.println(i + 1 + "번 차량 >> 브랜드: " + this.brand + " 모델: " + this.model + " 색깔: " + this.color + " 가격: "
				+ this.price + "천만원" + " 연료: " + this.fuel + "/100");
	}
}

class ElecCar extends Car {
	int battery;

	ElecCar(String color, String brand, String model, String price) {
		super(color, brand, model, price);
		this.battery = 30;
	}

	@Override
	void on() {
		engine = true;
		System.out.println("버튼으로 시동이 켜졌습니다");
	}

	@Override
	void off() {
		engine = false;
		System.out.println("버튼으로 시동이 꺼졌습니다");
	}

	@Override
	void fill() {
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 배터리 잔량" + this.battery + "% 입니다.");
		System.out.println("충전가능 범위 " + "0% ~ " + (100 - this.battery) + "%");
		System.out.println("배터리를 얼마나 충전하시겠습니까?");
		while (true) {
			int answer = sc.nextInt();
			if (0 <= answer && answer <= 100 - this.battery) {
				this.battery += answer;
				System.out.println("충전이 완료 되었습니다. 현재 배터리 잔량 " + this.battery + "% 입니다.");
				break;
			} else {
				System.out.println("충전가능한 범위를 초과하였습니다 다시입력하세요");
			}
		}
	}

	@Override
	void printInfo(int i) {
		System.out.println(i + 1 + "번 차량 >> 브랜드: " + this.brand + " 모델: " + this.model + " 색깔: " + this.color + " 가격: "
				+ this.price + "천만원 " + "연료: " + this.battery + "%");
	}

}

class SuperCar extends Car {
	boolean roof;

	SuperCar(String color, String brand, String model, String price) {
		super(color, brand, model, price);
		roof = false;
	}

	@Override
	void on() {
		engine = true;
		System.out.println("지문으로 시동이 켜졌습니다");
	}

	@Override
	void off() {
		engine = false;
		System.out.println("지문으로 시동이 꺼졌습니다");
	}

	@Override
	void printInfo(int i) {
		System.out.print(i + 1 + "번 차량 >> 브랜드: " + this.brand + " 모델: " + this.model + " 색깔: " + this.color + " 가격: "
				+ this.price + "천만원" + "연료: " + this.fuel + "/100");
		if (!roof) {
			System.out.println(" 현재 루프가 닫혀있습니다");
		} else {
			System.out.println(" 현재 루프가 열려있습니다");
		}
	}

	void roofOpen(int i) {
		roof = true;
		System.out.println(i + 1 + "번차량 루프가 열렸습니다");
	}

	void roofClose(int i) {
		roof = false;
		System.out.println(i + 1 + "번차량 루프가 닫혔습니다");
	}

}

public class asdf {
	public static void msg(int i) {
		String[] msg1 = { "브랜드 입력 >> ", "모델 입력 >> ", "색상 입력 >> ", "가격 입력 >> " };
		System.out.println(msg1[i]);
	}

	// 차량 정보 입력 로직
	public static String[] input(Scanner sc) {
		String[] ans = new String[4];
		for (int i = 0; i < ans.length; i++) {
			msg(i); // 메서드 호출
			ans[i] = sc.next();
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Car[] car = new Car[3];
		int option, index = 0;
		while (true) {
			System.out.println("======================");
			System.out.println("==== 차량구매 프로그램 ====");
			System.out.println("======================");
			System.out.println("1. 차량 구매");
			System.out.println("======================");
			System.out.println("2. 차량목록 전체 출력");
			System.out.println("======================");
			System.out.println("3. 가장 비싼 차량정보 출력");
			System.out.println("======================");
			System.out.println("4. 연료 충전");
			System.out.println("======================");
			System.out.println("5. 루프 동작");
			System.out.println("======================");
			System.out.println("6. 시동 켜기/끄기");
			System.out.println("======================");
			System.out.println("7. 차량 매각");
			System.out.println("======================");
			System.out.println("0. 프로그램 종료");
			System.out.println("======================");
			System.out.println("입력 >> ");
			int action = sc.nextInt();
			if (action == 0) {
				System.out.println("프로그램을 종료합니다 . . .");
				break;
			} else if (action == 1) {
				if (index >= 3) {
					System.out.println("더이상 구매하실 수 없습니다");
					continue;
				}
				System.out.println("=====   차량구매   =====");
				System.out.println("1. 일반차");
				System.out.println("2. 전기차");
				System.out.println("3. 슈퍼카");
				System.out.println("입력 >> ");
				option = sc.nextInt();
				String[] ans = input(sc);
				if (option == 1) {
					car[index++] = new Car(ans[2], ans[0], ans[1], ans[3]);
				} else if (option == 2) {
					car[index++] = new ElecCar(ans[2], ans[0], ans[1], ans[3]);
				} else if (option == 3) {
					car[index++] = new SuperCar(ans[2], ans[0], ans[1], ans[3]);
				} else {
					System.out.println("잘못 입력하셨습니다");
					continue;
				}
			} else if (action == 2) {
				if (index <= 0) {
					System.out.println("구매하신 차량이 없습니다");
					continue;
				}
				System.out.println("전체목록출력");
				for (int i = 0; i < index; i++) {
					car[i].printInfo(i);
				}
			} else if (action == 3) {
				if  (index <= 0) {
					System.out.println("구매하신 차량이 없습니다");
					continue;
				}
				int maxInd = 0;
				System.out.println("가장 비싼차를 출력합니다");
				for (int i = 1; i < index; i++) {
					if (car[i].price > car[maxInd].price) {
						maxInd = i;
					}
				}
				System.out.println("제일 비싼차는 " + car[maxInd].model + "입니다");
				System.out.println("가격은 " + car[maxInd].price + "천만원 입니다");
			} else if (action == 4) {
				if (index <= 0) {
					System.out.println("구매하신 차량이 없습니다");
					continue;
				}
				System.out.println("1. 전기차 충전");
				System.out.println("2. 일반차 충전 또는 슈퍼카충전");
				System.out.print("번호 입력>> ");
				option = sc.nextInt();
				if (option == 1) {
					for (int i = 0; i < index; i++) {
						if ((car[i] instanceof ElecCar)) {
							car[i].printInfo(i);
						}
					}
					System.out.print("차 번호 입력 >> ");
					option = sc.nextInt();
					if (1 <= option && option <= index) {
						if ((car[option - 1] instanceof ElecCar)) {
							car[option - 1].fill();
							continue;
						} else {
							System.out.println("입력하신 번호는 전기차가 아닙입니다");
							continue;
						}
					} else {
						System.out.println("없는 번호입니다");
					}
				} else if (option == 2) {
					for (int i = 0; i < index; i++) {
						if (!(car[i] instanceof ElecCar)) {
							car[i].printInfo(i);
						}
					}
					System.out.print("차 번호 입력 >> ");
					option = sc.nextInt();
					if (1 <= option && option <= index) {
						if (!(car[option - 1] instanceof ElecCar)) {
							car[option - 1].fill();
							continue;
						} else {
							System.out.println("입력하신 번호는 전기차입니다");
							continue;
						}
					} else {
						System.out.println("없는 번호입니다");
					}
				}
				continue; // 연료충전 후 초기메뉴로 이동 ＃수정됨
			} else if (action == 5) {
				if (index <= 0) {
					System.out.println("구매하신 차량이 없습니다");
					continue;
				}
				for (int i = 0; i < index; i++) {

					if (car[i] instanceof SuperCar) {
						if (!((SuperCar) car[i]).roof) {
							((SuperCar) car[i]).roofOpen(i); // 슈퍼카 라면 열리게하는 기능
						} else {
							((SuperCar) car[i]).roofClose(i); // 닫히는 기능도 구현
						}
					}
				}
			} else if (action == 6) {
				if (index <= 0) {
					System.out.println("구매하신 차량이"
							+ " 없습니다");
					continue;
				}
				System.out.print("차 번호 입력 >> ");
				option = sc.nextInt();
				if (1 <= option && option <= index) {
					if (!car[option - 1].engine) {
						car[option - 1].on();
					} else {
						car[option - 1].off();
					}
				}
			} else if (action == 7) {
				if (index <= 0) {
					System.out.println("구매하신 차량이 없습니다");
					continue;
				}
				System.out.println("가장 최근에 구입한차량 매각합니다");
				index--;
			}
		}
	}
}