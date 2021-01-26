package persistence;

import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.MemberVO;

public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public MemberVO isLogin(String userid, String password) {

		MemberVO member = null;
		try {
			String sql = "select userid, name from member1 where userid=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);// 받은거 위에 int code
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberVO();
				member.setUserid(rs.getString("userid"));
				member.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(pstmt);

		}
		return member;

	}// 로그인end

	// 회원가입
	// "insert into member1(userid,password,name,gender, email) Values(?,?,?,?,?)"
	// "insert into member1 Values(?,?,?,?,?)" 필드명 필수는 아니지만 명시

	public int register(MemberVO member) {

		int result = 0;

		try {
			String sql = "insert into member1(userid,password,name,gender,email) Values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql); // 보내주고
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getEmail());

			result = pstmt.executeUpdate(); // 업데이트

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(pstmt);

		}
		return result;
	}// 가입 end

	// 비밀번호 변경
	// update member1 set password = ?(새로운비번) where userid = userid
	public int updateMember(String userid, String password) {

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

			close(pstmt);

		}
		return result;
	}// 변경 end

	// 삭제
	// delete from member1 where userid =?
	public int leaveMember(String userid, String password) {

		int result = 0;

		try {
			String sql = "delete from member1 where userid =? and password =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(pstmt);

		}
		return result;
	}
}
