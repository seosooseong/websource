
<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//loginForm.jsp에서 넘긴 값 가져오기
request.setCharacterEncoding("utf-8");

String userid = request.getParameter("userid");
String password = request.getParameter("current_password");

//db작업
MemberDAO dao = new MemberDAO();

MemberVO member = dao.isLogin(userid, password);
//존재하는 사용자라면 loginform.jsp로 이동

if (member != null) { //로그인 작업 -> 현재 정보를 session에 담기.
	session.setAttribute("login", member);
} else {
	out.print("<script> alert('아이디와 비밀번호를 확인해주세요.');</script>");
}

//response.sendRedirect("loginForm.jsp"); //스크립트로 띄울수 없다. 경고창 안뜸. 그래서
//아래 스크립트로도 이동시킨다.
out.print("<script>");
out.print("location.href='loginForm.jsp';");
out.print("</script>");
%>