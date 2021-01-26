<%@page import="java.net.URLEncoder"%>
<%@page import="domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Read Board</h3>
		</div>
		<div style="height:20px"></div>
		<form action="" method="post" role="form">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10">
						<input type="text" name="name" size="10" class="form-control" maxlength='10' value="${vo.name}" readonly>
					</div>
				</div>
				<div class="form-group  row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control"	maxlength='100' value="${vo.title}" readonly="readonly">
					</div>
				</div>
				<div class="form-group  row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='board_content' cols='60' class="form-control" rows='15'>${vo.content}</textarea>
					</div>
				</div>
				<div class="form-group  row">
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
							
						}
						%>
						
					</div>
				</div>
				<div style="height:10px"></div>
				<div class="box-footer text-center">
					<button type="button" class="btn btn-success" id="reply">답변</button>
					<button type="button" class="btn btn-warning" id="modify">수정</button>
					<button type="button" class="btn btn-danger" id="delete">삭제</button>
					<button type="button" class="btn btn-primary" id="list">목록보기</button>
				</div>
				<div style="height:20px"></div>
			</div>
		</form>
	</div>
</section>
<!-- 가져갈 번호 폼 -->
<form action="" method="post" role="form">
	<input type="hidden" name="bno" value="${vo.bno}" />
</form>
<script>
$(function(){
	//삭제시 비번 form
	var formObj = $("form[role='form']");
	
	$("#reply").click(function(){ //답변을 누르면
		formObj.attr('action','qReplyView.do'); //DB내용이기에 do
		formObj.submit();
	})
	$("#modify").click(function(){
		formObj.attr('action','qModify.do');
		formObj.submit(); //보내기
	})
	$("#delete").click(function(){
		//1.링크
		//location.href='view/qna_board_pwdCheck.jsp';
		//2.
		formObj.attr('action','view/qna_board_pwdCheck.jsp');
		formObj.submit(); //보내기
		
	})
	$("#list").click(function(){
		location.href = 'qList.do';
	})
})


</script>
<%@include file="../include/footer.jsp"%>
