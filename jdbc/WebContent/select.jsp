<%@page import="jdbc.UserVO"%>
<%@page import="jdbc.UserDAO"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//index.jsp에서 넘긴값 가져오기
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	
	UserDAO dao = new UserDAO();
	UserVO vo = dao.getUser(no); //정보 보내기
	
%>
<%@include file ="header.jsp" %>
<div class = "contanier">
<form action="" method="post">
	<div class="form-group">
    <label for="username">번호</label>
    <input type="text" class="form-control" id="no" name="no" autofocus readonly value="<%=vo.getNo()%>">
  </div>
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" id="username" name="username" readonly value="<%=vo.getUsername()%>">
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
          $(form).attr("action", "update.jsp");
          $(form).submit();
        });
		//삭제버튼을 클릭하면 deletePro.jsp	
	 $(".btn-danger").click(function () {
		 $(form).attr("action", "deletePro.jsp");
		 $(form).submit();
     });
})
</script>
</body>
</html>