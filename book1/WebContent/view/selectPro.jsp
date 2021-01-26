

<%@page import="book1.BookVO"%>
<%@page import="book1.BookDAO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//도서 목록 보기 메뉴를 클릭하면 보여줄 내용 처리
	BookDAO dao = new BookDAO(); //호출
	
	List<BookVO> list=dao.getList();
	// scope -> request (+forward), session
	request.setAttribute("list", list);
	pageContext.forward("../select.jsp");
	
	
	
	

%>