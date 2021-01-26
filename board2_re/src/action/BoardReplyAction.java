package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor
public class BoardReplyAction implements Action {
	
	private String path;
	
	
	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//reply.jsp에서 7개 가져옴 (name, title, content, password, hidden 3개)
		BoardVO vo =new BoardVO(); //vo에 담아서
		//댓글값
		vo.setName(request.getParameter("name"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setPassword(request.getParameter("password"));
		//원본글 값(히든값)
		vo.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		vo.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		vo.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));

		
		//서비스
		
		BoardService service = new BoardServiceImpl();
		boolean result = service.insertReply(vo);
		
		//이동
		if(!result) { //실패시 원본글로
			path="qView.do?bno="+request.getParameter("bno");
		}
		return new ActionFowrd(path, true);

	}

}
