package teamproject;

import java.util.ArrayList;
import java.util.Scanner;

class User{ // 풋볼플레이어의 객체들을 공유해야 구입했을 때 구입한 선수의 목록이 추가 됨, 근데 이게 가능하면 판매도 가능해짐, 우리는 프로그램 계획짤때 판매기능 없이 하겠다고 했었는데 어떡할지.. 
	private String name;
	private int money;
	
	public User(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}

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
		this.position = position;
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

	@Override
	public String toString() {
		return "FootballPlayer [pk=" + pk + ", name=" + name + ", position=" + position + ", totalPower=" + totalPower
				+ ", price=" + price + ", ea=" + ea + "]";
	}

}

public class FootballMarket {

	public static int select;
	public final static int MANAGERMODE = 123;
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<FootballPlayer> datas = new ArrayList<FootballPlayer>();
	public static int PK = 1001;
	public static ArrayList<User> users = new ArrayList<User>();
	
	
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

	/*
	 * 선수 구매하기
	 */

	// players: 선수 목록
	// index: 구매할 선수 번호
	// num: 구매 수량
	// 반환값: true -> 성공, false -> 실패

	public static int func(ArrayList<FootballPlayer> datas,int num) {
		// 존재하는 번호인지 ???
		boolean flag=false;
		int i=-1;
		for(i=0;i<datas.size();i++) {
			if(datas.get(i).getPk()==num) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			System.out.println(num+"번 선수 없음.");
		}      
		return i;
	}
	


	public static boolean buy() {
		/*ArrayList<FootballPlayer> players, int index, int num*/
		//		만약 선수목록에 입력받은 선수pk가 존재한다면
		//		누구를 구입하겠습니다.
		//		구입할 수량을 입력해주세요.
		//		만약 구입할 수량이 재고를 초과했다면
		//		재고가 부족합니다.
		//		구입할 수량이 재고보다 작다면
		//		구입진행
		//		만약 선수목록에 입력받은 선수pk가 존재하지 않는다면
		//		판매목록에 존재하지않습니다. 다시 입력해주세요.

		System.out.println("번호 입력 >> ");
		int choiceNum=sc.nextInt();
		func(datas, choiceNum);
		boolean flag = false;
		int i=0;
		while(i<datas.size()) {
			if(datas.get(i).getPk()==choiceNum) {
				System.out.println("구입할 수량 입력 >> ");
				int cnt=0;
				try {
					cnt = sc.nextInt();
				} catch (Exception e) {
					System.out.println("1~"+datas.get(i).getEa()+" 입력가능");
					sc.nextLine();
					continue;
				}
				if(0<cnt&&cnt<=datas.get(i).getEa()) {
					System.out.println(datas.get(i).getName()+" "+cnt+"개를 구입하시겠습니까 ?");
					String answer = sc.next();
					System.out.println(answer);
					if(answer.equals("Y")) {
						System.out.println(datas.get(i).getName()+" "+cnt+"개 구입완료!");
						datas.get(i).setEa(datas.get(i).getEa()-cnt);
						users.get(0).setMoney(users.get(0).getMoney() - (datas.get(i).getPrice()*cnt));
						//구매를 할래도 구매를 하려는 유저의 객체가 필요하다. 판매를 하려해도 마찬가지.. 이걸 안하기로 했었는데 어떡할까
						System.out.println("남은 돈 : "+users.get(0).getMoney());
						flag=true;
					}
					else if(answer.equals("N")) {
						System.out.println("구입 취소");
					}
					else {
						System.out.println("Y 또는 N 만 입력 가능");
						continue;
					}
				}
				else{
					System.out.println("재고 부족");
					System.out.println("1~"+datas.get(i).getEa()+"입력 가능");
					continue;
				}
			}
			i++;
		}
		return flag;
	}

	// 관리자 모드 시작

	public static void execManagerMode() { // 관리자 모드 실행
		System.out.println("관리자 모드입니다");
		printManagermode();
	}

	public static String getPosition(String msg) { // 포지션 입력 및 유효성 검사
		System.out.print(msg);
		System.out.println("(FW / MF / DF/ GK) >> ");
		while (true) {
			String position = sc.next();
			if (position.equals("FW") || position.equals("MF") || position.equals("DF") || position.equals("GK")) {
				return position;
			}
			System.out.println("포지션은 FW, MF, DF, GK 중에만 입력하실 수 있습니다.");
			System.out.print("다시 입력해주세요 >> ");
		}

	}

	public static int getNum(String msg, int min, int max) { // 숫자 입력 및 유효성 검사
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
		while(true) {
			int power = getNum("새로운 능력치를 입력해주세요", 40, 100);
			if(power != datas.get(i).getTotalPower()) {
				datas.get(i).setTotalPower(power);
				break;
			}
			else {
				System.out.println("같은 능력치는 입력하실 수 없습니다.");
			}

		}
	}

	public static void checkUpdateEa(int i) {
		while(true) {
			int ea = getNum("새로운 수량을 입력해주세요", 1, 10);
			if(ea != datas.get(i).getEa()) {
				datas.get(i).setEa(ea);
				break;
			}
			else {
				System.out.println("같은 수량으로는 입력하실 수 없습니다.");
			}
		}


	}


	public static void updateFootballPlayer() { // 선수 정보 변경
		if (!checkListEmpty()) {

			printAllFootballPlayer();
			int i = checkPlayerPk();
			System.out.println("1. 가격 변경");
			System.out.println("2. 능력치 변경");
			System.out.println("3. 수량 변경");
			select = getNum("어떤정보를 변경하시겠습니까?", 1, 3);
			if(select==1) {
				checkUpdatePrice(i);
			}
			else if(select == 2) {
				checkUpdateTotalPower(i);
			}
			else if(select == 3) {
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



	// 관리자 모드 끝

	public static void printByPrice() {
		System.out.println("이적시장 목록을 출력합니다.");
		System.out.println(datas.size());
		for (FootballPlayer footballPlayer : datas) {
			System.out.println(footballPlayer);
		}
		buy();
	}

	public static void printByTotalPower() {
		for (FootballPlayer footballPlayer : datas) {
			System.out.println(footballPlayer);
		}

	}

	public static void printByPosition() {
		for (FootballPlayer footballPlayer : datas) {
			System.out.println(footballPlayer);
		}

	}

	public static void searchByName() {
		for (FootballPlayer footballPlayer : datas) {
			System.out.println(footballPlayer);
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
		datas.add(new FootballPlayer(PK++, "메시", "FW", 86, 8600, 4));
		datas.add(new FootballPlayer(PK++, "손흥민", "FW", 83, 8300, 7));
		datas.add(new FootballPlayer(PK++, "박지성", "MF", 81, 8100, 3));
		datas.add(new FootballPlayer(PK++, "김덕배", "MF", 85, 8500, 2));
		datas.add(new FootballPlayer(PK++, "캉진리", "MF", 77, 7700, 7));
		datas.add(new FootballPlayer(PK++, "에브라", "DF", 83, 8300, 6));
		datas.add(new FootballPlayer(PK++, "민짜이", "DF", 79, 7900, 4));
		datas.add(new FootballPlayer(PK++, "말디니", "DF", 84, 8400, 3));
		datas.add(new FootballPlayer(PK++, "알베기스", "DF", 83, 8300, 3));

		users.add(new User("짱구", 9999999));
		
		run();



	}
}
