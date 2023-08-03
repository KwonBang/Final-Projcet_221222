<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
<input hidden="" value="${display }" id="displayNum"><!-- 화면종류 구분용 -->
	<!-- 게시글쓰기 -->
	<div id="insertDiv" style="display: black;">
		<form action="boardInsert" method="post" id="insert_form" enctype="multipart/form-data">
			<label>작성자 : <input type="text" name="mem_name"></label><br>
			<label>ID : <input type="text" name="mem_id"></label><br>
			<label>제목 : <input type="text" name="board_subject"></label><br>
			<label>내용 : <br><textarea name="board_content"></textarea></label><br>
			<input type="button" id="fileUpload" value="파일추가"><br>
			<div id="fileDiv">
			</div>
			<input type="button" id="insert" value="저장">
			<input type="button" id="insertBack" value="뒤로가기">
		</form>
	</div>
	<!-- 상세보기 -->
	<div id="selectDiv" style="display: black;">
			<label>작성자 : ${list[0].get("mem_name") }</label><br>
			<label>ID : ${list[0].get("mem_id") }</label><br>
			<label>제목 : ${list[0].get("board_subject") }</label><br>
			<label>내용 : <br>${list[0].get("board_content") }</label><br>
			<c:forEach items="${list }" var="map">
			<a href = "download?real_name=${map.real_name }&save_name=${map.save_name }&list_seq=${map.list_seq }">${map.real_name }</a>
			</c:forEach>
			<br>
			<input type="button" id="update" value="수정하기">
			<input type="button" id="selectBack" value="뒤로가기">
	</div>
	<!-- 수정하기 -->
	<div id="updateDiv" style="display: black;">
		<form action="board_update" method="get" id="updateForm">
			<input hidden="" value="${map.get("seq") }" name="seq">
			<label>작성자 : <input type="text" name="mem_name" value="${map.get("mem_name") }"></label><br>
			<label>ID : <input type="text" name="mem_id" value="${map.get("mem_id") }"></label><br>
			<label>제목 : <input type="text" name="board_subject" value="${map.get("board_subject") }"></label><br>
			<label>내용 : <br><textarea name="board_content">${map.get("board_content") }</textarea></label><br>
			<input type="button" id="save" value="저장">
			<input type="button" id="updateBack" value="뒤로가기">
		</form>
	</div>
</body>
<script type="text/javascript">
	//null,"",undefined 체크용 함수
	function chk(e) {
		if(e.val()==null||""==e.val()||e.val()=="undefined"){
			return true;
		}else{
			return false;
		}
	}
	//화면 구분함수 1: 게시글작성화면 2: 상세보기 화면
	function displaySet() {
		if($("#displayNum").val()==1){
			$("#insertDiv").css('display', 'block');
			$("#selectDiv").css('display', 'none');
			$("#updateDiv").css('display', 'none');
		}else if($("#displayNum").val()==2){
			$("#insertDiv").css('display', 'none');
			$("#selectDiv").css('display', 'block');
			$("#updateDiv").css('display', 'none');
		}else if($("#displayNum").val()==3){
			$("#insertDiv").css('display', 'none');
			$("#selectDiv").css('display', 'none');
			$("#updateDiv").css('display', 'block');
		}
	}
	$(function() {
		//선택된화면 체크
		displaySet();
		//수정화면 저장버튼클릭시
		$("#save").click(function() {
			if(chk($("#updateDiv [name=mem_name]"))){
				alert("작성자를 입력하세요.");
			}else if(chk($("#updateDiv [name=mem_id]"))){
				alert("ID를 입력하세요.");
			}else if(chk($("#updateDiv [name=board_subject]"))){
				alert("제목을 입력하세요.");
			}else if(chk($("#updateDiv [name=board_content]"))){
				alert("내용을 입력하세요.");
			}else{
				$.ajax({
					url : "board_update",
					type : "POST",
					dataType : "json",
					data : $("#updateForm").serialize(),
					success : function(data) {
						let html = ""
						html += "<label>작성자 : "+data.mem_name+"</label><br>";
						html += "<label>ID : "+data.mem_id+"</label><br>";
						html += "<label>제목 : "+data.board_subject+"</label><br>";
						html += "<label>내용 : <br>"+data.board_content+"</label><br>";
						html += "<input type='button' id='update' value='수정하기'>";
						html += "<input type='button' id='selectBack' value='뒤로가기'>";
						$("#selectDiv").html(html);
						$("#displayNum").val(data.display);
						displaySet();
					}
				})
				//$("#updateForm").submit();
			}
		})
		//게시글 등록버튼 클릭시
		$("#insert").click(function() {
			let formData = new FormData(document.getElementById('insert_form'));
			if(chk($("[name=mem_name]"))){
				alert("작성자를 입력하세요.");
			}else if(chk($("[name=mem_id]"))){
				alert("ID를 입력하세요ssss.");
			}else if(chk($("[name=board_subject]"))){
				alert("제목을 입력하세요.");
			}else if(chk($("[name=board_content]"))){
				alert("내용을 입력하세요.");
			}else{
				/* $.ajax({									 
					url : "board_insert",
					type : "post",
					dataType : "json",
					data : $("#insert_form").serialize(),
					success : function(data) {
						if(data==1){
							alert('저장 완료');
						}
						location.href = "board";
					}
				}) */
				/* $.ajax({									 
					url : "board_insert",
					type : "post",
					dataType : "json",
					data : formData,
					success : function(data) {
						if(data==1){
							alert('저장 완료');
						}
						location.href = "board";
					}
				}) */
				$("#insert_form").submit();
			}
		})
		//수정하기버튼 클릭시 화면 전환
		$("#update").click(function() {
			$("#displayNum").val(3);
			displaySet();
		})
		//(글작성, 상세보기, 수정하기) 뒤로가기
		$("#insertBack").click(function() {
			location.href = "board";
		})
		$("#selectBack").click(function() {
			location.href = "board";
		})
		$("#updateBack").click(function() {
			location.href = "board_one_view?seq=${map.get('seq') }";
		})
		
		$("#fileUpload").click(function() {
			let html = "<div><input type='file' name='file' onchange='check(this)'><input type='button' value='삭제' onclick='fileDel(this)'></div>"
			$("#fileDiv").append(html);
		})
	})
	function fileDel(e) {
		$(e).parent().remove();
	}
	function check(file) {
		var ext = $(file).val().substring($(file).val().lastIndexOf(".")+1);
		if($(file).val()!=null||$(file).val()!=""){
			alert(file.value);
			var img = new Image();
			img.src = file.value;
			
		}
		
		/*
			fileReadar
			file URL
			new image()
		*/
	}
</script>
</html>