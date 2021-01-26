package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BoardVO;
import domain.SearchVO;

import static persistence.JDBCUtil.*;

public class BoardDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO (Connection con) {
		this.con=con;
	}
	
	//CRUD
	public int insert(BoardVO vo) {

		String sql ="insert into board (bno, name, password, title, content,"
				+ "attach,re_ref,re_lev, re_seq) "
				+ "values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0)";
		
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
	
			// ? 에 해당 값을 세팅
			pstmt.setString(1, vo.getName());	
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getAttach());
					
			//sql 구문 실행 결과
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public List<BoardVO> selectAll(){
		String sql = "select bno,title,name,regdate,readcount,re_lev from board order by re_ref desc, re_seq asc"; //최신글
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRe_lev(rs.getInt("re_lev"));
				list.add(vo);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
			close(con);
			close(pstmt);
		}
		return list;
	
	}
	//검색기능
	
	public List<BoardVO> searchAll(SearchVO searchVO){
		
		List<BoardVO> search = new ArrayList<BoardVO>();
		
		String sql ="select bno,title,name,regdate,readcount,re_lev from board ";
				sql+= "where "+searchVO.getCriteria()+"like ? order by re_ref desc, re_seq asc"; 
							//필드명은 ? 못씀. 정확하게!
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchVO.getKeyword()+"%");
			rs =pstmt.executeQuery();
	
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRe_lev(rs.getInt("re_lev"));
				search.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return search;
			
	}
	
	//특정 번호 내용 조회
	public BoardVO select(int bno) { //? 받는다.
							//pk bno까지는 끌고 나와야 한다.
														//re_ref,re_lev,re_seq reply 에서 필요 
		String sql = "select bno,name,title,content,attach,re_ref,re_lev,re_seq from board where bno =?";
		
		BoardVO vo = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setAttach(rs.getString("attach"));
				//reply 에서 필요한 값
				vo.setRe_ref(rs.getInt("re_ref"));
				vo.setRe_lev(rs.getInt("re_lev"));
				vo.setRe_seq(rs.getInt("re_seq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;

	}
	// 조회수 업데이트
	
	public int readCountUpDate(int bno) {
		String sql ="update board set readcount = readcount+1 where bno=?";
		
		int result =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//삭제
	
	public int delete (int bno, String password ) {
		
		String sql ="delete from board where bno = ? and password = ?";
		int result =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	//수정
	public int update(BoardVO vo) {
		int result = 0;
		String sql ="";
		try {
			if(vo.getAttach() !=null) { //제목, 내용, 파일
				sql ="update board set title= ?, content =?, attach =? where bno=? and password=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getAttach());
				pstmt.setInt(4, vo.getBno());
				pstmt.setString(5, vo.getPassword());
			}else { ////제목, 내용
				sql ="update board set title= ? , content =? where bno=? and password=?";
				pstmt = con.prepareStatement(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getBno());
				pstmt.setString(4, vo.getPassword());
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}//
	
	
	//댓글(리플)
	
	public int reply(BoardVO vo) {
		
		int result =0;
		
		try {
			//1.원본글 정보 가져오기
			int re_ref = vo.getRe_ref();
			int re_seq = vo.getRe_seq();
			int re_lev = vo.getRe_lev();
			//2.원본글에 달려있는 기존 댓글을 업데이트
			String sql="update board set re_seq = re_seq+1 where re_ref=? and re_seq > ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			
			if(updateCount >0) { //업데이트가 되면 커밋이 필요!
				commit(con);
			}
			close(pstmt); //닫아주고
			
			//3.댓글 삽입.
			sql ="insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq) "
					+ "values(board_seq.nextval,?,?,?,?,null,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setInt(5, re_ref);
			pstmt.setInt(6, re_lev+1); 
			pstmt.setInt(7, re_seq+1); 
			result =pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	

	
	
}
