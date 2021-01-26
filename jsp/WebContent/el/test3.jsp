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
	<h1>EL에서 사용하는 연산자</h1>
	${1 > (4/2) } <br/>
	${4.0 >= 3 } <br/>
	${10.0 == 10.0 } <br/>
	${10.0 eq 10.0 } <br/>
	${10.0 != 10.0 } <br/>
	${10.0 ne 10.0 } <br/> <!--같지 않다. 네거티브  -->
<hr />	
<h1>EL + jstl</h1>
	<c:if test="${5<10}">
	<h3>5는 10보다 작다. else 개념이 없음</h3>
	</c:if>
	
<hr />		
<h3>else c:choose when otherwise </h3>
	<c:choose>
	 <c:when test="${5+10 == 50 }">
	 <h3>5+10은 50이다.</h3>
	 </c:when>
	 <c:otherwise>
	 <h3>5+10은 50이 아니다.</h3>
	 </c:otherwise>
	</c:choose>
	
</body>
</html>