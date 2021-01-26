package persistence;

import static persistence.JDBCUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.ProductVO;



public class ProductDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ProductDAO(Connection con) {
		this.con = con;
	}
	
	public int insertProd(ProductVO vo)  {

			int result = 0;

			try {
				
				String sql = "insert into productTbl(num,category,name, content, psize,color,amount,price,date) "
						+ "values(seq_board.nextval,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql); // 보내고
				
				pstmt.setString(1, vo.getCategory());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getContent());
				pstmt.setString(4, vo.getPsize());
				pstmt.setString(5, vo.getColor());
				pstmt.setInt(6, vo.getAmount());
				pstmt.setDate(7, vo.getRedate());
				
				result = pstmt.executeUpdate(); // 업데이트

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}//
		
	//조회
		public List<ProductVO> getList(){
		
			List<ProductVO> list = new ArrayList<ProductVO>();
			try {
				String sql = "select * from productTbl order by num desc"; 
				pstmt=con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				// 여러개 나와서  while
				while(rs.next()) {
					ProductVO vo = new ProductVO();
					vo.setNum(rs.getInt("num"));
					vo.setCategory(rs.getString("category"));
					vo.setName(rs.getString("name"));
					vo.setPrice(rs.getInt("price"));
					vo.setAmount(rs.getInt("amount"));
					vo.setRedate(rs.getDate("redate"));

					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
					close(pstmt);
					close(rs);

			}
			return list;
		}// end.		
		
 }		
	


