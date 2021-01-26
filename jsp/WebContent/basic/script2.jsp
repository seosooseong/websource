<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //자바코드는 여기서 작성!
    	Calendar c = Calendar.getInstance();
    	int hour = c.get(Calendar.HOUR_OF_DAY);
    	int minute = c.get(Calendar.MINUTE);
    	int second = c.get(Calendar.SECOND);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--상황에 따라 코드 작성 --%>
	<h3>현재시간은 <%=hour %> : <%=minute %> : <%=second %></h3>
	<% if (hour >= 12){ %>
	<h4>오후입니다.</h4>
	<% }else{ %>
	<h4>오전입니다.</h4>
	<%} %>
	
	
	
	<%--아래 코드가 더 편하다. --%>
	<%
	if(hour >=12){
		out.print("<h4>오후입니다.</h4>");
	}else{
		out.print("<h4>오전입니다.</h4>");
	}
	%>
</body>
</html>