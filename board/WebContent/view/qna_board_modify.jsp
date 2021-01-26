<%@page import="java.net.URLEncoder"%>
<%@page import="domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Board Modify</h3>
		</div>
		<div style="height:20px"></div>
		<form action="qUpdate.do" method="post" role="form" enctype="multipart/form-data">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10" >
					<input type="text" name="name" size="10" class="form-control"	maxlength='10' value="${vo.name}" readonly="readonly">
					</div>
				</div>
				<div class="form-group row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control"	maxlength='100' value="${vo.title}">
					</div>
				</div>
				<div class="form-group row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='content' cols='60' class="form-control" rows='15'> ${vo.content}</textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control" size="10" maxlength='10'>
					</div>
				</div>
				<div class="form-group row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">
						<%//자바코드
						
						BoardVO board =(BoardVO)request.getAttribute("vo"); // 찾아서 온다.
						String attachFullName = board.getAttach();
						
						if(attachFullName !=null){
																		//URLEncoder.encode 특수문자 x
						out.print("<a href='view/download.jsp?fileName="+URLEncoder.encode(attachFullName,"utf-8")+"'>");
						out.print(attachFullName);
						out.print("</a>");
							
						}else{
							out.print("<input type='file' name='attach'>");
							out.print("<small class='text-muted'> (파일크기 : 2mb)</small>");
						}
						%>
					</div>
				</div>
				<div style="height:20px"></div>
				<div class="box-footer text-center">
					<button type="submit" class="btn btn-primary" >수정</button>
					<button type="button" class="btn btn-danger" onclick="history.back()">취소</button>
				</div>
				<div style="height:20px"></div>
			</div>
			<!-- 숨겨서 보낸다. -->
			<input type="hidden" name="bno" value='${vo.bno}'/>
			<input type="hidden" name="page" value="${searchVO.page}" />
			<input type="hidden" name="criteria" value="${searchVO.criteria}" />
			<input type="hidden" name="keyword" value="${searchVO.keyword}" />
		</form>
	</div>
</section>

<script>
$(function(){
	
	let inputFile = $("input[name='attach']");
	
	$(inputFile).click(function(){
		let files = inputFile[0].files;
		let fileName = files[0].name;
		let fileSize = files[0].size;
		
		//확장자 제한(txt|jpg|png|gif|png)
		var reg =/(.*?)\.(txt|jpg|png|gif|png)$/;
		
		//사이즈 제한
		var maxSize = 2097152; //약2MB
		
		if(!reg.test(fileName)){
			alert("해당 종류의 파일을 업로드 할 수 없습니다.");
			return false;			
		}
		if(fileSize > maxSize){
			alert("파일 사이즈가 2MB미만인지 확인해 주세요.");
			return false;	
		}
	})
})


</script>
<%@include file="../include/footer.jsp"%>
