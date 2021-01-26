package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NetInfoServlet
 */
@WebServlet("/Network")
public class NetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
	
		
		out.print("<html><head><title>Request 정보</title></head>");
		out.print("<body>");
		out.print("<h3>네트워크정보</h3><ul>");
		out.printf("<li>Request Scheme : %s </li>", request.getScheme());
		out.printf("<li>서버 네임 : %s </li>", request.getServerName());		
		out.printf("<li>서버 주소 : %s </li>", request.getLocalAddr());		
		out.printf("<li>서버 포트 : %s </li>", request.getServerPort());		
		out.printf("<li>클라이언트 주소 : %s </li>", request.getRemoteAddr());
		out.printf("<li>클라이언트 호스트 : %s </li>", request.getRemoteHost());
		out.printf("<li>클라이언트 포트 : %s </li>", request.getRemotePort());
		out.printf("<li>클라이언트 사용자 에이전트 : %s </li>", request.getHeader("user-agent"));
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
