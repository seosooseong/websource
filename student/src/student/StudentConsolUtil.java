package student;

import java.util.List;
import java.util.Scanner;


public class StudentConsolUtil {
	
	public Student NewStudent(Scanner sc) {
		
		//정보 입력 받기
		System.out.println("---- 새로운 학생 정보 입력 ----");
		
		System.out.print("학 번 : " );
		int code =sc.nextInt();
		
		System.out.print("이 름: " );
		String name =sc.next();
		
		System.out.print("학 년: " );
		int grade =sc.nextInt();
		
		System.out.print("주 소: " );
		String addr =sc.next();
		
		System.out.print("생 일(예시: 05/11) : " );
		String birth =sc.nextLine();
		
		sc.next();
		
	
		return new Student(code, name, grade, addr, birth);
	}


	
	public void AddSuccessMessage(Student student) {
		System.out.println(student.getName() +"학생 정보가 입력되었습니다.");
	}
	

	public void StudentAllList(List<Student> list) {
		
		System.out.println("---- 학생 정보 보기 ----");
		System.out.println("학 번     이 름     학 년");
		System.out.println("------------------------");
		
		for(Student student:list) {
			System.out.printf("%4d",student.getCode());
			System.out.printf("%9s",student.getName());
			System.out.printf("%6d",student.getGrade());
			System.out.println();
		}
	}
	
	
	
		public Student SearchStudent(Scanner sc,List<Student> list) {
		
		System.out.println("검색하고자 하는 학생 번호를 입력하세요 ");
		int code1 = sc.nextInt();
		
		Student student = null;
		for(int i=0; i<list.size(); i++) {
			student = list.get(i);
			
			if(student.getCode() == code1) {
				System.out.println("---- 학생 개별 조회 ----");
				System.out.printf("이름 : %d",student.getName());
				System.out.printf("학년 : %s",student.getCode());
				System.out.printf("주소 : %d",student.getName());
				System.out.printf("생일 : %d",student.getBirth());
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
