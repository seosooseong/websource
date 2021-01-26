package member;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleUtil {
	
		 //Member 담기
	public Member getNewMember(Scanner sc) {
		
		//정보 입력 받기
		System.out.println("등록할 회원의 정보를 입력하세요.");
		
		System.out.print("아이디 : " );
		int id =sc.nextInt();
		System.out.print("이름: " );
		String name =sc.next();
		System.out.print("주소: " );
		String addr =sc.next();
		System.out.print("이메일: " );
		String email =sc.next();
		System.out.print("국가: " );
		String nation =sc.next();
		System.out.print("나이 : " );
		int age =sc.nextInt();
		
		
		
		
		return new Member(id, name, addr, nation, email, age);
		//1. 일단 빨간줄 없애주고

	}
	//회원정보 성공메세지
	public void printAddSuccessMessage(Member member) {
		System.out.println(member.getName() +"회원 정보 추가성공");
	}
	
	
	
	
	public void printMemberList(List<Member> list){
		System.out.println("회원아이디\t이름\t\t주소\t\t이메일\t\t\t국가\t\t나이");
		
		for(Member member:list) {
			System.out.printf("%6d",member.getId());
			System.out.printf("%13s",member.getName());
			System.out.printf("%8s",member.getAddr());
			System.out.printf("%18s\t",member.getEmail());
			System.out.printf("%6s\t",member.getNation());
			System.out.printf("%5d",member.getAge());
			System.out.println();
		}
	}
	
	public Member getUpdateMember(Scanner sc, List<Member>list) {
		System.out.println("수정할 회원 아이디를 입력하세요 : ");
		int id =sc.nextInt();
		
		//아이디가 있다면 수정 
		Member member = null;
		for(int i=0; i<list.size(); i++) {
			member = list.get(i); //리스트에서 i번째 가지고 올것이다.
			if(member.getId() == id) { //입력한 아이디가 같다면.
				System.out.println("수정할 주소를 입력하세요");
				String addr = sc.next();
				System.out.println("수정할 이메일을 입력하세요");
				String email = sc.next();
				
				//입력받은 값을 변경한 후 리턴.
				member.setAddr(addr);
				member.setEmail(email);
				return member;
			}
		}
		return null;
	}
	public void printModifySuccessMessage() {
		System.out.println("회원 정보 수정성공");
	}
	public void printModifyFailMessage() {
		System.out.println("회원 정보 수정실패");
	}
	
	
	
	
	
	
	public Member RemoveMember(Scanner sc, List<Member>list) {
		System.out.println("삭제할 회원 아이디를 입력하세요 : ");
		int id =sc.nextInt();
		
		Member member = null;
		for(int i=0; i<list.size(); i++) {
			member = list.get(i); //리스트에서 i번째 가지고 올것이다.
			if(member.getId() == id) {
				System.out.println("삭제하시겠습니까? 예(1) 아니오(2)");
				int no = sc.nextInt();
				if(no==1) {
					list.remove(i); //제거
					return member;
							
				}
			}
		}
		return null;
	}
	public void printRemoveSuccessMessage() {
		System.out.println("회원 정보 삭제성공");
	}
	public void printRemoveFailMessage() {
		System.out.println("회원 정보 삭제실패");
	}
		
}
