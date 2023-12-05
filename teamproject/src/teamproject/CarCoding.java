package teamproject;

import java.text.DecimalFormat;
import java.util.Scanner;

class Car {
	// 멤버변수
	String color;
	String brand;
	String model;
	int price;
	int fuel;
	boolean engine = false;

	// 생성자
	Car(String color, String brand, String model, String price) {
		this.color = color;
		this.brand = brand;
		this.model = model;
		this.price = Integer.parseInt(price) / 10000000;
		this.fuel = 30;
	}

	// 메서드
//	void on() {
//		engine = true;
//		System.out.println("일반차 시동이 켜졌습니다");
//	}
//
//	void off() {
//		engine = false;
//		System.out.println("일반차 시동이 꺼졌습니다");
//	}
	void engineTrigger() {
		if (!engine) {
			System.out.println("일반차 시동 ON.");
			engine = true;
		} else {
			System.out.println("일반차는 시동 OFF.");
			engine = false;
		}
	}


	void fill() {
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 연료 잔량" + this.fuel + "입니다.");
		System.out.println("충전가능 범위 " + "0 ~ " + (100 - this.fuel));
		System.out.println("연료를 얼마나 충전하시겠습니까?");
//		int answer = sc.nextInt();
//		this.fuel += answer;
//		System.out.println("충전이 완료 되었습니다. 현재 연료 잔량 " + this.fuel + "입니다.");
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

	void printInfo() {
		System.out.println("브랜드: " + this.brand + " 모델: " + this.model + " 색깔: " + this.color + " 가격: " + this.price
				+ "천만원" + " 연료: " + this.fuel + "/100");
		if (!engine) {
			System.out.println("일반차 시동이 꺼져있습니다.");
		} else {
			System.out.println("일반차 시동이 켜져있습니다.");
		}
	}
}

class ElecCar extends Car {
	int battery;

	ElecCar(String color, String brand, String model, String price) {
		super(color, brand, model, price);
		this.battery = 30;
	}

//	@Override
//	void on() {
//		System.out.println("버튼으로 시동이 켜졌습니다");
//	}
//
//	@Override
//	void off() {
//		System.out.println("버튼으로 시동이 꺼졌습니다");
//	}
	@Override
	void engineTrigger() {
		if (!engine) {
			System.out.println("전기차 버튼으로 시동ON.");
			engine = true;
		} else {
			System.out.println("전기차는 버튼으로 시동OFF");
			engine = false;
		}
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
				System.out.println("충전이 완료 되었습니다. 현재 배터리 잔량 " + this.battery + "/100 입니다.");
				break;
			} else {
				System.out.println("충전가능한 범위를 초과하였습니다 다시입력하세요");
			}
		}
	}

	@Override
	void printInfo() {
		System.out.println("브랜드: " + this.brand + " 모델: " + this.model + " 색깔: " + this.color + " 가격: " + this.price
				+ "연료: " + this.battery + "%");
		if (!engine) {
			System.out.println("전기차 시동이 꺼져있습니다.");
		} else {
			System.out.println("전기차 시동이 켜져있습니다.");
		}
	}

}

class SuperCar extends Car {
	boolean roof;

	SuperCar(String color, String brand, String model, String price) {
		super(color, brand, model, price);
		roof = false;
	}

//	@Override
//	void on() {
//		engine = true;
//		System.out.println("슈퍼카는 지문으로 시동이 켜졌습니다");
//	}
//
//	@Override
//	void off() {
//		engine = false;
//		System.out.println("슈퍼카는 지문으로 시동이 꺼졌습니다");
//	}
	
	@Override
	void engineTrigger() {
		if (!engine) {
			System.out.println("슈퍼카 지문으로 시동 ON");
			engine = true;
		} else {
			System.out.println("슈퍼카 지문으로 시동 OFF");
			engine = false;
		}
	}

	@Override
	void printInfo() {
	
		System.out.println("브랜드: " + this.brand + " 모델: " + this.model + " 색깔: " + this.color + " 가격: " + this.price
				+ "연료: " + this.fuel);
		if (!roof) {
			System.out.println("슈퍼카 루프가 닫혀있습니다.");
		} else {
			System.out.println("슈퍼카 루프가 열려있습니다.");
		}
		if (!engine2) {
			System.out.println("슈퍼카 시동이 꺼져있습니다.");
		} else {
			System.out.println("슈퍼카 시동이 켜져있습니다.");
		}
	}

//	void roofOpen() {
//		roof = true;
//		System.out.println("루프가 열렸습니다");
//	}
//
//	void roofClose() {
//		roof = false;
//		System.out.println("루프가 닫혔습니다");
//	}
	
