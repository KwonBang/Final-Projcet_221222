<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(function() {
		$("#reg_Btn").click(function(){
			$("[name=frm]").attr("action","insert").attr("method","post").submit();
		})
		$("#uptBtn").click(function(){
			$("[name=frm]").attr("action","update").attr("method","post").submit();
		})
		var tmp = 0;
		$("#addFile").click(function(){
			var html = "<input type=file"+tmp+" id=file"+tmp+" onchange=fncFileCheck(this)>";
			html += "<input type=button value=삭제 onclick=fileInputDelete(this)><br>";
			$("#FileDv").append(html);
			tmp++;
		})
	})
	function fileInputDelete(btn) {
		$(btn).prev().remove();
		$(btn).next().remove();
		$(btn).remove();
	}
	function fncFileCheck(fileInput) {
		var ext = $(fileInput).val().split(".")pop().toLowerCase();
		
		if($.inArray(ext,["gif","jpg","jpeg","png","bmp"]) == -1) {
			alert("gif, jpg, jpeg, png, bmp 파일만 업로드 해주세요.");
			$(fileInput).val("");
			return;
		}
		var file = fileInput.files[0];
		var _URL = window.URL || window.webkitURL;
		var img = new Image();
		
		img.src = _URL.createObjcetURL(file);
		img.onload = function() {
			if(img.width > 500 || img.height > 500) {
				alert("이미지는 500 이하만");
				$(fileInput).val("");
			}
		}
	}
</script>
</head>
<body>
	<form name="frm" id="frm">
		<div>
			작성자 : <input type="text" name="mem_name" value="${map.get("mem_name") }"><br>
			ID : <input type="text" name="mem_id" value="${map.get("mem_id") }"><br>
			제목 : <input type="text" name="board_subject" value="${map.get("board_subject") }"><br>
			내용 : <br>
			<textarea name="board_content">${map.get("board_content") }</textarea><br>
		</div>
	</form>
	<div id="fileDv">
		<input type="button" name="addFile" id="addFile" value="파일추가">
	</div>
	<div>
		<c:choose>
			<c:when test="${empty map }">
				<input type="button" name="regBtn" id="regBtn" value="등록">
			</c:when>
			<c:otherwise>
				<input type="hidden" name="seq" id="seq" value="${map.seq }">
				<input type="button" name="uptBtn" id="uptBtn" value="수정">
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>