<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	//선언문 : 클래스의 멤버변수, 멤버 메소드 역활
	 public int sum(){
		int total = 0;
		for(int i=1; i<=50; i++){
			total+=i;
		}
		return total;
		}
%>
<%
	//스크립틀릿 : 지역변수
	String str ="1~50까지 합";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 표현식 값 화면 출력 --%>
	<h3><%=str %>은 <%=sum() %> 입니다.</h3>
	<br/>
	<h3><%=str %>에 3을 곱하면<%=sum()*3 %> 입니다.</h3>
<br/>
	<h3><%=str %>에 1000을 나누면<%=sum()/1000 %> 입니다.</h3>
	
</body>
</html>