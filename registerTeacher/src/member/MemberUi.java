package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberUi {

	public static void main(String[] args) {
	
		//3. 정지하기 위한 변수 isStop = false
		boolean isStop = false; //반복문 종료
		
		Scanner sc = new Scanner(System.in); //4. 키보드에서 받는다.
		
		
		MemberConsoleUtil util = new MemberConsoleUtil(); // 6.MemberConsoleUtil 사용할 메소드!
		
		List<Member> list = new ArrayList<Member>(); //case1을 위한 멤버 리스트
		
		//1.메뉴 출력
		do { //2.반복 do ~while
			System.out.println("==== 회원관리 프로그램 ====");
			System.out.println("1. 회원등록");
			System.out.println("2. 회원목록보기");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원정보삭제");
			System.out.println("5. 프로그램 종료");
			System.out.println("메뉴번호 : ");
			//5.사용자에게 번호 입력 (int menu 변수에 담고)
			int menu = sc.nextInt(); 
			
			//메뉴번호에 따라 출력문 제시
			
			switch (menu) {
				case 1: //등록
					Member member = util.getNewMember(sc);
					list.add(member); //리스트
					util.printAddSuccessMessage(member);//성공메세지
					break;
				case 2: //목록보기
					util.printMemberList(list);
					break;
				case 3: //수정
					member =util.getUpdateMember(sc, list);
					if(member==null) {
						util.printModifyFailMessage();
					}else {
						util.printModifySuccessMessage();
					}
					break;
				case 4: //삭제
					member =util.RemoveMember(sc, list);
					if(member==null) {
						util.printRemoveFailMessage();
					}else {
						util.printRemoveSuccessMessage();
					}
					break;
				case 5: //종료
					System.out.println("종료");
					isStop = true; //종료하기
					break;
	
				default:
					break;
				}

		} while(!isStop); //isStop이 true가 아닐때까지
		
	
	}

}
