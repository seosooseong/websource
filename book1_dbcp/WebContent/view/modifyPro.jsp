<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%
	//modify.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8"); //그냥 필수라고 생각하자!
	
	int code = Integer.parseInt(request.getParameter("code"));
	int price = Integer.parseInt(request.getParameter("price"));
	
	//db작업
	BookDAO dao = new BookDAO();
	int result = dao.bookUpdate(code, price);
	//성공시 index.jsp
	if(result==0){//실패하면 
		response.sendRedirect("../index.jsp?tab=modify");
	}else{//성공
		response.sendRedirect("selectPro.jsp");
	}


%>
	