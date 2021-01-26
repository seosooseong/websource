package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;


@WebServlet("*.do")
public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글
		request.setCharacterEncoding("utf-8");
		
		//요청 분류하기
		String requestURI = request.getRequestURI(); //jdbc_dbcp_mvc/update.do
		String contextPath = request.getContextPath(); //jdbc_dbcp_mvc (잘라내기)
		String cmd = requestURI.substring(contextPath.length()); //insert.do
		
		//요청에 맞는 Action 생성 -> UserActionfactory
		UserActionFactory factory = UserActionFactory.getInstance();
		Action action = factory.action(cmd); //User**Action
		
		//생성된 액션에게 일을 시키기.
		ActionForward af = null;
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//이동방식에 따라 페이지 이동
		if(af.isRedirect()) { //sendRedirect
			response.sendRedirect(af.getPath());
		}else { //forward
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
