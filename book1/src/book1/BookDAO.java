package book1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	// 커넥션 //crud
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 커넥션
	public Connection getConnection() {
		//
		//
		Connection con = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password = "12345";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// CRUD
	// 1.추가: BOOK insert
	// insert into bookTBL Values(1001, '이것이 자바다', '신용균', 28000);
	public int bookInsert(int code,String title, String writer, int price) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql ="insert into bookTBL Values(?,?,?,?)";
			pstmt=con.prepareStatement(sql); //보내주고
			
			pstmt.setInt(1,code);
			pstmt.setString(2, title);
			pstmt.setString(3, writer);
			pstmt.setInt(4, price);
			
			result = pstmt.executeUpdate(); //업데이트
			
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
	}//insert(추가)
	
	
	//2.전체조회
	public List<BookVO> getList(){
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			String sql = "select * from booktbl order by code desc"; //정렬까지~
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 여러개 나와서  while
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("Price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}//getlist end.
	
	//3.삭제: delete form booktbl where code=?
	
	public int bookDelete(int code) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "delete from bookTBL where code =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);// 받은거 위에 int code
			result = pstmt.executeUpdate();
			
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
	}//delete end.
	
	//수정
	public int bookUpdate(int code, int price) {
		//update bookTBL set price=? where code =?
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		int result=0;
		
		try {
			String sql = "update from bookTBL set price=? where code =?";
			pstmt.setInt(1, price);
			pstmt.setInt(2, code);
			result = pstmt.executeUpdate();
			
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
		
	}//업데이트 end
	
	//검색
	
	public List<BookVO> bookSearch(String criteria, String keyword) {
		//코드가 2001 번호를 검색하기
		//select * from bookTBL where code =?
		//select * from bookTBL where  ? =? 필드명 ?안됨 무조건 작성!
		
		//작가가 홍길동 번호를 검색하기
		//select * from booktbl where writer ='홍길동'
		
		//String sql ="select * from bookTBL where "+ criteria +"=?";
		
		
		Connection con =getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="";
		List<BookVO>list = new ArrayList<BookVO>();
		try {
			if(criteria.equals("code")) {
				sql="select * from bookTBL where code =?";
				pstmt= con.prepareStatement(sql);		
				pstmt.setInt(1,Integer.parseInt(keyword)); //code
			}else {
				sql="select * from booktbl where writer =?";
				pstmt= con.prepareStatement(sql); //writer
				pstmt.setString(1,keyword);
			
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //장바구니 담아주기
				BookVO vo = new BookVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return list;
	} 
	
	
	
	
	
	
	
}
