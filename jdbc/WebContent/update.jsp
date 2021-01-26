<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//index.jsp에서 넘긴값 가져오기
	request.setCharacterEncoding("utf-8");
	/* String no = request.getParameter("no"); */

	//데이터베이스(DB) 접속 후 사용자의 no에 해당하는 정보 가져오기
		int no = Integer.parseInt(request.getParameter("no"));
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			//1.드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			//2.데이터 베이스 연결을 위한 문자열 생성
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password = "12345";
			
			//3.커넥션
			con = DriverManager.getConnection(url, user, password);
			if(con!=null){
				//4.sql구문 전송
				String sql = "select * from userTBL where no=?"; // ? 사용자의 입력값으로 대치
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);

			//5.sql실행
			rs = pstmt.executeQuery();
			if(rs.next()){ //가져와유~
				no = rs.getInt("no"); 
				String userName = rs.getString("username");
				int birthYear = rs.getInt("birthyear");
				String addr = rs.getString("addr");
				String mobile = rs.getString("mobile");
		
		
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
<form action="updatePro.jsp" method="post">
	<div class="form-group">
    <label for="username">번호</label>
    <input type="text" class="form-control" id="no" name="no" readonly value="<%=no%>">
  </div>
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" id="username" name="username" readonly value="<%=userName%>">
  </div>
  <div class="form-group">
    <label for="birthYear">태어난 해</label> 
    <input type="text" class="form-control" id="birthyear" name="birthyear" readonly value="<%=birthYear%>">
  </div>
    <div class="form-group">
    <label for="addr">주소</label>
    <input type="text" class="form-control" id="addr" name="addr"  placeholder="<%=addr%>" autofocus required  >
  </div>
    <div class="form-group">
    <label for="mobile">휴대전화</label>
    <input type="text" class="form-control" id="mobile" name="mobile"  placeholder="<%=mobile%>" required>
  </div>
  <div class="form-group">
    <button type="submit" class="btn btn-dark">수정</button>
    <button type="button" class="btn btn-secondary">취소</button>
  </div>
</form>	
</div>
<%

			}//if
		}//if
			//form안에 뿌려주기
	}catch(Exception e){
		e.printStackTrace();
		
	}finally{
		try{
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

%>
</body>
</html>