package player2;

import java.util.Scanner;

	public class PlayerMain {
		public static Scanner key = new Scanner(System.in);
		//static이 붙어 있으면 다른 클래스에서 PlayerMain.key의 형태로 사용가능
		public static void showMenu() {
			System.out.println("====회원관리 프로그램 ====");
			System.out.println("1. 등록");
			System.out.println("2. 보기");
			System.out.println("3. 찾기");
			System.out.println("4. 종료");
			System.out.println("선택 : ");
		}
		
		public static void main(String[] args) {
			PlayerManager pm = new PlayerManager();
			
			while (true) {
				PlayerMain.showMenu();
				int choice = PlayerMain.key.nextInt();
			
				PlayerMain.key.nextLine();
				switch(choice) {
				case 1 : pm.insertData();break;
				case 2 : pm.viewData(); break;
				case 3 : pm.searchData();break;
				case 4 : System.out.println("종료");
					System.exit(0);
				}
			}
		}
	}
