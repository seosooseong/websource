package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DinnerServlet
 */
@WebServlet("/DinnerServlet")
public class DinnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		//선택 값 가져오기
		String[] dinner = request.getParameterValues("dinner");
		
		response.setContentType("text/html;charset=utf-8");//한글지원
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>★Dinner Choice★</title></head>");
		out.print("<body><h3>저녁메뉴</h3>");
		out.print("<ul>");
		for(String d:dinner) {
			out.print("<li>" +d+"</li>");
		}
		out.print("</ul><h5>맛있게 드세요^^</h5></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
