<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//modifyForm.jsp에서 넘긴 값 가져오기
	
	String current_password = request.getParameter("current_password");
	String new_password = request.getParameter("new_password");
	String confirm_password = request.getParameter("confirm_password");

	//db
	MemberDAO dao = new MemberDAO();

	//ⓐ현재 비밀번호가 일치하는지 확인 -> isLogin(String userid, String password)
	//- 세션에서 userid가져오기
	MemberVO vo = (MemberVO) session.getAttribute("login");
	MemberVO info = dao.isLogin(vo.getUserid(), current_password);

	//ⓑ일치한다면 변경 /세션해제 / 로그인 페이지로 돌려보내기 -> 새로운 메소드.
	if (info != null) {
		int result = dao.updateMember(vo.getUserid(), new_password);
			if (result > 0) {
				session.invalidate(); //세션해제
				response.sendRedirect("loginForm.jsp"); //로그인페이지 이동
			}
	} else { //ⓒ불일치하면 변경페이지로 돌려보내기
		response.sendRedirect("modifyForm.jsp");

}
%>