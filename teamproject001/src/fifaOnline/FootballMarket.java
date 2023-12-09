package fifaOnline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class FootballPlayer {
	private int pk; // PK
	private String name;
	private String position;
	private int totalPower;
	private int price;
	private int ea;
	private int subIdx;

	FootballPlayer(int pk, String name, String position, int totalPower, int price, int ea) {
		this(pk, name, position, totalPower, price, ea, -1);
	}

	FootballPlayer(int pk, String name, String position, int totalPower, int price, int ea, int subIdx) {
		this.pk = pk;
		this.name = name;
		this.position = position;
		this.totalPower = totalPower;
		this.price = price;
		this.ea = ea;
		this.subIdx = subIdx;
	}

	public int getPk() {
		return pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getTotalPower() {
		return totalPower;
	}

	public void setTotalPower(int totalPower) {
		this.totalPower = totalPower;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public int getSubIdx() {
		return subIdx;
	}

	public void setSubIdx(int subIdx) {
		this.subIdx = subIdx;
	}

	@Override //유저한테 PK 안보이도록 설정
	public String toString() {
		if (FootballMarket.checkManageMode) {
			return "FootballPlayer [pk=" + pk + ", name=" + name + ", position=" + position + ", totalPower="
					+ totalPower + ", price=" + price + ", ea=" + ea + "]";
		} else {
			return "FootballPlayer [name=" + name + ", position=" + position + ", totalPower=" + totalPower + ", price="
					+ price + ", ea=" + ea + "]";
		}

	}

	public void sell() {
		this.ea--;
		System.out.println(this.name + " 구매완료!");
	}

	public static Comparator<FootballPlayer> byPrice = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p1.price - p2.price;
		}

	};

	public static Comparator<FootballPlayer> byTotalPower = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p1.totalPower - p2.totalPower;
		}

	};

	public static Comparator<FootballPlayer> byPk = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p1.pk - p2.pk;
		}

	};

	public static Comparator<FootballPlayer> byName = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p1.name.compareTo(p2.name);
		}

	};
}

public class FootballMarket {

	public static int select;
	public final static int MANAGERMODE = 123;
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<FootballPlayer> datas = new ArrayList<FootballPlayer>();
	public static int PK = 1001;
	public static boolean checkManageMode = false;
	/*
	 * Utils
	 */

	// 문자열 입력받기
	public static String getString(String msg) {
		System.out.print(msg);
		return sc.next();
	}

	// 번호 입력받기
	public static int getNum(String msg) {
		System.out.print(msg);
		return sc.nextInt();
	}

	public static int getNum(String msg, int min, int max) {

		while (true) {
			System.out.print(msg);
			int chooseNum = sc.nextInt();
			if (chooseNum >= min && chooseNum <= max) {
				return chooseNum;
			} else {
				System.out.println("다시 입력해주세요");
			}
		}

	}

	/*
	 * 선수 구매하기
	 */

	// players: 선수 목록
	// index: 구매할 선수 번호
	// num: 구매 수량
	// 반환값: true -> 성공, false -> 실패
	public static boolean buy(ArrayList<FootballPlayer> players, int index, int num) {
		return false;
	}

	/*
	 * Manager Mode
	 */

	public static void printAllFootballPlayer() { // 선수 모두 출력 ( 정보 변경이나 삭제에서 목록을 띄우기 위함)
		for (FootballPlayer data : datas) {
			System.out.println(data);
		}
	}

	public static void printManagermode() { // 관리자 메인 메뉴
		while (true) {
			System.out.println("1. 선수 추가");
			System.out.println("2. 선수 정보 변경");
			System.out.println("3. 선수 삭제");
			System.out.println("0. 관리자 모드 종료");
			if (chooseManagermenu() == 0) {
				checkManageMode = false;
				break;
			}
		}
	}

