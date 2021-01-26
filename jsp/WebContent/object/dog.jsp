<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글꺠짐
	request.setCharacterEncoding("utf-8");

	//사용자가 입력한 값 가져오기
	String [] dogs = request.getParameterValues("dog");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>선택한 댕댕이들</h3>
		<ul>
<% 
		for(String s:dogs) {
			out.print("<li>" +s+"</li>");
		}
%>
		</ul>
</body>
</html>