package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberModifyAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		MemberService service = new MemberServiceImpl();
		
		HttpSession session =request.getSession(); //바로 사용못하니 HttpSession
		MemberVO vo = (MemberVO) session.getAttribute("login");
		
		//1. 현재 비밀번호가 일치하는지 확인
		MemberVO info = service.login(vo.getUserid(), current_password);
		
		//2. 일치하면 세션 해제
		if(info!=null) {
			MemberService service1 = new MemberServiceImpl();
			boolean result = service1.updateMember(vo.getUserid(), new_password);
			if(result) {
					session.invalidate(); //맞으면 세션해제
			}
			}else {
				path="view/modifyForm.jsp";//실패
		}
		
		return new ActionForward(path, true);
	}

}
