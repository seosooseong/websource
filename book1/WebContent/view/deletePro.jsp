<%@page import="book1.BookDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//값 가져오기
	int code = Integer.parseInt(request.getParameter("code"));
	
	BookDAO dao = new BookDAO();
	int result = dao.bookDelete(code);
	
	if (result==0){
		response.sendRedirect("../index.jsp?tab=delete");
	}else{ //성공시 select
		response.sendRedirect("selectPro.jsp");
		
	}
		
	
%>