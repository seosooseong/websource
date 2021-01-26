package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionFowrd;

/**
 * Servlet implementation class BookFrontController
 */
@WebServlet("*.do")
public class BookFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//요청분류
	
		String requestURI = request.getRequestURI(); //             /book1_dbcp/list.do
		String contextPath = request.getContextPath(); //           /book1_dbcp (잘라내기)
		String cmd = requestURI.substring(contextPath.length()); // /list.do
		
		//액션 생성
		BookActionFactory factory = BookActionFactory.getInstance();
		Action action = factory.action(cmd);
		
		//일시키기
		
		ActionFowrd af = null;
		
		try {
			af=action.execute(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//설정된 이동방식 과 경로에 따라 움직이기
		
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
