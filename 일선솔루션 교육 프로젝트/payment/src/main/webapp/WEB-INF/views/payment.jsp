<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	<input type="hidden" value="${map.rank }" name="rank">
	<table border="1">
		<tr>
			<td>결재요청</td>
			<td>과장</td>
			<td>부장</td>
		</tr>
		<tr>
			<td><input type="checkbox" disabled="disabled" name="p1"></td>
			<td><input type="checkbox" disabled="disabled" name="p2"></td>
			<td><input type="checkbox" disabled="disabled" name="p3"></td>
		</tr>
	</table>
	<form method="post">
	<div>
		번호 : <input type="text" value="${map.listno }" readonly="readonly" name="listno">
		<br>
		작성자 : <input type="text" value="${map.name }" readonly="readonly">
		<input type="hidden" value="${map.id }" id="id">
		<br>
		제목 : <input type="text" value="${map.title }" name="title">
		<br>
		내용 : 
		<br>
		<textarea name="contents" rows="5" cols="30">${map.contents }</textarea>
		<br>
		<input type="hidden" value="${map.payment_status }" name="payment_status">
			<input type="button" value="반려">
			<input type="button" value="결재">
	</div>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>결재일</td>
				<td>결재자</td>
				<td>결재상태</td>
			</tr>
			<c:choose>
				<c:when test="${list[0]!=null }">
					<c:forEach items="${list }" var="paymentList">
						<tr>
							<td>${paymentList.no }</td>
							<td>${paymentList.payment_date }</td>
							<td>${paymentList.name }</td>
							<td>${paymentList.payment_status }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">게시글이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		</form>
</body>
	<script>
	var pay = '${pay}';
		function rankCheck() {
			switch ($("[name=payment_status]").val()) {
			case '4':
				$("[name=p1]").prop("checked",true);
				$("[name=p2]").prop("checked",true);
				$("[name=p3]").prop("checked",true);
				break;
			case '3':
				$("[name=p1]").prop("checked",true);
				$("[name=p2]").prop("checked",true);
				break;
			case '2':
				$("[name=p1]").prop("checked",true);
				break;
			
			}
			switch ($("[name=rank]").val()) {
				case "사원": 
				case "대리":
					$("[value=반려]").attr("value","임시저장");
					if(pay=="insert"){
						$("form").attr("action","insert");
						$("#id").attr("name","writer_id");
					}else{
						$("form").attr("action","update");
					}
					if($("[name=payment_status]").val()!=1 && $("[name=payment_status]").val()!=""&& $("[name=payment_status]").val()!=0){
						$("[name=title]").attr("readonly","readonly");
						$("[name=contents]").attr("readonly","readonly");
						$("[value=임시저장]").css('display','none');
						$("[value=결재]").css('display','none');
					}
					break;
				case "과장":
					if(pay=="insert"){
						$("form").attr("action","insert");
						$("#id").attr("name","writer_id");
						$("[value=반려]").attr("value","임시저장");
					}else{
						$("form").attr("action","update");
						if($("[name=payment_status]").val()!=1 && $("[name=payment_status]").val()!=""){
							$("#id").attr("name","payment_id");
							$("[name=title]").attr("readonly","readonly");
							$("[name=contents]").attr("readonly","readonly");
						}else{
							$("[value=반려]").attr("value","임시저장");
						}
					}
					if($("[name=payment_status]").val()!=2&&$("[name=payment_status]").val()!=1&& $("[name=payment_status]").val()!=""){
						$("[value=반려]").css('display','none');
						$("[value=결재]").css('display','none');
					}
					break;
				case "부장":
					if(pay=="insert"){
						$("form").attr("action","insert");
						$("#id").attr("name","writer_id");
						$("[value=반려]").attr("value","임시저장");
					}else{
						$("form").attr("action","update");
						if($("[name=payment_status]").val()!=1 && $("[name=payment_status]").val()!=""){
							$("#id").attr("name","payment_id");
							$("[name=title]").attr("readonly","readonly");
							$("[name=contents]").attr("readonly","readonly");
						}else{
							$("[value=반려]").attr("value","임시저장");
						}
					}
					if($("[name=payment_status]").val()!=3&&$("[name=payment_status]").val()!=1&& $("[name=payment_status]").val()!=""){
						$("[value=반려]").css('display','none');
						$("[value=결재]").css('display','none');
					}
					break;
			}
		}
		$(function() {
			rankCheck();
			$("[value=임시저장]").on("click",function(){
				$("[name=payment_status]").val(1);
				$("form").submit();
			})
			$("[value=반려]").on("click",function(){
				$("[name=payment_status]").val(0);
				$("form").submit();
			})
			$("[value=결재]").on("click",function(){
				if($("[name=rank]").val()=='사원'){
					$("[name=payment_status]").val(2);
				}else if($("[name=rank]").val()=='과장'){
					$("[name=payment_status]").val(3);
				}else if($("[name=rank]").val()=='부장'){
					$("[name=payment_status]").val(4);
				}
				$("form").submit();
			})
		})
	</script>
</html>