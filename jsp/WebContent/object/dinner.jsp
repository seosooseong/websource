<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글깨짐
	request.setCharacterEncoding("utf-8");

	//사용자가 입력한 값 가져오기
	String[] dinner = request.getParameterValues("dinner");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>저녁 메뉴</h3>
		<ul>
		<% 
		for(String d: dinner) {
			out.print("<li>" +d+" </li>");
		}
			
		%>
		<ul>
</body>
</html>