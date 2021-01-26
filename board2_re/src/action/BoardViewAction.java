package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;


@AllArgsConstructor
public class BoardViewAction implements Action {
	
	
	private String path;
	
	
	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// BoardHitUpdateAction 페이지에서 넘어오는 값 가져오기
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		
		
		//서비스 요청 ->bno 에 해당 정보
		BoardService service = new BoardServiceImpl();
		BoardVO vo = service.getRow(bno);
		
		//담아야 한다.
		request.setAttribute("vo", vo);
		
		//페이지 이동
		return new ActionFowrd(path,false);
	}

}
