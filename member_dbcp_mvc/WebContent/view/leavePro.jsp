<%@page import="member.MemberDAO"%>
<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//가져오기

	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	
	//db
	//비밀번호가 맞으면 세션 해제, index이동
	MemberDAO dao = new MemberDAO();
	int result = dao.leaveMember(userid, password);
	
	if (result > 0) { 
		session.invalidate();
		response.sendRedirect("../index.jsp");
	} else {
		response.sendRedirect("leaveForm.jsp");
	}
	//틀리면 leaveform으로 이동
	
%>