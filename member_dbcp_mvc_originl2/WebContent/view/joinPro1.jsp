<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//joinForm.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String confirm_password = request.getParameter("confirm_password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	
	//db
	MemberDAO dao = new MemberDAO();
	//int result = dao.register(userid, password, name, gender, email);
	
	//회원 가입 성공되면 로그인 페이지로
	
	/* if(result>0){//성공하면 
	response.sendRedirect("loginForm.jsp");
	} */
%>