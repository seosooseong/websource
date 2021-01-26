package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserDeleteAction implements Action {
	
	private String path;
	
	public UserDeleteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		UserService service = new UserServiceImpl();
		
		boolean flag = service.deleteUser(no);
		
		if(!flag) { //삭제 안되었다면  
			path ="select.do"; //jsp로 가면 null // 갈 페이지는 주소창 보면 나온다.
			
		}
		return new ActionForward(path, true); 
							//list.do, af
		
	}

}
