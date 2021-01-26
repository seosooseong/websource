package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.SearchVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor
public class BoardReplyViewAction implements Action {
	
	private String path;
	
	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int bno = Integer.parseInt(request.getParameter("bno"));
		//페이지 나누기 후 넘어오는 값들.
		SearchVO searchVO = new SearchVO();
		searchVO.setPage(Integer.parseInt(request.getParameter("page")));
		searchVO.setCriteria(request.getParameter("criteria"));
		searchVO.setKeyword(request.getParameter("keyword"));
		
		BoardService service = new BoardServiceImpl();
		BoardVO vo = service.getRow(bno);
		
		request.setAttribute("vo", vo);
		request.setAttribute("searchVO", searchVO);
		
		return new ActionFowrd(path, false);
	}

}
