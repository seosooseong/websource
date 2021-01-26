package member;

import java.util.Scanner;

public class MemberUI {

	public static Scanner key = new Scanner(System.in);
	//static이 붙어 있으면 다른 클래스에서 PlayerMain.key의 형태로 사용가능
	public static void member() {
		System.out.println("====회원관리 프로그램 ====");
		System.out.println("1. 회원등록");
		System.out.println("2. 회원목록보기");
		System.out.println("3. 회원정보수정");
		System.out.println("4. 회원정보삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴번호 : ");
		

	}
	public static void main(String[] args) {
		MemberConsoleUtil member = new MemberConsoleUtil();
		
		while (true) {
			MemberUI.member();
			int choice = MemberUI.key.nextInt();
		
			MemberUI.key.nextLine();
			switch(choice) {
			case 1 : member.NewMember();break;
			case 2 : member.viewMember();break;
			case 3 : break;
			case 4 : break;
			case 5 : System.out.println("종료");
				System.exit(0);
			}
		}
	}
}