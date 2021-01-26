package member;

import java.util.Scanner;



public class MemberConsoleUtil {
	
	
	private final int MAX_INT=30;
	Member[] parr = new Member[MAX_INT];
	private	int cnt;
	public void NewMember() {
		System.out.println("선수정보 입력해 주세요");
		System.out.print("아이디 : ");
		String id = MemberUI.key.next();
		System.out.print("이름 : ");
		String name = MemberUI.key.next();
		System.out.print("주소 : ");
		String addr = MemberUI.key.next();
		System.out.print("이메일 : ");
		String email = MemberUI.key.next();
		System.out.print("국가 : ");
		String nation = MemberUI.key.next();
		System.out.print("나이 : ");
		int age = MemberUI.key.nextInt();
		
		

		parr[cnt] = new Member(nation, nation, nation, nation, nation, age);
		parr[cnt].setId(id);
		parr[cnt].setName(name);
		parr[cnt].setAddr(addr);
		parr[cnt].setEmail(email);
		parr[cnt].setNation(nation);
		parr[cnt].setAge(age);
		cnt++;
		}
	
	public void viewMember() {
		System.out.println("아이디\t아름\t주소\t이메일\t국가");
		for(int  i=0; i<parr.length ; i++) {
			if(parr[i]==null)break;
			System.out.print(parr[i].getId()+"\t");
			System.out.print(parr[i].getName()+"\t");
			System.out.print(parr[i].getAddr()+"\t");
			System.out.print(parr[i].getEmail()+"\t");
			System.out.println(parr[i].getNation()+"\t");
			System.out.println(parr[i].getAge()+"\t");
		}
	}
}
