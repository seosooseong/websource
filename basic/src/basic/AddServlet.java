package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/Add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 보낸값 가져와서 더하기 한 후 결과값 출력
		int num1=Integer.parseInt(request.getParameter("num1"));
		
		int num2=Integer.parseInt(request.getParameter("num2"));
		
		int sum = num1+num2;
		
		//보여지는 페이지에 대한 컨텐츠 타입 설정
		response.setContentType("text/html;charset=utf-8");//한글지원
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>덧셈프로그램</title></head>");
		out.print("<body><h2>덧셈결과</h2>");
		out.print("<h3>" +num1+ " + " + num2 + " = " +sum+ "</h3>");
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
