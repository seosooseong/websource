package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.PageVO;
import domain.SearchVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor

public class BoardListAction implements Action {
	
	private String path;
	
	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//  /qList.do?page=2&criteria=title&keyword=테스트

		//페이지 나누기 추가
		int page =1;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		int amount=10;	//1페이지당 보여줄 게시물 수	
		
		//검색기능 추가 + 페이지 나누기 값;
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		

		SearchVO searchVO = new SearchVO();
		searchVO.setCriteria(criteria);
		searchVO.setKeyword(keyword);
		searchVO.setPage(page);
		searchVO.setAmount(amount);
		
		
		// 서비스 요청
		BoardService service = new BoardServiceImpl();
		
		//페이지 번호에 맞는 리스트 가져오기
		List<BoardVO> list = service.getList(searchVO);
		
		//전체 행 수 가져오기
		service =new BoardServiceImpl();
		int totalRow = service.getRows(criteria,keyword);
		
		PageVO info = new PageVO(totalRow, searchVO);

		//요청후 받은 결과 담기
		request.setAttribute("list", list);	

		//search - 검색어, 검색기준 
		request.setAttribute("info", info);
		
		//이동방식 결정
		return new ActionFowrd(path, false);
	}

}
