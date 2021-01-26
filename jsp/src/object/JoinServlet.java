package object;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
				
		//사용자가 보낸 값
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		
		//화면 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>개인정보</title></head>");
		out.print("<body>");
		out.print("<h3>사용자정보</h3><ul>");
		out.print("<li>아이디 :" +id +"</li>");
		out.print("<li>비밀번호 :" +password+"</li>");	
		out.print("<li>비밀번호확인 :" +password1+"</li>");		
		out.print("<li>이름 : " + username +"</li>");	
		out.print("<li>성별 : " + gender +"</li>");	
		out.print("<li>이메일 : " + email +"</li>");	
		
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
