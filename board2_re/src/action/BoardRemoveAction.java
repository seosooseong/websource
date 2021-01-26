package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor

public class BoardRemoveAction implements Action {
	
	private String path;
	
	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//pwdCheck에서 넘긴 값 가져오기
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");
		//서비스 요청
		BoardService service = new BoardServiceImpl();
		boolean result = service.deleteArticle(bno, password);
		//요청결과에 따라 이동
		
		if(!result) path="view/qna_board_pwdCheck.jsp";
		//비밀번호가 틀리면 qna_board_pwdCheck.jsp
		return new ActionFowrd(path, true);
	}

}
