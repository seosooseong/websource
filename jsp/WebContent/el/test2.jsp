<%@page import="exam.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr />	
<h3>request에 담은 값 가져오기</h3>
	<div><%= request.getAttribute("name") %></div>
	<div>${name}</div> <%--el : ${변수명} --%>
<hr />	
<h3>request에 담은 값 가져오기 -LoginDTO</h3>

<%	LoginDTO dto = (LoginDTO)request.getAttribute("login"); %>
	<div>id : <%= dto.getUserid() %></div>
	<div>pw : <%= dto.getUserpw() %></div>
	
	<div> el로 가져올때 달라 키값.변수명 </div>
	<div>id :${login.userid}</div> <%--el : ${키값.변수명} --%>
	<div>pw :${login.userpw}</div> <%--el : ${키값.변수명} --%>
<hr />	
<h3>session에 담은 값 가져오기</h3>	
	<div><%= session.getAttribute("age") %></div>
	<div>${age}</div> <%--el : ${변수명} --%>
<hr />	


<h3>리스트에 담은 값 가져오기, for문 c:forEach</h3>	
<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
	</tr>
	<c:forEach var="vo" items="${list}"> <%-- var="변수명" items="${키값}" --%>
		<tr>
			<td>${vo.userid}</td>
			<td>${vo.userpw}</td>
		</tr>	
	</c:forEach>
</table>

</body>
</html>