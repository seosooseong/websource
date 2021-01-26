package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserModifyAction implements Action {
	
	private String path; //path
	
	
	public UserModifyAction(String path) { //생성자 만들고~
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//pro에서 했던거 받고
		int no = Integer.parseInt(request.getParameter("no"));
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		//서비스에 db
		UserService service = new UserServiceImpl();
		boolean flag = service.updateUser(no, addr, mobile);
		
		if(!flag) { //업데이트가 안되었다면  다시 업데이트페이지
			path ="update.do"; //jsp로 가면 null
			
		}
		return new ActionForward(path, true); 
							//list.do, af
	}

}
