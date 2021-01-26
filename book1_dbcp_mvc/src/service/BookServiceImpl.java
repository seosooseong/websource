package service;

import java.sql.Connection;
import java.util.List;

import domain.BookVO;
import persistence.BookDAO;
import static persistence.JDBCUtil.*;
public class BookServiceImpl implements BookService {
	
	Connection con;
	BookDAO dao;
	
	public BookServiceImpl() {
		con=getConnection();
		dao=new BookDAO(con);
		
	}
	@Override
	public boolean insertBook(BookVO vo) {
		int result =dao.bookInsert(vo);
		
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
	public boolean updateBook(BookVO vo) {
		boolean updateFlag = false;
		
		int result = dao.bookUpdate(vo);
		
		if(result>0) {
			commit(con);
			updateFlag=true;
		}else {
			rollback(con);
		}
		close(con);
		
		return updateFlag;
	}

	@Override
	public boolean deleteBook(int code) {
		boolean deleteFlag = false;
		int result = dao.bookDelete(code);
		
		if(result>0) {
			commit(con);
			deleteFlag=true;
		}else {
			rollback(con);
		}
		close(con);
		return deleteFlag;
	}

	@Override
	public List<BookVO> getRow(String criteria, String keyword) {
		List<BookVO> list= dao.bookSearch(criteria, keyword);
		close(con);

		return list;
	}

	@Override
	public List<BookVO> getList() {
		List<BookVO> list=dao.getList();
		close(con);

		return list;
	}

}
