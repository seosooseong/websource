<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>다음과 같은 에러 발생</h2>
	<%-- e.printStackTrace() 또는 e.getMessage() --%>
	<%=exception.getMessage() %>
</body>
</html>