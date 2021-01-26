package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
import util.FileUploadUtil;

@AllArgsConstructor // 생성자
public class BoardWriteAction implements Action {

	private String path; // path

	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request.getParameter(), 가져오는 작업이 필요하다.

		FileUploadUtil utils = new FileUploadUtil();

		Map<String, String> map = utils.uploadFile(request);

		// map에 들어 있는 폼 요소들을 vo 에 옮겨주기

		BoardVO board = new BoardVO();
		board.setName(map.get("name"));
		board.setTitle(map.get("title"));
		board.setContent(map.get("content"));
		board.setPassword(map.get("password"));

		if (map.containsKey("attach")) // attach가지고 있다면
			board.setAttach(map.get("attach"));
		
		
		//서비스 호출
		 BoardService service = new BoardServiceImpl();
		 boolean flag =service.insertArticle(board);
		

		 if(!flag) { 
			 path="view/qna_board_write.jsp"; 
		 }else {
			 path+="?page=1&criteria=&keyword=";
		 }

		return new ActionFowrd(path, true);
	}

}
