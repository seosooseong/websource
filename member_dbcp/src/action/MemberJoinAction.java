package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberJoinAction implements Action {
	private String path;
	
	
	
	public MemberJoinAction(String path) {
		super();
		this.path = path;
	}



	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberVO member = new MemberVO();
		
		member.setUserid(request.getParameter("userid"));
		member.setPassword(request.getParameter("password"));
		
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setGender(request.getParameter("gender"));
//		String userid = request.getParameter("userid");
//		String password = request.getParameter("password");
//		String confirm_password = request.getParameter("confirm_password");
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String gender = request.getParameter("gender");
		
		
		MemberService service = new MemberServiceImpl();
		boolean result =service.registerMember(member);
		
		if(!result) {
			path="view/joinForm.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
