
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//cart.html에서 사용자가 선택한 자동차를 가져온 후
	String product = request.getParameter("product");
	

	
	//그래서 아래 코드로
	
	ArrayList<String> proList = (ArrayList<String>)session.getAttribute("proList");

	if (proList == null){ //장바구니 리스트 생성안된경우
		proList = new ArrayList<String>();
		//현재 선택 된 상품 추가
		proList.add(product);
		//proList 담아준다.
		session.setAttribute("proList", proList);
	}else{
		proList.add(product);
	}
	//session에 "product"라는 이름으로 추가한다. (하나만 일때!!!)
	//session.setAttribute("product", product);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>장바구니 저장</h3>

	<a href="cartList.jsp">장바구니 보기</a>
</body>
</html>