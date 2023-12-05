package teamproject;

public class CarPro {
	public static void main(String[] args) {
		 /*
		 * 자동차 클래스 (부모)
		 * 
		 * 멤버변수
		 * 1. String 브랜드 brand
		 * 2. String 모델 model
		 * 3. String 색깔 color
		 * 4. int 가격 price
		 * 5. int 연료 fuel
		 * 6. static boolean 엔진 engine false
		 * -> boolean으로 설정한 이유 : 시동이 켜지면 true 시동이 꺼지면
		 * false로 메서드로 제어하기 위해서. 
		 * 
		 *  모든 차량은 부모의 멤버변수를 가지고 있다.
		 * 
		 *  생성자 
		 *  자동차 (브랜드, 모델, 색깔, 가격) {
		 *  최초 구매시 연료는 30으로 고정
		 *  최초 구매시 엔진은 꺼져있는 상태.
		 *
		 *  Car(브랜드, 모델, 색깔, 가격) {
		 *  최초 구매시 연료는 30으로 고정
		 *  this.fuel = 30;
		 *  }
		 *  
		 *  메서드 
		 *  시동켜짐() 
		 *  void on() {
		 *  System.out.println("시동이 켜졋습니다.");
		 *	시동꺼짐()
		 *	void off() {
		 *  System.out.println("시동이 꺼졌습니다.");
		 *  }
		 *  연료충전()
		 *  void fill () {
		 *  Scanner sc = new Scanner(System.in)
		 *  System.out.println("현재 연료 잔량" + this.fuel+ "입니다.")
		 *  System.out.println("충전가능 범위 " + (100 - this.fuel)+"~100")
		 *  System.out.println("연료를 얼마나 충전하시겠습니까?")
		 *  int answer = sc.nextInt();
		 *  반복문이랑 조건문을 사용해서 정삭적인 범위내 입력하지 않았으면 다시 입력 받는다.
		 *  this.fuel += answer;
		 *  System.out.println("충전이 완료 되었습니다. 현재 연료 잔량 " + this.fuel +"입니다.");
		 *  }
		 *  차량정보출력() {
		 *  System.out.println("브랜드: "+this.name+" 모델: "+this.model+" 색깔: "+this.color
		 *	+" 가격: "+this.price+"+"연료: " +this.fuel);
		 *	}
		 *  자식클래스 
		 *  전기자 
		 *  
		 *  멤버변수 
		 *  베터리(전기차만 가지고 있는 속성)
		 *  
		 *  생성자
		 *   
		 *  전기차 (브랜드, 모델, 색깔, 가격)
		 *  최초 구매시 베터리 잔량은 30
		 *  
		 *  
		 *  ElecCar (브랜드, 모델, 색깔, 가격)
		 *  슈퍼 (브랜드, 모델, 색깔, 가격)
		 *  this.battery = 30; 
		 *  
		 *  메서드
		 *  @오버라이딩
		 *  시동켜짐(버튼으로 켜짐)
		 *  void on() {	
		 *  System.out.println("버튼으로 시동이 켜졌습니다");
		 *  } 
		 *  시동꺼짐(버튼으로 꺼짐)
		 *  void off() {
		 *  System.out.println("버튼으로 시동이 꺼졌습니다");
		 *  }
		 *  베터리충전(0~300분 까지)
		 *  void batteryCharge () {
		 *  
		 *  Scanner sc = new Scanner(System.in)
		 *  System.out.println("현재 베터리 잔량" + this.battery + "%입니다.")
		 *  System.out.println("충전가능 범위 " + (100 - this.battery)+"%~100%")
		 *  System.out.println("베터리를 얼마나 충전하시겠습니까?")
		 *  int answer = sc.nextInt();
		 *  반복문이랑 조건문을 사용해서 정삭적인 범위내 입력하지 않았으면 다시 입력 받는다.
		 *  this.battery += answer;
		 *  System.out.println("충전이 완료 되었습니다. 현재 베터리 잔량 " + this.battery +"%입니다.");
		 *  }
		 *  차량정보출력(베터리만 추가) {
		 *   System.out.println("브랜드: "+this.name+" 모델: "+this.model+" 색깔: "+this.color
		 *	+" 가격: "+this.price+"+"베터리: " +this.battery +"%");
		 *	}
		 *  슈퍼카
		 *  
		 *  멤버변수
		 *  boolean 루프 (슈퍼카만 가지고 있는 속성)
		 *  boolean roof 
		 *
		 *  생성자
		 *  슈퍼카 (브랜드, 모델, 색깔, 가격)
		 *  슈퍼 ()
		 *  최초 구매시 루프가 닫혀 있음
		 *  
		 *  Car(브랜드, 모델, 색깔, 가격) {
		 *  슈퍼 (브랜드, 모델, 색깔, 가격)
		 *  최초 구매시 연료는 30으로 고정
		 *  this.fuel = 30;
		 *  }
		 *  메서드
		 *  @오버라이딩
		 *  시동켜짐(지문으로 켜짐) 
		 *  시동꺼짐(지문으로 꺼짐)
		 *  루프열림()
		 *  루프닫힘()
		 *  차량정보출력(루프상태만 추가)
		 *  
		 *  @오버라이딩
		 *  시동켜짐(지문으로 켜짐)
		 *  void on() {	
		 *  System.out.println("지문으로 시동이 켜졌습니다");
		 *  } 
		 *  시동꺼짐(지문으로 꺼짐)
		 *  void off() {
		 *  System.out.println("지문으로 시동이 꺼졌습니다");
		 *  }
		 *  차량정보출력(루프만 추가) {
		 *   System.out.println("브랜드: "+this.name+" 모델: "+this.model+" 색깔: "+this.color
		 *	+" 가격: "+this.price+"+"루프: " +this.roof);
		 *	}
		 *  
		 *  1. 차량구매
		 *  2. 차량전체출력
		 *  3. 제일 비싼 차 출력
		 *  4. 연료 충전
		 *  	4-1. 전기차만 출력후 베터리 입력받은 만큼 충전
		 *  	4-2. 연료차 출력후 연료 입력받은 만큼 충전 
		 *  5. 슈퍼카 타입만 출력 후 지붕 열기
		 *  6. 차량 매각
		 *  0. 프로그램 종료
		 *  배열생성
		 *  
		 *  Car[] car = new Car[3];
		 *  int index =0;
		 *  int answer  ;
		 *  CRUD
		 *  C 
		 *  
		 *  차량구매(하위메뉴로 일반차, 전기차, 슈퍼카 중구매)
		 *  String[] saveAns;
		 *	System.out.println("어떤 차량을 구매하시겠습니까?")
		 *	System.out.println("1. 일반차 2. 전기차 3. 슈퍼카");
		 *	answer = sc.nextInt(); 
		 *	if (1번이라면) {
		 *		String[] msg = 
		 *			{"브랜드를 입력하세요", "색깔을 입력하세요",
		 *			 "모델을 입력하세요", "가격을 입력하세요"}
		 *		 saveAns = new String[4];
		 *		for(int i = 0; i<msg.length; i++){
		 *			System.out.println(msg[i]);
		 *			saveAns[i] = sc.next();
		 *	}
		 *	car[index]=new Car(saveAns[0],saveAns[1],saveAns[2],saveAns[3]);
		 *	if(2번이라면){
		 *			String[] msg = 
		 *			{"브랜드를 입력하세요", "색깔을 입력하세요",
		 *			 "모델을 입력하세요", "가격을 입력하세요"}
		 *		 saveAns = new String[4];
		 *		for(int i = 0; i<msg.length; i++){
		 *			System.out.println(msg[i]);
		 *			saveAns[i] = sc.next();
		 *	}
		 *	car[index]=new Elec(saveAns[0],saveAns[1],saveAns[2],saveAns[3]);
		 *	
		 *	if(3번이라면?){
		 *			String[] msg = 
		 *			{"브랜드를 입력하세요", "색깔을 입력하세요",
		 *			 "모델을 입력하세요", "가격을 입력하세요"}
		 *		 saveAns = new String[4];
		 *	for(int i = 0; i<msg.length; i++){
		 *			System.out.println(msg[i]);
		 *			saveAns[i] = sc.next();
		*	}
		*	car[index]=new superCar(saveAns[0],saveAns[1],saveAns[2],saveAns[3]);
		*	index++
		*	2. 차량전체출력
		*	지금까지 저장되어 있는 car를 출력
		*	for(int i =0; i<index; i++){
		*	 car[i].printInfo();
		*	
		*	3.제일 비싼차 출력
		*	저장되어 있는 구매한 치 중에서 출력
		*	   가격들을 다 가져와서 최대값을 구하고
		*		int maxIndex = 0;
		*		for(int a=1; a<index; a++){
		*			if(Integer.parseInt(car[a].price) > Integer.parseInt(car[maxIndex].price)){
		*				maxIndex=a;
		*			}
		*		}
		*		String maxPrice = car[macIndex].price;
		*		
		*		for(int i = 0; i<index; i++){
		*			if((car[i].price).equals(maxPrice)){
		*				
		*			}
		*		}
		*		
		*	 
		*	   차량 타입에 따른 충전 배터리 확인
		*	if(너는 전기차니?){
		*		if(batter<100){
		*			배터리 충전
		*		}else{
		*			이미 충전이 완료된 차량입니다 출력
		*		}
		*	}else{    전기차가 없다면
		*		전기차가 없습니다 출력
		*	}
		*	if(너는 슈퍼카 또는 일반차량이니?){    a instanceof SuperCar || ainstanceof Car
		*		if(fuel<100){
		*			연료 충전 안내 문구 출력
		*		}else{
		*			이미 연료가 가득찼습니다	출력	
		*		}
		*	}else{
		*		주유차량이 아닙니다 차량종류를 다시 확인 해주세요 출력
		*	}
		*	
		*	
		* 슈퍼카 뚜껑 유무
		*			
		*	if(너는 슈퍼카니?){
		*  뚜껑이 닫혀있으면 열어주고 열려있으면 닫아주는 		
		*	if(!roof){
		*		뚜껑 열어줘;
		*		roof = true;
		*	}else{
		*		뚜껑 닫아줘;
		*		roof = false;
		*		}
		*	}
		*	
		*	   차량 매각
		*		제일 최근에 구매한 차량을 매각합니다
		*	index--;
		*		
		*	
		*	  차량구매
		*	  System.out.println("어떤 차량을 구매하시 
		*	  R
		*	  차량전체정보출력
		*	  차량1개정보출력
		*	  보유하고 있는것 중에 제일비싼차조회
		*	  
		*	  U
		*	  전기차타입만 출력후 베터리 완충
		*	  연료타입만 출력후 연료 완충 
		*	   
		*	  D 
		*	  차 매각
		*	  
		*	 
		*/
		
	}
}
