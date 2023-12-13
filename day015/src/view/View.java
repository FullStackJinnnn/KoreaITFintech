package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ProductDTO;

public class View {

	private Scanner sc;
	private int userMAX;
	private int adminMAX;
	public View() {
		this.sc=new Scanner(System.in);
		this.userMAX=2;
		this.adminMAX=3;
	}

	public void printMenu() {
		System.out.println("=== 자 판 기 ===");
		System.out.println("1. 메뉴목록출력");
		System.out.println("2. 메뉴선택");
		System.out.println("0. 종료");
	}
	

	
	public int inputCntUpdate() {
		System.out.print("재고변경숫자입력 >> ");
		int cntUpdate=sc.nextInt();
		return cntUpdate;
	}
	
	public String inputName() {
		System.out.print("이름입력 >> ");
		String name=sc.next();
		return name;
	}
	
	public int inputPrice() {
		System.out.print("가격입력 >> ");
		int price=sc.nextInt();
		return price;
	}
	
	public int inputCnt() {
		System.out.print("재고입력 >> ");
		int cnt=sc.nextInt();
		return cnt;
	}
	public void printAdminOut() {
		System.out.println("관리자모드를 종료합니다...");
	}
	
	public void printCntChange() {
		System.out.println("재고를 변경할 상품을 선택해주세요");
	}
	public int inputInteger() {
		System.out.print("번호입력 >> ");
		int integer=sc.nextInt();
		return integer;
	}
	public void printAdminMenu() {
		System.out.println("=== 관 리 자 ===");
		System.out.println("1. 메뉴추가");
		System.out.println("2. 메뉴재고변경");
		System.out.println("3. 메뉴삭제");
		System.out.println("0. 관리자모드 종료");
	}
	public void printDatas(ArrayList<ProductDTO> datas) {
		if(datas.size()<=0) {
			System.out.println("출력할 메뉴가 없습니다...");
			return;
		}
		for(ProductDTO data:datas) {
			if(data.getCnt()<=0) {
				System.out.println("재고없음!");
				continue;
			}
			System.out.println(data);
		}
	}
	public void printData(ProductDTO data) {
		if(data==null) {
			System.out.println("출력할 데이터가 없습니다...");
			return;
		}
		if(data.getCnt()<=0) {
			System.out.println(data.getName()+"는(은) 재고가 없습니다...");
			return;
		}
		System.out.println(data);
		System.out.println("구매완료!");
	}
	
	public void printTrue() {
		System.out.println("수행 완료 !");
	}
	public void printFalse() {
		System.out.println("수행 실패 ...");
	}
}
