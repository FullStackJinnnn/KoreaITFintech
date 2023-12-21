package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.DogfoodDTO;

public class VIEW {
	private Scanner sc;

	public VIEW() {
		sc = new Scanner(System.in);
	}

	public void printDatas(ArrayList<DogfoodDTO> datas) {
		for (DogfoodDTO data : datas) {
			System.out.println("[" + data.getBid() + "]  " + data.getTitle() + "   " + data.getPrice());
		}
	}

	public void printMenu() {
		System.out.println("0. 종료");
		System.out.println("1. 로그인");
		System.out.println("2. 로그아웃");
		System.out.println("3. 글 작성");
		System.out.println("4. 글 목록 출력");
		System.out.println("5. 글 내용 보기");
	}

	public int inputAction() {
		System.out.print("번호입력 >> ");
		return sc.nextInt();
	}

	public void printTrue() {
		System.out.println("성공!");
	}

	public void printFalse() {
		System.out.println("실패...");
	}

	public String inputString() {
		System.out.println("제목, 컨텐츠 입력 >>");
		return sc.next();
	}
}
