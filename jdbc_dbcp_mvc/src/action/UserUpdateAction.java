package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserUpdateAction implements Action {
	
	private String path;
	
	public UserUpdateAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no")); //넘긴값 가져오기
		
		UserService service = new UserServiceImpl();
		UserVO vo =service.getUser(no);
		
		request.setAttribute("vo", vo);
		
		return new ActionForward(path,false);
	}
}
