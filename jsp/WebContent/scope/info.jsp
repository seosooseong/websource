<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	//info.html 에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String age = request.getParameter("age");
	
	//request 영역객체에 값 담기
	request.setAttribute("username", username);
	request.setAttribute("age", age);
	
	
	
	
	//주소창은 info지만 내용은 infoPro.jsp
	pageContext.forward("infoPro.jsp");
		
%>
