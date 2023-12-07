package class04;

import java.util.Random;
import java.util.Scanner;

class SamsungTV implements TVinterface {
	String userName;
	int channel;

	SamsungTV(String userName) {
		this(userName, 1);
	}

	SamsungTV(String userName, int channel) {
		this.userName = userName;
		this.channel = channel;
	}

	@Override
	public void channelUp() {
		this.channel++;
		System.out.println("채널+1");
	}

	@Override
	public void channelDown() {
		this.channel--;
		if (this.channel < 0) {
			this.channel = 0;
		}
		System.out.println("채널-1");
	}

	public void channelRandom() {
		Random rand = new Random();
		int num = rand.nextInt(998) + 1;
		while (this.channel != num) {
			this.channel = num;
			break;
		}
		System.out.println("채널 랜덤");
	}

	@Override
	public void printInfo() {
		System.out.println(this.userName + " 님의 현재 시청 채널은 " + this.channel + " 입니다.");
	}

}

class SamsungMiniTV extends SamsungTV {
	Random rand = new Random();
	int battery = rand.nextInt(21) + 50;

	SamsungMiniTV(String userName) {
		super(userName, 1);
	}

	@Override
	public void channelRandom() {
		if (this.battery > 0) {
			super.channelRandom();

			this.battery -= 10;
			System.out.println("베터리 10 감소");
		} else {
			System.out.println("베터리 마이너스 -_-!!  랜덤변경 불가능");
		}
	}

	@Override
	public void printInfo() {
		System.out.println(this.userName + " 님의 현재 시청 채널 :" + this.channel + " 베터리 :" + this.battery);
	}

}

class LgTV implements TVinterface {
	boolean power = false;
	int channel;

	@Override
	public void channelUp() {
		this.channel++;
		System.out.println("채널 증가");
	}

	@Override
	public void channelDown() {
		this.channel--;
		if (this.channel < 0) {
			this.channel = 0;
		}
		System.out.println("채널 감소");
	}

	public void turnOnOff() {
		if (!power) {
			System.out.println("TV ON!");
			this.power = true;
		} else {
			System.out.println("TV OFF");
			this.power = false;
		}
	}

	public boolean checkturnOnOff() {
		if (!this.power) {
			System.out.println("현재 TV상태 OFF 켜주세요");
			return this.power;
		} else {
			return true;
		}

	}

	@Override
	public void printInfo() {
		System.out.println("현재 시청 채널은 " + this.channel + "입니다.");
	}

}

public class Test01 {
	public static void main(String[] args) {
		SamsungTV tv1 = new SamsungTV("홍길동");
		SamsungMiniTV tv2 = new SamsungMiniTV("홍길동");
		LgTV tv3 = new LgTV();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.삼성 2.삼성미니 3.엘쥐");
			System.out.println("영원히 못나갑니다");
			int tv = sc.nextInt();
			if (tv == 1) {
				System.out.println("삼성TV 조작중");
				System.out.println("1.채널up 2.채널down 3.채널random 4.정보출력 5.exit");
				A: while (true) {
					switch (sc.nextInt()) {
					case 1:
						tv1.channelUp();
						break;
					case 2:
						tv1.channelDown();
						break;
					case 3:
						tv1.channelRandom();
						break;
					case 4:
						tv1.printInfo();
						break;
					case 5:
						break A;
					}

				}
			}

			else if (tv == 2) {
				System.out.println("삼성미니TV 조작중");
				System.out.println("미니TV는 베터리를 신경써야합니다.");
				System.out.println("현재상태");
				tv2.printInfo();
				System.out.println("1.채널up 2.채널down 3.채널random 4.정보출력 5.exit");
				A: while (true) {
					switch (sc.nextInt()) {
					case 1:
						tv2.channelUp();
						break;
					case 2:
						tv2.channelDown();
						break;
					case 3:
						tv2.channelRandom();
						break;
					case 4:
						tv2.printInfo();
						break;
					case 5:
						break A;
					}

				}
			}

			else if (tv == 3) {
				System.out.println("LgTV 조작중");

				System.out.println("1.채널up 2.채널down 3.정보출력 4.TV켜기 5.exit");
				A: while (true) {
					switch (sc.nextInt()) {

					case 1:
						if (tv3.checkturnOnOff()) {
							tv3.channelUp();
						}
						break;
					case 2:
						if (tv3.checkturnOnOff()) {
							tv3.channelDown();
						}
						break;
					case 3:
						if (tv3.checkturnOnOff()) {
							tv3.printInfo();
						}
						break;
					case 4:
						tv3.turnOnOff();
						break;
					case 5:
						if (tv3.checkturnOnOff()) {
							tv3.turnOnOff();
						}
						break A;
					}
				}
			}

		}

	}

}
