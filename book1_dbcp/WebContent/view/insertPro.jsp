<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//insert.jsp에서 사용자가 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	
	
	int code = Integer.parseInt(request.getParameter("code"));
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	int price = Integer.parseInt(request.getParameter("price"));

	//db작업
	BookDAO dao = new BookDAO();
	int result = dao.bookInsert(code,title,writer,price);
	//결과에 따라 페이지 이동
	if(result==0){//실패하면 
		response.sendRedirect("../index.jsp?tab=insert");
	}else{
		response.sendRedirect("selectPro.jsp");
	}
	
%>