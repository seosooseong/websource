<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		//한글깨짐
		//request.setCharacterEncoding("utf-8");
		//숫자
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		//연산자
		String op = request.getParameter("op");
		
		int result = 0;
		
		switch (op) {
		case "+":
			result = num1+num2;
			break;
		case "-":
			result = num1-num2;		
			break;
		case "*":
			result = num1*num2;
			break;
		case "/":
			result = num1/num2;
			break;
		default:
			break;
		}
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>계산</h3>
	<h3><%=num1%> <%=op%> <%=num2%> = <%= result %></h3>


</body>
</html>