<%@page import="exam.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//User 클래스 사용 ...객체 생성!필요!
	
	User user = new User(); //null이라서
	user.setName("홍길동"); //홍길동 만들어줌.
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=user.getName() %></h1>
</body>
</html>