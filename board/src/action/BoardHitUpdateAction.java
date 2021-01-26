package action;

import java.net.URLEncoder;

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
		
		//페이지 나누기 후 넘어오는 값들.
		String page = request.getParameter("page");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"),"UTF-8"); // 한글 인코딩 필요함.
		
		
		// 서비스 요청 -> 조회수
		BoardService service = new BoardServiceImpl();
		service.hitUpdate(bno);// 조회수요청
		
		
		path += "?bno="+bno+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
		//"?bno" = qView.do +
		
		return new ActionFowrd(path, true); //path  qView.do
	}

}
