package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserListAction implements Action {
	
	private String path;
		
	public UserListAction(String path) {
			super();
			this.path = path;
		}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// requset.getp
		UserService service = new UserServiceImpl();
		List<UserVO> list = service.getUserList();

		//이동방식 결정한 후 이동하기 ActioForward객체 생성
		request.setAttribute("list",list);
		return new ActionForward(path, false);

	}

}
