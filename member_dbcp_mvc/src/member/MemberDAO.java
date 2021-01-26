package member;

import java.net.http.HttpConnectTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.management.remote.JMXConnectionNotification;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	//dbcp
	
	public Connection getConnection(){
	//2.데이터 베이스 연결을 위한 문자열 생성
	//3.커넥션
	Connection con = null;
	try {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
		con= ds.getConnection();
	} catch (Exception e) {
		e.printStackTrace();
	}
	//return null;	
	return con;
	}
	//로그인 -> userid, password가 일치하면 
	//select userid, name from member1 where userid=? and password=?
	public MemberVO isLogin(String userid, String password){
		
			Connection con = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			MemberVO member = null;
			try {
				String sql = "select userid, name from member1 where userid=? and password=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);// 받은거 위에 int code
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member = new MemberVO();
					member.setUserid(rs.getString("userid"));
					member.setName(rs.getString("name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return member;
			
	}//로그인end
	
	//회원가입
	//"insert into member1(userid,password,name,gender, email) Values(?,?,?,?,?)" 
	//"insert into member1 Values(?,?,?,?,?)" 필드명 필수는 아니지만 명시
	
	public int register(MemberVO member) {
			Connection con = getConnection();
			PreparedStatement pstmt = null;
			int result= 0;
			
			try {
				String sql ="insert into member1(userid,password,name,gender,email) Values(?,?,?,?,?)";
				pstmt=con.prepareStatement(sql); //보내주고
				pstmt.setString(1, member.getUserid());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getGender());
				pstmt.setString(5, member.getEmail());
				
				result = pstmt.executeUpdate(); //업데이트
				
			} catch (Exception e) {
					e.printStackTrace();
			}finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return result;
	}//가입 end
	
	//비밀번호 변경
	//update member1 set password = ?(새로운비번) where userid = userid
	public int updateMember(String userid, String password) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "update member1 set password = ? where userid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, userid);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}//변경 end
	
	//삭제 
	//delete from member1 where userid =? 
	public int leaveMember(String userid, String password) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql="delete from member1 where userid =? and password =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	//중복아이디
	public boolean checkID(String userid) {
		
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select userid from member1 where userid =?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
		
		
		
	}
}
































