<%@page import="jdbc.UserVO"%>
<%@page import="jdbc.UserDAO"%>

<%@page import="java.util.List"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file ="header.jsp" %>
<%-- <jsp:include page =""> </jsp:include> --%>
<div class = "contanier">
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">이름</th>
	      <th scope="col">태어난 해</th>
	      <th scope="col">주소</th>
	      <th scope="col">휴대전화</th>
	    </tr>
	     
	  </thead>
	  <tbody>
<%

	UserDAO dao = new UserDAO();
	List<UserVO> list = dao.select();
	
/* 	if(list.isEmpty()){
		
	} */ //널이 아니면~일때 조건식으로 쓸수 있다.
	for(UserVO vo:list){
		
%>
	<tr>
		<td><%=vo.getNo() %></td>
		<td><a href="select.jsp?no=<%=vo.getNo()%>"><%=vo.getUsername() %></a></td>
		<td><%=vo.getBirthyear() %></td>
		<td><%=vo.getAddr() %></td>
		<td><%=vo.getMobile() %></td>
	</tr>
<%			
	}//for
%>
</tbody>
</table>
</div>
</body>
</html>