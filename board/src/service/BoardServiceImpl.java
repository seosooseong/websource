package service;

import java.sql.Connection;
import java.util.List;

import domain.BoardVO;
import domain.SearchVO;
import persistence.BoardDAO;
import static persistence.JDBCUtil.*;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao;
	private Connection con;
	
	public BoardServiceImpl() {
		con = getConnection();
		dao=new BoardDAO(con);
	}
	
	@Override
	public boolean insertArticle(BoardVO vo) {
		
		boolean insertFlag = false;
		
		int result = dao.insert(vo);
		
		if(result>0) {
			commit(con);
			insertFlag = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return insertFlag;
	}

	@Override
	public boolean updateArticle(BoardVO vo) {
		
		boolean updateFlag = false;
		
		int result = dao.update(vo);
		
		if(result>0) {
			commit(con);
			updateFlag = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return updateFlag;
	}

	@Override
	public boolean deleteArticle(int bno, String password) {
	
		boolean deleteFlag = false;
		
		int result = dao.delete(bno, password);
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
	public List<BoardVO> getList(SearchVO searchVO) {
		//List<BoardVO> list = dao.selectAll();
		List<BoardVO> list = dao.getList(searchVO);
		close(con);
		return list;
	}

	@Override
	public BoardVO getRow(int bno) {
		BoardVO vo =dao.select(bno);
		close(con);
		return vo;
	}

	@Override
	public boolean hitUpdate(int bno) {
		boolean updateFlag = false;
		
		int result = dao.readCountUpDate(bno);
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
	public boolean insertReply(BoardVO reply) {
		boolean replyFlag = false;
		
		int result = dao.reply(reply);
		if(result>0) {
			commit(con);
			replyFlag=true;
		}else {
			rollback(con);
		}
		close(con);
		return replyFlag;
	}

	@Override
	public int getRows(String criteria,String keyword) {
		int totalRow = dao.totalRows(criteria,keyword);
		close(con);
		return totalRow;
				

	}

//	@Override
//	public List<BoardVO> searchList(SearchVO searchVO) {
//		List<BoardVO> search = dao.searchAll(searchVO);
//		close(con);
//		return search;
//
//	}

}
