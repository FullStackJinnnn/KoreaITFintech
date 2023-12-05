////CRUD 설계
////부모클래스
////
////생물
////에너지
////이름
////
////void 정보출력()
////자식클래스
////
////식물    		  사람
////에너지->1~50   에너지 -> 1~100		  
////이름			  이름
////잎사귀갯수		  나이   
////		
////void 광합성()    void 음식먹기()
////			    void 1년 후 ()
////
////Create	생물 등록  	->식물
////		         	    ->사람
////Read	전체검색 
////	    사람검색
////
////Update	광합성 start -> 식물 에너지 현재부터 50까지필요한 만큼 증가    
////
////			음식먹기 start -> 사람에너지 1~50랜덤증가
////			1년후 -> 나이 1 증가
//
//한글코딩
//class LivingThings {
//	LivingThings(){
//		int 에너지
//		String 이름
//	}
//	
//	printInfo() {
//		(이생물의 에너지 : ~ 이름 : ~)
//	}
//}
//
//class Plant extends LivingThigns  {
//	super(int 에너지, String 이름)
//	this.잎사귀개수 = 잎사귀개수
//	}
//
//	void photosynthesis () {
//		int 에너지 = 50 - 현재에너지
//		this에너지 += 에너지;
//		
//	@Override
//	printInfo() {
//		(이식물의 에너지 : ~ 이름 : ~ 잎사귀 개수 : ~)
//	}
//	
//}
//
//class Person extends LivingThings {
//	Person(int 에너지, String 이름) {
//		this(int 에너지, Stirng 이름, -1) 
//	}
//	
//	Person(int 에너지, String 이름, int 나이) {
//		super(int 에너지, String 이름)
//		this.나이 = 나이
//	}
//	
//	void meal () {
//		this.에너지 += 랜덤(1~30)증가
//	}
//	void yearLater () {
//		this.나이 += 1증가
//	}
//	
//	@Override
//	printInfo() {
//		(이사람의 에너지 : ~ 이름 : ~ 나이 : ~)
//	}
//}
//
//
//
//
//
//
//
//public class teamasgmt {
//	
//	생물 객체배열 6칸 생성
//	1. 생물등록	2.사람만보기	3. 전체보기 및 광합성, 1년후, 음식먹기 4.종료
//	while(true) {
//		int ans = 사용자입력
//		if (ans == 1) {
//			ams = 사용자입력
//			1. 식물등록 2. 사람등록
//			if (1) {
//				생물객체[0] = new 식물(5,진달래,20)
//				생물객체[1] = new 식물(2,무궁화,10)
//				생물객체[2] = new 식물(20,해바라기,5)
//				식물 등록완료!
//			} else {
//				생물객체[3] = new 사람 (50,석진,31)
//				생물객체[4] = new 사람 (80,아지,28)
//				생물객체[5] = new 사람 (20,철수,20)
//			}
//		}
//		else if (2) {
//			for (int i=0; i<생물객체배열길이 i++) {
//				if (생물객체[i] instanceof 사람) {
//				생물객체[i].printInfo();
//				}
//			}
//		}
//		else if (3) {
//			for (int i=0; i<생물객체배열길이 i++) {
//				if (생물객체[i] instanceof 사람) {
//					사람 사람객체 = (사람) 생물객체[i]
//					사람객체.meal();
//					사람객체.yearLater;
//				    생물객체[i].printInfo();
//				} else {
//					식물 식물객체 = (식물) 생물객체[i]
//					식물객체.photosynthesis
//					생물객체[i].printInfo();
//				}
//			}
//		}
//		else {
//			break;
//		}
//	}	
// }
//
//import java.util.Random;
//import java.util.Scanner;
//
//class LivingThings {
//	int energy;
//	String name;
//
//	LivingThings(int energy) {
//		this.energy = energy;
//	}
//
//	LivingThings(int energy, String name) {
//		this.energy = energy;
//		this.name = name;
//	}
//
//	void printInfo() {
//		System.out.println("이생물의 에너지 :" + this.energy + " 이름 :" + this.name);
//	}
//}
//
//class Plant extends LivingThings {
//	int leaves;
//
//	Plant(int energy, String name, int leaves) {
//		super(energy, name);
//		this.leaves = leaves;
//	}
//
//	void photosynthesis() {
//		int energy = 50 - this.energy;
//		this.energy += energy;
//
//	}
//
//	@Override
//	void printInfo() {
//		System.out.println("이식물의 에너지 : " + this.energy + " 이름 : " + this.name + " 잎사귀 개수 : " + this.leaves);
//	}
//
//}
//
//class Person extends LivingThings {
//	int age;
//
//	Person(int energy, String name) {
//		this(energy, name, -1);
//	}
//
//	Person(int energy, String name, int age) {
//		super(energy, name);
//		this.age = age;
//	}
//
//	void meal() {
//		Random rand = new Random();
//		this.energy += rand.nextInt(30) + 1;
//	}
//
//	void yearLater() {
//		this.age++;
//	}
//
//	@Override
//	void printInfo() {
//		System.out.println("이사람의 에너지 : " + this.energy + " 이름 : " + this.name + " 나이 : " + this.age);
//	}
//}
//
//public class teamasgmt {
//	public static void main(String[] args) {
//
//		LivingThings[] LT = new LivingThings[6];
//		System.out.println("1. 생물등록 2.사람만보기 3. 전체보기 및 광합성, 1년후, 음식먹기 4.종료");
//
//		while (true) {
//			Scanner scan = new Scanner(System.in);
//			int ans = scan.nextInt();
//			if (ans == 1) {
//				System.out.println("1. 식물등록 2. 사람등록");
//				ans = scan.nextInt();
//				if (ans == 1) {
//					LT[0] = new Plant(5, "진달래", 20);
//					LT[1] = new Plant(2, "무궁화", 10);
//					LT[2] = new Plant(20, "해바라기", 5);
//					System.out.println("식물 등록완료!");
//				} else {
//					LT[3] = new Person(50, "석진", 31);
//					LT[4] = new Person(80, "아지", 28);
//					LT[5] = new Person(20, "철수", 20);
//					System.out.println("사람 등록완료!");
//				}
//			} else if (ans == 2) {
//				for (int i = 0; i < LT.length; i++) {
//					if (LT[i] instanceof Person) {
//						LT[i].printInfo();
//					}
//				}
//			} else if (ans == 3) {
//				for (int i = 0; i < LT.length; i++) {
//					if (LT[i] instanceof Person) {
//						Person per = (Person) LT[i];
//						per.meal();
//						per.yearLater();
//						per.printInfo();
//					} else {
//						Plant plan = (Plant) LT[i];
//						plan.photosynthesis();
//						plan.printInfo();
//					}
//				}
//			} else {
//				break;
//			}
//		}
//
//	}
//}
