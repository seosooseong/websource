package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static persistence.JDBCUtil.*; //JDBCUtil 모든것을 가져올거야.

public class MemberDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	
	public int insert(String name) {
		int result =0;
		
		try {
			pstmt=con.prepareStatement("insert into member1 values()");
					
		} catch (Exception e) { //아니면 롤백
			e.printStackTrace();
		}finally {
			close(pstmt); // JDBCUtil
			
		}
		return result;
	}

	public int delete(String name) {
		System.out.println("memberDAO delete : " +name);
		return 1;
	}
	
}
