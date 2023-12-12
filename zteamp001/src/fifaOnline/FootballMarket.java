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

	FootballPlayer(int pk, String name, String position, int totalPower, int price, int ea) {
		this.pk = pk;
		this.name = name;
		this.position = position; // FW, MF, DF, GK
		this.totalPower = totalPower;
		this.price = price;
		this.ea = ea;
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

	@Override // 유저한테 PK 안보이도록 설정
	public String toString() {
		if (FootballMarket.checkManageMode) {
			return "FootballPlayer [pk=" + pk + ", name=" + name + ", position=" + position + ", totalPower="
					+ totalPower + ", price=" + price + ", ea=" + ea + "]";
		} else {
			return "FootballPlayer [name=" + name + ", position=" + position + ", totalPower=" + totalPower + ", price="
					+ price + ", ea=" + ea + "]";
		}
	}

	
	public void sell(int cnt) {
		this.ea -= cnt;
	}

	// 삽입정렬을 사용해서 모듈화하려고 했으나 어려워서 익명객체(클래스), Comparator, sort 기능 활용...
	public static Comparator<FootballPlayer> byPrice = new Comparator<FootballPlayer>() {
		@Override
		public int compare(FootballPlayer p1, FootballPlayer p2) {
			return p2.price - p1.price;
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
	public final static int MANAGERMODE = 231121;
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<FootballPlayer> datas = new ArrayList<FootballPlayer>();
	public static int PK = 1001;
	public static boolean checkManageMode = false;

	// Positions // TODO: 빼자
	public final static String Pos_FW = "FW";
	public final static String Pos_MF = "MF";
	public final static String Pos_DF = "DF";
	public final static String Pos_GK = "GK";

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
		while (true) {
			try {
				return sc.nextInt();
			} catch (Exception e) {
				System.out.println("'정수'만 입력가능합니다.");
				sc.nextLine();
			}
		}
	}

	// 포지션 입력 및 유효성 검사
	public static String getPosition(String msg) {
		System.out.print(msg);
		System.out.println("(FW / MF / DF / GK) >> ");
		while (true) {
			String position = sc.next();
			if (position.equals("FW") || position.equals("MF") || position.equals("DF") || position.equals("GK")) {
				return position;
			}
			System.out.println("포지션은 FW, MF, DF, GK 중에만 입력하실 수 있습니다.");
			System.out.print("다시 입력해주세요 >> ");
		}

	}

	// 숫자 입력 및 유효성 검사
	public static int getNum(String msg, int min, int max) {
		System.out.print(msg);
		System.out.print("(" + min + " ~ " + max + ") >> ");
		while (true) {
			try {
				int chooseNum = sc.nextInt();
				if (chooseNum >= min && chooseNum <= max) {
					return chooseNum;
				} else {
					System.out.println(min + "과 " + max + "사이의 값만 입력 가능합니다.");
				}
			} catch (Exception e) {
				System.out.println(min + "과 " + max + " 사이의 '정수'만 입력가능합니다.");
				sc.nextLine();
			}
		}

	}

	public static String getAnswer(String msg) {
		System.out.println(msg);

		while (true) {
			String answer = sc.next();
			if (answer.equals("Y") || answer.equals("N")) {
				return answer;
			}
			System.out.println("Y 또는 N 만 입력 가능합니다.");
			System.out.print("다시 입력해주세요 >> ");
		}
	}
	/*
	 * 선수 구매하기
	 */

	// players: 선수 목록
	// index: 구매할 선수 번호
	// num: 구매 수량
	// 반환값: true -> 성공, false -> 실패

	// TODO 현진님 코드 수정
	public static void buy(ArrayList<FootballPlayer> players) {
		while (true) {
			int eaCnt = 0;
			for (int i = 0; i < players.size(); i++) {
				eaCnt += players.get(i).getEa();
			}
			if (eaCnt <= 0) {
				System.out.println("등록된 모든 선수의 재고가 없습니다.");
				break;
			}

			
			//플레이어 배열에서 4번수 추출.
			//몇개인지사용자한테 받아서 판다.
			//그 선수가 sell 한다.
			int choiceNum = getNum("구매할 선수 번호 입력 ", 1, players.size());

			if (players.get(choiceNum - 1).getEa() <= 0) {
				System.out.println("해당선수 재고가 없습니다.");
				continue;
			}
			int cnt = getNum("구입할 수량 입력 ", 1, players.get(choiceNum - 1).getEa());
			System.out.println(cnt + "개를 구입하시겠습니까 ?");

			String answer = getAnswer("Y or N >> ");
			if (answer.equals("Y")) {
				System.out.println(players.get(choiceNum - 1).getName() + " " + cnt + "개 구입완료!");
				players.get(choiceNum-1).sell(cnt);
				break;
			} else {
				System.out.println("구입 취소");
			}

		}
	}

	/*
	 * Manager Mode
	 */

	public static void execManagerMode() { // 관리자 모드 실행
		FootballMarket.checkManageMode = true; // CHECK: FootballMarket 지워도 되나?
		System.out.println("관리자 모드입니다.");
		printManagermode();
	}

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
		int action = getNum("번호를 입력해주세요", 0, 3);
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

	public static boolean checkListEmpty() { // 배열리스트가 비어있는지 검사
		if (datas.size() == 0) {
			System.out.println("등록된 선수가 없습니다...");
			return true;
		}
		return false;
	}

	public static void deleteFootballPlayer() { // 선수 삭제

		if (!checkListEmpty()) {
			datas.sort(FootballPlayer.byPk); // CHECK: 혹시 섞였을까봐?
			printAllFootballPlayer();
			int i = checkPlayerPk();
			datas.remove(i);
		}

	}

	public static int checkPlayerPk() { // PK 유효성 검사

		while (true) {
			try {
				int changePlayer = getNum("변경할 선수의 PK를 입력해주세요 >>");
				for (int i = 0; i < datas.size(); i++) {
					if (datas.get(i).getPk() == changePlayer) {
						return i;
					}
				}
				System.out.println("유효하지 않은 PK입니다.");

			} catch (Exception e) {
				System.out.println("정수를 입력해주세요");
				sc.nextLine();
			}
		}
	}

	public static void checkUpdatePrice(int i) {
		while (true) {
			int price = getNum("새로운 가격을 입력해주세요", 1000, 10000);
			if (price != datas.get(i).getPrice()) {
				datas.get(i).setPrice(price);
				break;
			} else {
				System.out.println("같은 가격은 입력하실 수 없습니다.");
			}
		}
	}

	public static void checkUpdateTotalPower(int i) {
		while (true) {
			int power = getNum("새로운 능력치를 입력해주세요", 40, 100);
			if (power != datas.get(i).getTotalPower()) {
				datas.get(i).setTotalPower(power);
				break;
			} else {
				System.out.println("같은 능력치는 입력하실 수 없습니다.");
			}

		}
	}

	public static void checkUpdateEa(int i) {
		while (true) {
			int ea = getNum("새로운 수량을 입력해주세요", 1, 10);
			if (ea != datas.get(i).getEa()) {
				datas.get(i).setEa(ea);
				break;
			} else {
				System.out.println("같은 수량으로는 입력하실 수 없습니다.");
			}
		}

	}

	public static void updateFootballPlayer() { // 선수 정보 변경
		if (!checkListEmpty()) {
			datas.sort(FootballPlayer.byPk);
			printAllFootballPlayer();
			int i = checkPlayerPk(); // CHECK: 2가지 기능 & 이름 바꿔도 되나?
			System.out.println("1. 가격 변경");
			System.out.println("2. 능력치 변경");
			System.out.println("3. 수량 변경");
			select = getNum("어떤정보를 변경하시겠습니까?", 1, 3);
			if (select == 1) {
				checkUpdatePrice(i); // CHECK: 이름에 체크를 떼도 되나?
			} else if (select == 2) {
				checkUpdateTotalPower(i);
			} else if (select == 3) {
				checkUpdateEa(i);
			}

		}

	}

	public static void addFootballPlayer() { // 선수 추가
		System.out.println("선수를 추가합니다.");
		String name = getString("이름을 입력해주세요 >> ");
		String position = getPosition("포지션을 입력해주세요");
		int totalPower = getNum("능력치를 입력해주세요", 40, 100);
		int price = getNum("가격을 입력해주세요", 1000, 10000);
		int ea = getNum("수량을 입력해주세요", 1, 10);
		datas.add(new FootballPlayer(PK++, name, position, totalPower, price, ea));

	}

	/*
	 * Functions
	 */

	public static void printByPrice() {
		if (!checkListEmpty()) {
			ArrayList<FootballPlayer> tmpDatas = new ArrayList<FootballPlayer>(datas);
			tmpDatas.sort(FootballPlayer.byPrice);
			int i = 1;
			for (FootballPlayer data : tmpDatas) {
				System.out.println((i++) + " " + data);
			}
			buy(tmpDatas);
		}
	}

	public static void printByTotalPower() {
		if (!checkListEmpty()) {
			ArrayList<FootballPlayer> tmpDatas = new ArrayList<FootballPlayer>(datas);
			tmpDatas.sort(FootballPlayer.byTotalPower);
			for (FootballPlayer data : tmpDatas) {
				System.out.println(data);
			}
		}
	}

	public static void printBymainPosition(ArrayList<FootballPlayer> players, String position) { // 포지션 입력 // 배열 넣기

		for (FootballPlayer player : players) {
			if (player.getPosition().equals(position)) {
				System.out.println(player);
			}
		}

	}

	public static void printBymaimPositionpage() {
		System.out.println("포지션을 선택해주세요"); // 포지션 번호로 선택
		System.out.println("1. FW");
		System.out.println("2. MF");
		System.out.println("3. DF");
		System.out.println("0. 종료");
		System.out.println("입력>>>>");
	}

	public static void printByPosition() { // 선수 포지션별로 출력하기

		while (true) {
			printBymaimPositionpage(); // 포지션 선택창
			int action = sc.nextInt(); // 포지션 번호로 선택
			if (action == 0) {
				System.out.println("포지션 선택을 나갑니다."); // 포지션 선택 종료
				break;
			} else if (action >= 1 && action <= 3) {
				String selectedPosition = ""; // 선택된 포지션을 저장할 변수

				// 선택된 포지션 설정
				if (action == 1) {
					selectedPosition = "FW"; // 모듈화를 통해 간단하게 표현
				} else if (action == 2) {
					selectedPosition = "MF";
				} else if (action == 3) {
					selectedPosition = "DF";
				}

				System.out.println(selectedPosition + " 포지션 선수 목록");

				printBymainPosition(datas, selectedPosition);

			} else {
				System.out.println("유효하지 않는 번호 입니다 다시 입력해주세요");
			}

		}

	}

	public static void searchByName() {
		if (!checkListEmpty()) {
			String name = getString("선수 이름을 입력해주세요 >> ");
			boolean found = false;
			for (FootballPlayer data : datas) {
				if (data.getName().contains(name)) { // "호날두".contains("호");
					System.out.println(data);
					found = true;
				}
			}
			if (!found) {
				System.out.println("해당 이름을 가진 선수가 없습니다.");
			}
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

	public static void run() {
		while (true) {
			printMainPage();
			controller();
			if (select == 0)
				break;
		}
	}

	public static void main(String[] args) {
		datas.add(new FootballPlayer(PK++, "호날두", "FW", 87, 8700, 5));
		datas.add(new FootballPlayer(PK++, "메시", "FW", 86, 8600, 1));
		datas.add(new FootballPlayer(PK++, "손흥민", "FW", 83, 8300, 1));
//		datas.add(new FootballPlayer(PK++, "박지성", "MF", 81, 8100, 3));
//		datas.add(new FootballPlayer(PK++, "김덕배", "MF", 85, 8500, 2));
//		datas.add(new FootballPlayer(PK++, "캉진리", "MF", 77, 7700, 7));
//		datas.add(new FootballPlayer(PK++, "에브라", "DF", 83, 8300, 6));
//		datas.add(new FootballPlayer(PK++, "민짜이", "DF", 79, 7900, 4));
//		datas.add(new FootballPlayer(PK++, "말디니", "DF", 84, 8400, 3));
//		datas.add(new FootballPlayer(PK++, "알베기스", "DF", 83, 8300, 3));

		run();
	}
}
