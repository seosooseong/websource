package persistence;

import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.BookVO;

public class BookDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BookDAO (Connection con) {
		this.con=con;
	}

	// CRUD
	// 1.추가: BOOK insert
	// insert into bookTBL Values(1001, '이것이 자바다', '신용균', 28000);
	public int bookInsert(BookVO vo) {

		int result = 0;
		try {
			String sql ="insert into bookTBL Values(?,?,?,?)";
			pstmt=con.prepareStatement(sql); //보내주고
			
			pstmt.setInt(1,vo.getCode());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3,vo.getWriter());
			pstmt.setInt(4, vo.getPrice());
			
			result = pstmt.executeUpdate(); //업데이트
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
				
		}
		return result;
	}//insert(추가)
	
	
	//2.전체조회
	public List<BookVO> getList(){
	
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
				close(pstmt);
				close(rs);

		}
		return list;
	}//getlist end.
	
	//3.삭제: delete form booktbl where code=?
	
	public int bookDelete(int code) {
		
		int result = 0;
		
		try {
			String sql = "delete from bookTBL where code =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);// 받은거 위에 int code
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(pstmt);
				
			
		}
		return result;
	}//delete end.
	
	//수정
	public int bookUpdate(BookVO vo) {
		//update bookTBL set price=? where code =?
		
		int result=0;
		
		try {
			String sql = "update from bookTBL set price=? where code =?";
			pstmt.setInt(1, vo.getPrice());
			pstmt.setInt(2, vo.getCode());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
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
			
			
				close(pstmt);
				close(rs);
			
			
		}return list;
	} 
	
	
	
	
	
	
	
}
