package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;
@AllArgsConstructor
public class MemberLeaveAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		MemberService service = new MemberServiceImpl();
		
		boolean result =service.leaveMember(userid, password);
		
		if(!result) {
			path="view/leaveForm.jsp";
		}else {
			HttpSession session =request.getSession();
			session.invalidate();
		}
		
		
		return new ActionForward(path, true);
	}

}
