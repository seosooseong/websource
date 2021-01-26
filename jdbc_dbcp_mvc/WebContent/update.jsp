<%@page import="domain.UserVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
		UserVO vo = (UserVO)request.getAttribute("vo");
%>	


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<style>
	.contanier {
		margin: 30px;
	}

</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">JDBC</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">User 조회<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="add.jsp">User 추가</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="update.jsp">User 수정</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="delete.jsp">User 삭제</a>
      </li>
    </ul>
  </div>
</nav><!-- nav 종료 -->

<div class = "contanier">
<form action="modify.do" method="post">
	<div class="form-group">
    <label for="username">번호</label>
    <input type="text" class="form-control" id="no" name="no" readonly value="<%=vo.getNo()%>">
  </div>
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" id="username" name="username" readonly value="<%=vo.getUsername()%>">
  </div>
  <div class="form-group">
    <label for="birthYear">태어난 해</label> 
    <input type="text" class="form-control" id="birthyear" name="birthyear" readonly value="<%=vo.getBirthyear()%>">
  </div>
    <div class="form-group">
    <label for="addr">주소</label>
    <input type="text" class="form-control" id="addr" name="addr"  placeholder="<%=vo.getAddr()%>" autofocus required  >
  </div>
    <div class="form-group">
    <label for="mobile">휴대전화</label>
    <input type="text" class="form-control" id="mobile" name="mobile"  placeholder="<%=vo.getMobile()%>" required>
  </div>
  <div class="form-group">
    <button type="submit" class="btn btn-dark">수정</button>
    <button type="button" class="btn btn-secondary">취소</button>
  </div>
</form>	
</div>

</body>
</html>