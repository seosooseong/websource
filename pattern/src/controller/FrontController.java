package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.DeleteAction;
import action.InsertAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") // <- select.do, insert.do, modify.do ~~~
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:8000/pattern/update.do
		//http://localhost:8000/pattern/select.do
		//http://localhost:8000/pattern/delete.do
		//http://localhost:8000/pattern/insert.do
		request.setCharacterEncoding("utf-8"); //한글
		//구별하기 위한 코드 아래 3줄
		String requestURI = request.getRequestURI();// 	  		    /pattern/update.do
		String contextPath = request.getContextPath();// 			/pattern
		String cmd = requestURI.substring(contextPath.length());//  /update.do
	
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.action(cmd);
		
				
		ActionForward af = null;
		try {
			af=action.execute(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(af.isRedirect()) { //true -> sendRedirect방식
			response.sendRedirect(af.getPath()); //경로 af.getPath()
		}else { 			  //false -> forward
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath()); //경로 af.getPath()
			rd.forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
}



