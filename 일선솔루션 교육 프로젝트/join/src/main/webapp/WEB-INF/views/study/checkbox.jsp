<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(function(){
// 		.attr("checked","checked")
// 		.prop("checked",true);
		$("#all").click(function(){
			if( $("#all").is(":checked") ){
				$("[name=chk]").prop("checked",true);
			} else{
				$("[name=chk]").prop("checked",false);
			}
			
			
		})
		
		$("#btn").click(function(){
// 			$("#aa").attr("type", "button").attr("class", "cls");
			var checked = $("[name=chk]:checked").length;
			
			if(checked == 0){
				alert("항목을 선택");
			}else if(checked < 5 || $("#all").is(":checked")){
				alert("성공");
			}else{
				alert("실패");
			}
		})
	})
	
	function goCheck(chk){
		var checkbox = $("[name=chk]").length;
		var checked = $("[name=chk]:checked").length;
		
		if(checkbox == checked){
			$("#all").prop("checked",true);
		}else{
			$("#all").prop("checked",false);
		}
		
		if($(chk).is(":checked")){
			$("#dvTxt").append($(chk).val());
		}else{
			var txt = $("#dvTxt").text().replace($(chk).val(), '');
			$("#dvTxt").text(txt);
		}
	}
</script>
<style>
	.cls {
		font-size: 100px;
	}
</style>
</head>
<body>
	<div>
		<input type = "checkbox" name = "all" id = "all"><label for = "all">전체</label>
		<input type = "button" name = "btn" id = "btn" value = "버튼">
	</div>
	<div>
		<c:forEach begin="1" end = "9" var = "i">
			<input type = "checkbox" name = "chk" id = "chk${i}" value = "체크${i}" onclick = "goCheck(this)">체크${i }
		</c:forEach>
	</div>
	<div id = "dvTxt"></div>
</body>
</html>