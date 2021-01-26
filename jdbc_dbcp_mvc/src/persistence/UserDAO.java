package persistence;

/*import static persistence.JDBCUtil.close;
*/
import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.UserVO;

public class UserDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO(Connection con) {
		this.con=con;
	}
	
	//CRUD
	//insert
	public int insert(String username, String birthyear, String addr, String mobile) {
						//addpro에서 받을거 써준다. 타입_변수명 까지 써준다.
		
		int result =0;
		try {
			if(con!=null){
				//4.sql구문 생성
				String sql = "insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";
							
				//5.Statement 생성후 전송
				pstmt = con.prepareStatement(sql);
				
				// ? 에 해당 값을 세팅
				pstmt.setString(1, username);	//1번 ?물음표 에 넣어줘
				pstmt.setInt(2, Integer.parseInt(birthyear));
				pstmt.setString(3, addr);
				pstmt.setString(4, mobile);
						
				//6.sql 구문 실행 결과
				result = pstmt.executeUpdate();
				//결과를 addPro에 넘겨준다.
			}
		}catch(Exception e){
			e.printStackTrace(); 
			}finally{//자원을 닫음.
				close(pstmt);
			}
		return result;
	}//insert end
	
	//read
	//전체조회

		public List<UserVO> select() {
			
			List<UserVO> list = new ArrayList<UserVO>(); //박스2 list
			
			try {
				if(con!=null){
					//4.sql 구문 생성
					String sql ="select * from userTBL order by no desc";
					//5.Statement 생성 후 전송 : DB연결을 통해 sql문 수행해 주는 클래스
					pstmt = con.prepareStatement(sql);
					//6.sql 구문 실행 - select 구문 excuteQuery() -> ResultSet
					//  			  - insert, update, delete executeUpdate() -> int
					rs =pstmt.executeQuery();
				while(rs.next()){
					//UserVO 객체를 생성
					UserVO user = new UserVO(); //박스1 만들고 -> 아래 담기 user.set
					user.setNo(rs.getInt(1)); //no는 number 타입 -> int로 가져온다.
					user.setUsername(rs.getString(2)); // userName nchar
					user.setBirthyear(rs.getInt(3)); // birthYear number
					user.setAddr(rs.getString(4)); // addr nchar
					user.setMobile(rs.getString(5)); // mobile nvarchar2
					list.add(user); //박스2 list 담기
					
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;	
	}
	//개별조회
	public UserVO getUser(int no) {	
		
		UserVO user = null;
		try{
			//데이터베이스(DB) 접속 후 사용자의 no에 해당하는 정보 가져오기
		
			if(con!=null){
				//sql구문 전송
				String sql = "select * from userTBL where no=?"; //? 사용자의 입력값으로 대치
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				//sql실행
				rs = pstmt.executeQuery();
				if(rs.next()){
					user = new UserVO();
					user.setNo(rs.getInt("no"));
					user.setUsername(rs.getString("username"));
					user.setAddr(rs.getString("addr"));
					user.setBirthyear(rs.getInt("birthyear"));
					user.setMobile(rs.getString("mobile"));
				}//if
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
				close(rs);
				close(pstmt);
		}
		return user;
	}
	public int deleteUser(int no) {
		
		int result = 0;
		
		try{//no에 해당하는 user삭제

			if(con!=null){
				//삭제가 성공하면 index.jsp 로 이동
				String sql = "delete from userTBL where no =?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);// 받은거 위에 int no
				result = pstmt.executeUpdate();

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);

		}
		return result;

	}
	//업데이트
	public int updateUser(int no, String addr, String mobile) {
			int result = 0;
			UserVO user = null;
				try{		
				if (con != null){
					String sql ="update userTBL set addr= ? , mobile =? where no=?";
					pstmt = con.prepareStatement(sql);

					pstmt.setString(1, addr);
					pstmt.setString(2, mobile);
					pstmt.setInt(3, no);
					result = pstmt.executeUpdate();
				}
			
			}catch(Exception e){	
				e.printStackTrace();
			}finally{
				close(pstmt);

			}
		return result;
	}
}
