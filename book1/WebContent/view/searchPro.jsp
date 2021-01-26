<%@page import="book1.BookVO"%>
<%@page import="book1.BookDAO"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String criteria = request.getParameter("criteria");
	String keyword = request.getParameter("keyword");
	
	/* out.print("criteria" + criteria +"</br>");
	out.print("keyword" + keyword); */
	
	//db
	BookDAO dao = new BookDAO(); //호출
	
	List<BookVO> list=dao.bookSearch(criteria, keyword);
	//forward
	request.setAttribute("list", list);
	pageContext.forward("../searchAll.jsp");//forward,includ -> 상대주소 / 절대주소x
%>