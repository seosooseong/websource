<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//cookie3.jsp에서 설정 값 가져오기
	String language = request.getParameter("language");
	//쿠키 설정
	Cookie c = new Cookie("language",language);
	response.addCookie(c);
	
	//★유효시간 설정
	c.setMaxAge(60*60*24); //24시간
	
	//응답헤더에 쿠키 추가하기
	response.addCookie(c);
	
	//처음 페이지로 돌아가기
	response.sendRedirect("cookie3.jsp");

%>