package exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ElServlet
 */
@WebServlet("*.do")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			request.setCharacterEncoding("utf-8");
			
			//세션에 담기
			HttpSession session = request.getSession();
			session.setAttribute("age", 25);
			
			//리스트
			List<LoginDTO> list = new ArrayList<LoginDTO>();
			list.add(new LoginDTO("kang123","kangpassword"));
			list.add(new LoginDTO("seo123","seopassword"));
			list.add(new LoginDTO("kim123","kimpassword"));
			list.add(new LoginDTO("jung123","kungpassword"));
			request.setAttribute("list", list);
			
			//
			LoginDTO login = new LoginDTO("hong123","hong123!");
			request.setAttribute("login", login);
			
			//리퀘스트
			request.setAttribute("name", request.getParameter("name"));
			RequestDispatcher rd = request.getRequestDispatcher("el/test2.jsp");
			rd.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
