<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String fileName = request.getParameter("fileName");
	

	//다운로드가 일어날 폴더 지정
	String downPath ="e:\\upload";
	String filePath = downPath +"\\"+fileName;
	
	FileInputStream in = new FileInputStream(filePath);
	
	
	out.clear();
	out=pageContext.pushBody();
	
	//response 헤더 설정
	response.setContentType("application/octet-stream");
	fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1"); //파일 한글처리.
	
	//fileName: uuid값_ 제거
	// _ 언더바 기준으로 파일명
	String oriName = fileName.substring(fileName.lastIndexOf("_")+1);
	
	
	response.setHeader("Content-Disposition", "attachment;filename="+oriName);
	//response.setContentsType("Content-Disposition", "attachment;filename-"+oriName);
	
	//파일저장
	BufferedOutputStream buf = new BufferedOutputStream(response.getOutputStream());
	
	int numRead=0;
	byte[] b= new byte[8192];
	while((numRead=in.read(b,0,b.length))!=-1){
		buf.write(b,0,numRead);
		
	}
	
	buf.flush();
	buf.close();
	in.close();

%>