	void roofTrigger() {
		if (!this.roof) {
			System.out.println("루프 OPEND");
			this.roof = true;
		} else {
			System.out.println("루프 CLOSED");
			this.roof = false;
		}
	}

}

public class CarCoding {
	public static void msg(int i) {
		String[] msg = { "브랜드 입력 >> ", "모델 입력 >> ", "색상 입력 >> ", "가격 입력 >> " };
		System.out.println(msg[i]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Car[] car = new Car[3];
		// String[] carInfo = new String[4];
		String ans1;
		String ans2;
		String ans3;
		String ans4;
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
			System.out.println("6. 차량 시동");
			System.out.println("======================");
			System.out.println("6. 차량 매각");
			System.out.println("======================");
			System.out.println("0. 프로그램 종료");
			System.out.println("======================");
			System.out.println("입력 >> ");
			int action = sc.nextInt();
			if (action == 0) {
				System.out.println("프로그램을 종료합니다 . . .");
				break;
			} else if (action == 1) {
				System.out.println("=====   차량구매   =====");
				System.out.println("1. 일반차");
				System.out.println("2. 전기차");
				System.out.println("3. 슈퍼카");
				System.out.println("입력 >> ");
				option = sc.nextInt();
				if (index >= 3) {
					System.out.println("더이상 구매하실 수 없습니다");
					continue;
				}
				if (option == 1) {
					System.out.println("브랜드 입력>> ");
					ans1 = sc.next();
					System.out.println("모델입력>> ");
					ans2 = sc.next();
					System.out.println("색깔입력>> ");
					ans3 = sc.next();
					System.out.println("가격입력>> ");
					ans4 = sc.next();
					car[index++] = new Car(ans3, ans1, ans2, ans4);
				} else if (option == 2) {
					System.out.println("브랜드 입력>> ");
					ans1 = sc.next();
					System.out.println("모델입력>> ");
					ans2 = sc.next();
					System.out.println("색깔입력>> ");
					ans3 = sc.next();
					System.out.println("가격입력>> ");
					ans4 = sc.next();
					car[index++] = new ElecCar(ans3, ans1, ans2, ans4);
				} else if (option == 3) {
					System.out.println("브랜드 입력>> ");
					ans1 = sc.next();
					System.out.println("모델입력>> ");
					ans2 = sc.next();
					System.out.println("색깔입력>> ");
					ans3 = sc.next();
					System.out.println("가격입력>> ");
					ans4 = sc.next();
					car[index++] = new SuperCar(ans3, ans1, ans2, ans4);
				} else {
					System.out.println("잘못입력하셨습니다");
					continue;
				}
			} else if (action == 2) {
				if (index <= 0) {
					System.out.println("구매하신 차량이 없습니다");
					continue;
				}
				System.out.println("전체목록출력");
				for (int i = 0; i < index; i++) {
					car[i].printInfo();
					System.out.println();
				}
			} else if (action == 3) {
				if (index <= 0) {
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
				System.out.println("가격은 " + car[maxInd].price + "입니다");
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
						if (car[i] instanceof ElecCar) {
							car[i].fill();
						}
					}
				} else if (option == 2) {
					for (int i = 0; i < index; i++) {
						if (!(car[i] instanceof ElecCar)) {
							car[i].fill();
						}

					}
				}
			} else if (action == 5) {
				if (index <= 0) {
					System.out.println("구매하신 차량이 없습니다");
					continue;
				}
				for (int i = 0; i < index; i++) {
					if (car[i] instanceof SuperCar) {
						((SuperCar) car[i]).roofTrigger();
					}
				}
				
			}else if (action == 6) {
				if (index <=0 ) {
					System.out.println("구매하신 차량이 없습니다");
					continue;
				}
				for (int i=0; i < index; i++ ) {
					car[i].engineTrigger();
				}
			
				
				
			} else if (action == 6) {
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