	public static int chooseManagermenu() { // 관리자 메인 메뉴 번호 선택
		int action = getNum("번호를 입력해주세요 >> ", 0, 3);
		if (action == 1) {
			addFootballPlayer();
		} else if (action == 2) {
			updateFootballPlayer();
		} else if (action == 3) {
			deleteFootballPlayer();
		} else if (action == 0) {
			System.out.println("관리자모드를 종료합니다...");
		}
		return action;

	}

	public static void deleteFootballPlayer() { // 선수 삭제
		datas.sort(FootballPlayer.byPk);
		printAllFootballPlayer();
		int deletePlayer = getNum("삭제할 선수의 PK를 입력해주세요 >>");
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getPk() == deletePlayer) {
				datas.remove(i);
			}
		}

	}

	public static void updateFootballPlayer() { // 선수 정보 변경
		datas.sort(FootballPlayer.byPk); //관리자는 PK로 정렬 
		printAllFootballPlayer();
		int changePlayer = getNum("변경할 선수의 PK를 입력해주세요 >> ");
		int i;
		for (i = 0; i < datas.size(); i++) {
			if (datas.get(i).getPk() == changePlayer) {
				System.out.println("1. 가격 변경");
				System.out.println("2. 능력치 변경");
				System.out.println("3. 수량 변경");
				select = getNum("어떤정보를 변경하시겠습니까?", 1, 3);
				if (select == 1) {
					int price = getNum("새로운 가격을 입력해주세요 >> ", 1000, 10000);
					datas.get(i).setPrice(price);
					break;
				} else if (select == 2) {
					int totalPower = getNum("새로운 능력치를 입력해주세요 >> ", 40, 100);
					datas.get(i).setTotalPower(totalPower);
					break;
				} else if (select == 3) {
					int ea = getNum("새로운 수량을 입력해주세요 >> ", 1, 10);
					datas.get(i).setEa(ea);
					break;
				}
			}
		}

	}

	public static void addFootballPlayer() { // 선수 추가
		System.out.println("선수를 추가합니다.");
		String name = getString("이름을 입력해주세요 >> ");
		String position = getString("포지션을 입력해주세요 >> ");
		int totalPower = getNum("(40~100 사이) 능력치를 입력해주세요 >> ", 40, 100);
		int price = getNum("(1000~10000 사이) 가격을 입력해주세요 >> ", 1000, 10000);
		int ea = getNum("(1~10사이) 수량을 입력해주세요 >> ", 1, 10);
		datas.add(new FootballPlayer(PK++, name, position, totalPower, price, ea));
		// printManagermode(); => 선수 추가후 관리자 모드 종료시 2번 종료해야 나가진다.

		// TODO
	}

	public static void execManagerMode() { // 관리자 모드 시작
		System.out.println("관리자 모드입니다");
		FootballMarket.checkManageMode = true; 
		/*
		 * 1. 선수 추가 (객체 생성) pk, 이름, 포지션, 능력치, 가격, 수량
		 * 
		 * 2. 선수 정보 변경
		 * 
		 * 1. 가격 변경 2. 능력치 변경 3. 수량 변경
		 * 
		 * 3. 선수 삭제 (객체 삭제) pk
		 */
		printManagermode();

	}

	public static void printByPrice() {
		datas.sort(FootballPlayer.byPrice);
		FootballMarket.printAllFootballPlayer();
	}

	public static void printByTotalPower() {
		datas.sort(FootballPlayer.byTotalPower);
		FootballMarket.printAllFootballPlayer();
	}

	public static void sellByPosition(String position) {

		while (true) {
			int i;
			int subIdx = 0;
			int eaCnt = 0;
			datas.sort(FootballPlayer.byName); // defualt 정렬 이름 ?
			for (i = 0; i < datas.size(); i++) {
				if (datas.get(i).getPosition().equals(position)) {
					eaCnt += datas.get(i).getEa();
				}
			}

			if (eaCnt <= 0) {
				System.out.println("현재 " + position + "포지션 재고가 없습니다.");
				break;
			}

			else {
				for (i = 0; i < datas.size(); i++) {
					if (datas.get(i).getPosition().equals(position)) {
						datas.get(i).setSubIdx(subIdx++);
						System.out.print((datas.get(i).getSubIdx() + 1) + ". ");
						System.out.println(datas.get(i));
					}
				}
				FootballMarket.select = getNum("구매하실 선수 번호를 입력해주세요 >>", 1, subIdx);

				boolean flag = false;
				for (i = 0; i < datas.size(); i++) {
					if (datas.get(i).getSubIdx() == FootballMarket.select - 1) {
						if (datas.get(i).getEa() > 0) {
							flag = true;
							break;
						}
					}
				}
				if (!flag) {
					System.out.println("재고가 없습니다.");
					continue;
				}
				datas.get(i).sell();

				for (i = 0; i < datas.size(); i++) {
					datas.get(i).setSubIdx(-1);

				}
				break;
			}
		}
	}

	public static void printByPosition() {
		// 기본정렬 이름
		System.out.println("1. FW");
		System.out.println("2. MF");
		System.out.println("3. DF");
		System.out.println("4. GK");
		while (true) {
			select = getNum("번호를 입력해주세요 >> ", 1, 4);
			if (select == 1) {
				// FW 출력 후 구매
				FootballMarket.sellByPosition("FW");
				break;
			} else if (select == 2) {
				// MF 출력
				FootballMarket.sellByPosition("MF");
				break;
			} else if (select == 3) {
				// DF 출력
				FootballMarket.sellByPosition("DF");
				break;
			} else if (select == 4) {
				// GK 출력
				FootballMarket.sellByPosition("GK");
				break;
			}
		}

	}

	public static void searchByName() {
		String name = FootballMarket.getString("검색하실 이름을 입력해주세요 >>");
		boolean flag = false;
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getName().equals(name)) {
				System.out.println(datas.get(i));
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("없는 선수 입니다.");
		}
	}

	/*
	 * Main Page
	 */

	public static void printMainPage() {
		System.out.println("====================");
		System.out.println("  Football 이적 시장");
		System.out.println("====================");
		System.out.println("1. 가격별 출력");
		System.out.println("2. 능력치별 출력");
		System.out.println("3. 포지션별 출력");
		System.out.println("4. 검색 기능");
		System.out.println("0. 프로그램 종료");
		System.out.println("===================");
	}

	public static void controller() {
		select = getNum("번호를 입력해주세요 >> ");
		if (select == 0) {
			System.out.println("프로그램을 종료합니다..");
		} else if (select == 1) {
			// 가격별 출력
			printByPrice();
		} else if (select == 2) {
			// 능력치별 출력
			printByTotalPower();
		} else if (select == 3) {
			// 포지션별 출력
			printByPosition();
		} else if (select == 4) {
			// 검색 기능
			searchByName();
		} else if (select == MANAGERMODE) {
			// 관리자 모드
			execManagerMode();
		} else if (select < 0 || select > 4) {
			// validation 처리
			System.out.println("유효하지 않은 입력입니다\n다시 입력해주세요\n");
		}
	}

	public static void addSameple() {

		datas.add(new FootballPlayer(PK++, "메시", "FW", 50, 1000, 4));
		datas.add(new FootballPlayer(PK++, "호날두", "FW", 60, 5000, 4));
		datas.add(new FootballPlayer(PK++, "손흥민", "FW", 50, 2000, 4));
		datas.add(new FootballPlayer(PK++, "드록바", "FW", 50, 3000, 4));
		datas.add(new FootballPlayer(PK++, "루니", "MF", 50, 3000, 4));
		datas.add(new FootballPlayer(PK++, "데 헤아", "GK", 50, 3000, 4));
		datas.add(new FootballPlayer(PK++, "김민재", "DF", 50, 3000, 4));

	}

	public static void run() {
		FootballMarket.addSameple();
		while (true) {
			printMainPage();
			controller();

			if (select == 0)
				break;
		}
	}

	public static void main(String[] args) {
		run();
	}
}