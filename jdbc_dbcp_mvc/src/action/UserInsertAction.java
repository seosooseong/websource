package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserInsertAction implements Action {
	
	private String path;
	
	public UserInsertAction(String path) {
		this.path=path; //insert.jsp (성공)
	}
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter()
		//add.jsp 사용자 값 가져오기
		String username = request.getParameter("username");
		String birthyear = request.getParameter("birthyear");
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		//Sercvie에게 일 시키기
		UserService service = new UserServiceImpl();
		boolean insertFlag = service.insertUser(username, birthyear, addr, mobile);
		
		
		if(!insertFlag) {
			path ="add.jsp"; //(실패)
		}
		//작업 결과에 따라 페이지 이동 방식 결정 -sendRedirect (true)로 항상 설정
		return new ActionForward(path,true);
	}

}
