<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num1=Integer.parseInt(request.getParameter("num1"));
	
	int num2=Integer.parseInt(request.getParameter("num2"));
	
	int sum = num1+num2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>덧셈결과</h2>
	<h3><%=num1 %>+<%=num2 %>=<%=num1+num2 %></h3>
<% 
		
		out.print("<h3>" +num1+ " + " + num2 + " = " +sum+ "</h3>");
%>
</body>
</html>