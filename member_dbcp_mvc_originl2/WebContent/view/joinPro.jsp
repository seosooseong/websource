<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- //joinForm.jsp에서 넘긴 값 가져오기 -->
	
<%	
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String confirm_password = request.getParameter("confirm_password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	
	//개별 값 객체화 (바구니에 담기)
	MemberVO member = new MemberVO();
	member.setUserid(userid);
	member.setPassword(password);
	member.setName(name);
	member.setGender(gender);
	member.setEmail(email);
	//db
	MemberDAO dao = new MemberDAO();
	int result = dao.register(member);
	
	
	
	//회원 가입 성공되면 로그인 페이지로
	
	if(result > 0){//성공하면 
	response.sendRedirect("loginForm.jsp");
	}
%>