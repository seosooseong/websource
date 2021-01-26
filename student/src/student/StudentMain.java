package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		
		boolean isStop = false; 
		
		Scanner sc = new Scanner(System.in); 
		
		StudentConsolUtil util = new StudentConsolUtil();
		
		
		List<Student> list = new ArrayList<Student>();
		
		do { //반복
			System.out.println("--------- <학생 정보 관리 프로그램> ---------");
			System.out.println("\t1. 학생정보 입력");
			System.out.println("\t2. 학생정보 전체 조회");
			System.out.println("\t3. 학생정보 개별 조회");
			System.out.println("\t4. 프로그램 종료");
			System.out.print("\t선택 : ");
			
			//사용자 번호 입력 
			int select = sc.nextInt(); 
			
			
			switch (select) {
				case 1: //등록
					Student student = util.NewStudent(sc);
					list.add(student);
					util.AddSuccessMessage(student);
					break;
				case 2: //전체
					util.StudentAllList(list);
					break;
				case 3: //개별
					util.SearchStudent(sc, list);
					break;
				case 4: //종료
					System.out.println("종료");
					isStop = true; //종료하기
					break;
	
				default:
					break;
				}

		} while(!isStop); 
		
	
	}

}
