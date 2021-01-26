package service;

import java.sql.Connection;
import java.util.List;

import domain.ProductVO;
import persistence.ProductDAO;

import static persistence.JDBCUtil.*;

public class ProdServiceImpl implements ProdService {

	private ProductDAO dao;
	private Connection con;

	public ProdServiceImpl() {
		con = getConnection();
		dao = new ProductDAO(con);
	}

	@Override
	public boolean insertProd(ProductVO vo) {
		int result =dao.insertProd(vo);
		
		boolean insertFlag = false;
		
		if(result>0) {
			commit(con);
			insertFlag=true;
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}
	

	@Override
	public List<ProductVO> getList() {
		List<ProductVO> list = dao.getList();
		close(con);
		return list;
	}

}
