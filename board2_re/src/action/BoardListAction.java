package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor

public class BoardListAction implements Action {
	
	private String path;
	
	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	

		// 서비스 요청
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.getList();
		
		//요청후 받은 결과 담기
		request.setAttribute("list", list);	
		
		//이동방식 결정
		return new ActionFowrd(path, false);
	}

}
