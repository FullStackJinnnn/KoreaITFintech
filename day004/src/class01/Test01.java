package class01;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthTableHeaderUI;

public class Test01 {
	public static void main(String[] args) {
		// 변수 선언하기
		// 여러명의 학생 점수 데이터를 저장할 예정
		// 몇개인지 정확하지 않아서 배열은 원래 사용 XXX
		// 그래서! 우리는! 학생의 최대 명수를 고정하고 사용!
		// 학생 최대 5명까지 저장가능한 프로그램 ☆
		int[] student=new int[5];
		int index=0; // 현재 저장된 학생의 명수
		// 프로그램을 만들때에는 R->C
		// 출력이 잘 되는지 확인하기 위해, "샘플데이터가" 필요!
		
		Scanner sc = new Scanner(System.in);
		// 사용자의 입력을 받아들이는 클래스(객체)
		// 2명의 학생정보를 임의로 추가하겠습니다.
		//student[index++]=67;
		//student[index++]=39;
	

		
		//프로그램이 몇번 동작하는지 정확히 모름!
		while(true) { //무한루프와
			System.out.println("================");
			System.out.println(" ★학생부 프로그램★");
			System.out.println("================");
			System.out.println(" 1. 학생 추가하기");
			System.out.println(" 2. 학생 전체 정보 불러오기");
			System.out.println(" 3. 특정 학생 1명 검색해서 정보 불러오기");
			System.out.println(" 4. 1등 정보 불러오기");
			System.out.println(" 5. 학생 점수 정보 변경하기");
			System.out.println(" 6. 학생 정보 삭제하기");
			System.out.println(" 7. 프로그램 종료");
			System.out.println("================");
			System.out.println("번호입력>> ");
			int action = sc.nextInt();
	
			
	
			
			if(action==7) { //종료조건
				System.out.println("학생부 푸로그램을 종료합니다...");
				break;	
			}
			
			
			else if(action==1) {
			
				System.out.println();
				
				if (student.length <= index) {
					System.out.println("해당 프로그램은 "+student.length+"명까지 지원하고있습니다.");
					System.out.println("관리자에게 문의해주세요");
					System.out.println("");
					
					//반복문을 멈추고싶지는않은데,
					//한스텝 쉬고싶을때
					continue;
					//해당 반복문의 처음으로 즉시이동
					// break는 반복문을 멈춰버리는것
					//->while 문의 가장 처음으로 돌아간다!!!!!!!!! 
				}
			
				while (true) {
					System.out.println((index+1)+"번 학생을 추가합니다.");
					System.out.println("학생 점수 입력 >>");
					int score=sc.nextInt();
					
					// 유효성 검사
					// :사용자의 거의 모든 입력값에 대하여 수행하는값
					// 목적 == 에러 최소화
					if ((score>=0) && (score<=100)) {
						student[index++]=score;
						System.out.println(index+"번 학생 추가완료!");
						System.out.println();
						break;
						}
					else {
						System.out.println("점수는 0~100까지 입력 가능합니다.");
						System.err.println("다시 입력해주세요!");
					}
				}
			}
						
					
			else if(action==2) { //전체 출력
				if (index <= 0) { //혹시모를 -일수있기 때문에 이렇게 쓰는게 더좋다 == 보다
					System.err.println("입력된 학생의 정보가 없습니다!!!!");
				}			
				else {
				System.out.println("전체 출력");
				//처음부터 존재하는 학생만큼 출력하기
				// 범위가 존재 => for문
				for (int i=0; i<index; i++) {
					System.out.println((i+1) + "번 학생의 점수는 " + student[i] +  "점입니다.");
				}
				System.out.println();
				}
			}
			
			else if(action==3) { //학생 검색
				// 1) 학생의 번호를 사용자가 입력
				// 2) 해당 번호의 학생 점수 정보가 출력
				if (index <= 0) {
					System.err.println("입력된 학생의 정보가 없습니다!!!!");
				}
				else {
				System.out.println("검색할 학생 번호 입력 >>");
				int stuNum = sc.nextInt();
					if(stuNum<1 || index<stuNum) { // 사용자가 잘못된 입력을 했다면 == 범위 외 입력
					System.out.println("해당 번호를 가진 학생은 존재하지 않습니다.");
					System.out.println("확인 후 다시 이용해주세요....");
					}
					else {
						System.out.println(stuNum+"번 학생은" + student[stuNum-1]+ "점 입니다.");
					}
				
				System.out.println();
				}
			}
			
			else if(action==4) {
				
				if (index <= 0) {
					System.err.println("입력된 학생의 정보가 없습니다!!!!");
				}		
				else {
			
				int maxIndex = 0;
				for (int i=1; i<index; i++) {
					if(student[maxIndex]<student[i]) {
						maxIndex = i;
					}
				}
				System.out.println();
				System.out.println("입력된 학생중에서 1등학생의 번호와 점수는 ! ! ! ");
				System.out.println("1등학생 번호 : " + (maxIndex+1)+ "번" + "\n1등학생 점수 : " + student[maxIndex] +"점");
			
				}
				System.out.println();
			}
	
		
			else if (action == 5) {

				if (index == 0) {
					System.out.println("변경할 학생 데이터가 하나도 없습니다.");
					System.out.println("학생 부터 추가해 주세요");
					continue;
				}

				System.out.println("점수 변경할 학생의 번호를 입력하세요 >>");
				int stuNum = sc.nextInt();

				if (stuNum <= index && stuNum > 0) {
					System.out.println(stuNum + "번은 현재" + student[stuNum - 1] + "점 입니다.");
					
					while (true) {
						System.out.println("새로운 점수를 입력해주세요");
						int score = sc.nextInt();
						if (score != student[stuNum - 1] && score >= 0 && score <= 100) {
							student[stuNum - 1] = score;
							System.out.println(stuNum + "번은 " + student[stuNum - 1] + "점으로 변경되었습니다!");
							break;
						} 
						else if (score == student[stuNum - 1]) {
							System.err.println("점수가 동일한데 같은 점수로 변경할까요 ? 맞으면  y 아니면 n 입력");
							String ans = sc.next();
							if (ans.equals("y")) {
								System.out.println("y를 선택했습니다. 기존 점수 유지");
								break;
							} 
							else if (ans.equals("n")) {
								System.out.println("n을 입력했습니다. 점수를 다시 입력하세요");
							}
							else {
								System.out.println("잘못입력");
							}
						} else {
						System.err.println("점수가 이상하다 재입력!!!!!!");
						}
					}
				} else {
					System.err.println("해당 학생은 없습니다~");
					continue;
				}
			}
			
			
			else if(action==6) { //정보 삭제
				
				//배열은 추가,삭제가 안됨
				//배열 자체를 추가하거나 삭제할수없음
				//지금은, 마지막 학생 제거로 한다.
				System.out.println();
				
				if(index<=0) {
					System.out.println("제거할 정보가 없습니다...");
					System.out.println();
					continue;
				}
				
				System.out.println(index+"번 학생 정보를 제거합니다...");
				index--;
				System.out.println("제거 완료!");
				System.err.println();
			}
			
			
		}
	}
}
