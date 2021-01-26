package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		//선택값 가져오기
		response.setContentType("text/html;charset=utf-8");//한글지원
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		
		
		out.print("<html><head><title>**개인정보**</title></head>");
		out.print("<body><h2>개인정보</h2>");
		out.print("<ul><li>이름 : " + name+"</li></ul>");
		out.print("<ul><li>아이디 : " +id+"</li></ul>");
		out.print("<ul><li>비밀번호 : " +password+"</li></ul>");
		out.print("<ul><li>성별 : " +gender+"</li></ul>");
		out.print("<ul><li>직업 : "+job+"</li></ul>");
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
