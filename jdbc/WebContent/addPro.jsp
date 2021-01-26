<%@page import="jdbc.UserDAO"%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//add.jsp 사용자 값 가져오기
request.setCharacterEncoding("utf-8");

String username = request.getParameter("username");
String birthyear = request.getParameter("birthyear");
String addr = request.getParameter("addr");
String mobile = request.getParameter("mobile");

//UserDAO 객체 생성 - DB 작업 시키기
UserDAO dao = new UserDAO(); //객체생성
int result = dao.insert(username, birthyear, addr, mobile); //db작업하기위해 변수명을 써준다.

//7.결과에 따라 페이지 이동
if (result > 0) { //입력성공
	response.sendRedirect("index.jsp");
} else { //입력실패
	response.sendRedirect("add.jsp");
}
%>