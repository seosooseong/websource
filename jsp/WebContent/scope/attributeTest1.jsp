<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//attributeTest1_Form.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8"); //한글
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	
	
	//속성 값에 담기
	//name.isEmpty()
	if(name != null && id!=null){
		//setAttribute("키",value)
		application.setAttribute("name", name);
		application.setAttribute("id", id);
		
	}
	
	%>
	
	<h3>
		<%=name %>님 반갑습니다.<br/>
		<%=name %>님의 아이디는 <%=id %>입니다.
	</h3>
	
	<form action="attributeTest2.jsp" method="post">
		<ul>
			<li>Session 영역에 저장할 내용들</li>
		</ul>
		<div>
			<label for="">E-mail</label>
			<input type="text" name="email"/>
		</div>
		<div>
			<label for="">주소</label>
			<input type="text" name="address"/>
		</div>	
		<div>
			<label for="">전화번호</label>
			<input type="text" name="tel"/>
		</div>	
		<div>
			<input type="submit" "value="보내기"/>
		</div>
	</form>
</body>
</html>