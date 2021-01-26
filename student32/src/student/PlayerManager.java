package student;

import java.util.Scanner;

public class PlayerManager {
	
		private final int MAX_INT=30;
		Player[] parr = new Player[MAX_INT];
		private	int cnt;
		public void insertData() {
			System.out.println("선수정보 입력해 주세요");
			System.out.print("이름 : ");
			String name = PlayerMain.key.next();
			System.out.print("주소 : ");
			String address = PlayerMain.key.next();
			System.out.print("나이 : ");
			int age = PlayerMain.key.nextInt();
			System.out.print("키 : ");
			int height = PlayerMain.key.nextInt();
			System.out.print("몸무게 : ");
			int weight = PlayerMain.key.nextInt();
			
//			parr[cnt] = new Player(name,address,age,height,weight);
			parr[cnt] = new Player();
			parr[cnt].setName(name);
			parr[cnt].setAddress(address);
			parr[cnt].setAge(age);
			parr[cnt].setHeight(height);
			parr[cnt].setWeight(weight);
			cnt++;
			}
		public void viewData() {
			System.out.println("선수명\t주소\t나이\t키\t몸무게");
			for(int  i=0; i<parr.length ; i++) {
				if(parr[i]==null)break;
				System.out.print(parr[i].getName()+"\t");
				System.out.print(parr[i].getAddress()+"\t");
				System.out.print(parr[i].getAge()+"\t");
				System.out.print(parr[i].getHeight()+"\t");
				System.out.println(parr[i].getWeight()+"\t");
			}
		}

		public void searchData() {//동명이인 없음
			System.out.println("선수찾기");
			System.out.print("선수이름");
			String find = PlayerMain.key.next();
			Player p = search(find);
			if(p==null) {
				System.out.println("찾는 선수 없음");
			}
			System.out.println("선수명\t주소\t나이\t키\t몸무게");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getHeight()+"\t");
			System.out.println(p.getWeight()+"\t");
				}
		private Player search(String find) {
			for(int i = 0 ; i<cnt ; i++) {
				if(find.equals(parr[i].getName())) {
					return parr[i];
				}
			}
			return null;
		}
	}
