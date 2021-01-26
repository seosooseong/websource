
<%@page import="java.io.File"%>

<%@page import="java.util.UUID"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//file upload 요청 파악하기
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
	
	if(isMultipart){
		//전송된 파일을 디스크에 저장하기 위한 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//파일 업로드 handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		//request 파싱을 위해 담기
		List <FileItem> fileItems = upload.parseRequest(request);
		//for(MemberVO vo:list), Iterator
		
		String fieldName = null, fileName = null, value= null;
		Iterator<FileItem> iter = fileItems.iterator();
		
		while(iter.hasNext()){
			FileItem item = iter.next();
			
			if(item.isFormField()) { // TYPE =file 이 아닌 것들
				fieldName = item.getFieldName();
				value=item.getString("utf-8");
				out.print("<h3>일반데이터</h3>");
				out.print(fieldName +":"+value+"<br>");
			} else {
				fieldName =item.getFieldName();
				fileName =item.getName();
				long size =item.getSize();
				
				out.print("<h3>파일데이터</h3>");
				out.print(fieldName +":"+fileName+"<br>");
				out.print("파일크기: " +size);
				
				//파일 저장하기
				String path ="e:\\upload";
				if(!fileName.isEmpty()){
					
					UUID uuid = UUID.randomUUID();
					
					File uploadFile = new File(path+"\\"+uuid.toString()+"_"+fileName);
					item.write(uploadFile);
				
					// 파일 다운로드 위한 경로
					out.print("<p>");
					out.print("<a href='download.jsp?fileName="+uploadFile.getName()+"'>"+fileName+"</a>");
					out.print("</p>");
				}
			}	
		}
	}

%>