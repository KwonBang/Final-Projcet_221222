<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<script>
	$(function(){
		$("#all").click(function(){
			if($("#all").is(":checked")){
// 				$("[name=chk]").attr("checked","checked");
				$("[name=chk]").prop("checked",true);
			}else{
// 				$("[name=chk]").removeAttr("checked");
				$("[name=chk]").prop("checked",false);
			}
		})
		
		$("#btn").click(function(){
// 			$("#txt").attr("type","button").attr("class","cls");
// 			var checked = $("[name=chk]:checked").length;
			
// 			if(checked == 0){
// 				alert("항목을 체크");
// 			}else if(checked < 5 || $("#all").is(":checked")){
// 				alert("성공");
// 			}else{
// 				alert("실패");
// 			}

			var txt = "<input type=file>";
			$("#dv1").html(txt);
// 			$("#dv2").append(txt);
			
		})
		
		
	})
	
	function fncCheck(chk){
		var checkbox = $("[name=chk]").length;
		var checked = $("[name=chk]:checked").length;
		
		if(checked == checkbox){
			$("#all").prop("checked", true);
		}else{
			$("#all").prop("checked", false);
		}
		
		if($(chk).is(":checked")){
			$("#dv").append( $(chk).val() );
		}else{
			$("#dv").text( $("#dv").text().replace($(chk).val(), '') );
			
// 			innerHTML
			
		}
		
		if($("#dv").text().indexOf("check") > -1){
// 			.slice(3, 5)
// 			.substr(3, 5)
			
// 			aabbccdd
		}
		
	}
	
</script>
<style>
	.cls{
		font-size: 100px;
	}
</style>

</head>
<body>

	<div id = "dv1">
		<input type = "file">
	</div>
	<div id = "dv2">
		<input type = "file">
	</div>

	<input type = "text" name = "txt" id = "txt" value = "버튼">
	<div>
		<input type = "checkbox" name = "all" id = "all"><label for = "all">전체</label>
		<input type = "button" name = "btn" id = "btn" value = "버튼">
	</div>
	<div> $("div").text()
		<c:forEach begin="1" end = "9" var = "i">
			<input type = "checkbox" name = "chk" id = "chk${i}" onclick = "fncCheck(this)" value = "check${i}">check${i}
		</c:forEach>
	</div>
	<div id = "dv"></div>
</body>
</html>