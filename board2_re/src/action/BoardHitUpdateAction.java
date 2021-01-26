package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardHitUpdateAction implements Action {

	private String path; //qView.do

	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		// 서비스 요청 -> 조회수
		BoardService service = new BoardServiceImpl();
		service.hitUpdate(bno);// 조회수요청
		
		
		path += "?bno="+bno;
  //"?bno" = qView.do +
		
		return new ActionFowrd(path, true); //path  qView.do
	}

}
