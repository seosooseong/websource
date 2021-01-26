<%@page import="domain.UserVO"%>
<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//UserVO vo = (UserVO)request.getAttribute("vo");
	
%>
//<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="header.jsp" %>
<div class = "contanier">
<form action="" method="post">
	<div class="form-group">
    <label for="username">번호</label>
    <input type="text" class="form-control" id="no" name="no" autofocus readonly value="${vo.no }">
  </div>
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" id="username" name="username" readonly value="${vo.username }">
  </div>
  
  <div class="form-group">
    <button type="button" class="btn btn-dark"> 수정</button>
    <button type="button" class="btn btn-danger">삭제</button>
  </div>
</form>	
</div>
<%
		
%>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
	$(function () {
	  
		let form = $("form");
		//수정버튼을 클릭하면 update.jsp
	 $(".btn-dark").click(function () {
          $(form).attr("action", "update.do");
          $(form).submit();
        });
		//삭제버튼을 클릭하면 deletePro.jsp	
	 $(".btn-danger").click(function () {
		 $(form).attr("action", "delete.do");
		 $(form).submit();
     });
})
</script>
</body>
</html>