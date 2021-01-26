package action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
import util.FileUploadUtil;
@AllArgsConstructor
public class BoardUpdateAction implements Action {
	
	private String path; //qView.do
	
	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FileUploadUtil utils = new FileUploadUtil();

		Map<String, String> map = utils.uploadFile(request);

		// map에 들어 있는 폼 요소들을 vo 에 옮겨주기

		BoardVO vo = new BoardVO();
		vo.setBno(Integer.parseInt(map.get("bno")));
		vo.setTitle(map.get("title"));
		vo.setContent(map.get("content"));
		vo.setPassword(map.get("password"));
		if (map.containsKey("attach")) { // attach가지고 있다면
			vo.setAttach(map.get("attach"));
		}
		
		//페이지 나누기 후 넘어오는 값들.
		String page = map.get("page");
		String criteria = map.get("criteria");
		String keyword = URLEncoder.encode(map.get("keyword"),"utf-8");
		
		BoardService service = new BoardServiceImpl();
		boolean flag = service.updateArticle(vo);
		
		//이동
		if(!flag) { //실패
			path="qModify.do?bno="+map.get("bno")+"&page="+page+"&criteria="+criteria+"&keyword="+keyword; //번호가 필요하다 다시 들어가 써야하니깐.
		}else {	//성공
			path += "?bno="+map.get("bno")+"&page="+page+"&criteria="+criteria+"&keyword="+keyword; 
		}
		return new ActionFowrd(path, true);
	}

}
