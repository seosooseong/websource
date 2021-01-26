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
public class ProdFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProdFrontController() {
        super();
      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글
		request.setCharacterEncoding("utf-8");
		
		//요청 분류
		String requestURI = request.getRequestURI(); 
		String contextPath = request.getContextPath(); 
		String cmd = requestURI.substring(contextPath.length()); 
		
		ProdActionFactory factory =  ProdActionFactory.getInstance();
		Action action = factory.action(cmd);
		
		
		
		ActionForward af = null;
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
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
