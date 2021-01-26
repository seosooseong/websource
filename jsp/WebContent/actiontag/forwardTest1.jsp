<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardTest1</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<%-- - jsp 액션 태그 : 자바 코드 노출 최소화 
	 - pageContext.forward();와 동일
	 - param은 옵션 /// 그리고 !코드 중간에 주석 있으면 500오류 --%>
	 
<jsp:forward page ='<%=request.getParameter("forwardPage") %>'>
	<jsp:param name ="tel" value="034-1223-0439" />
</jsp:forward>	
</body>
</html>