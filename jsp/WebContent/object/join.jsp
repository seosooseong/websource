<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//먼저 제출했던 파일에서  한글 깨지는거 수정했습니다.
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String password1 = request.getParameter("password1");
	String username = request.getParameter("username");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>아이디 : <%=username %></h3>
	<h3>비밀번호 : <%=password %></h3>
	<h3>비번확인 : <%=password1 %></h3>
	<h3>이름 : <%=username %></h3>
	<h3>성별 : <%=gender %></h3>
	<h3>이메일 : <%=email %></h3>
</body>
</html>