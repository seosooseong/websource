<%@page import="exam.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//부르고
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpw= request.getParameter("userpw");
	
	//세션 값 담기 ->로그인(아이디,비밀번호(?..암호화시켜서),이름)
/* 	session.setAttribute("userid",userid);
	session.setAttribute("userpw",userpw); */
	
	//바구니로 한번에 담기.
	LoginDTO login = new LoginDTO(userid,userpw);
	session.setAttribute("login", login);

	response.sendRedirect("../index.jsp");

%>