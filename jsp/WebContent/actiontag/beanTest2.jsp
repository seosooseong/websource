<%@page import="exam.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--User user = new User();와 동일 --%>
<jsp:useBean id="user" class="exam.User"/>
	<h1>
		<%--property="name" 은 변수선언과 동일 --%>
		<%--user.setName("홍길동");와 동일 --%>
		<jsp:setProperty property="name" name="user" value="홍길동"/>
		
		<%--user.getName()와 동일 --%>
		<jsp:getProperty property="name" name="user"/>
	</h1>
</body>
</html>