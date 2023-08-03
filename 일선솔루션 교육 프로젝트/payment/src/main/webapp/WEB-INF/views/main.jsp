<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<style>
	.divCenter{
		width: 450px;
		margin: auto;
		height: 50px;
	}
	
</style>
<body>
	<div style="width: 800px; margin: auto; height: 600px;">
		<div class="divCenter">
			<label>${sessionName }(${sessionRank }) 님 환영합니다.</label>&nbsp;<input type="button" value="로그아웃">
			<br>
				<input type="button" value="글쓰기">&nbsp;
				<input type="button" value="대리결재">
		</div>
		<div class="divCenter" style="border: solid;">
			<form action="search" method="post">
				<select name="searchType">
					<option value="">선택</option>
						<option value="w">작성자</option>
						<option value="p">결재자</option>
						<option value="tc">제목+내용</option>
				</select>
				<input type="text" placeholder="검색어를 입력하세요" name="searchText" value="${map.searchText }">
				<select id="status" >
					<option value="">결재상태</option>
					<option value="1">임시저장</option>
					<option value="2">결재대기</option>
					<option value="3">결재중</option>
					<option value="4">결재완료</option>
					<option value="0">반려</option>
				</select>
				<br>
				<input type="date" name="startDate" value="${map.startDate }">&nbsp;&nbsp;~&nbsp;<input type="date" name="endDate" value="${map.endDate }">&nbsp;<input type="button" value="검색">
			</form>
		</div>
		<br>
		<div class="divCenter">
			<table style="border-top: solid; border-bottom: solid;" border="1">
				<tr>
					<td>번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
					<td>결재일</td>
					<td>결재자</td>
					<td>결재상태</td>
				</tr>
				<tbody id="ajaxList">
					<c:choose>
						<c:when test='${list[0] != null}'>
							<c:forEach items="${list }" var="list">
								<tr onclick="select(${list.listno})">
									<td>${list.listno }</td>
									<td>${list.writer_id }</td>
									<td>${list.title }</td>
									<td>${list.create_date }</td>
									<td>${list.payment_date }</td>
									<td>${list.payment_id }</td>
									<td>${list.payment_status }</td>
								</tr>
							</c:forEach>
						</c:when>
					<c:otherwise>
						<tr>
							<td colspan="7">게시글이 없습니다.</td>
						</tr>
					</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
<script>
	function select(listno){
		location.href="payment?listno="+listno;
	}
	$("[name=searchType]").val('${map.searchType }');
	$(function(){
		$("[value=로그아웃]").on("click",function(){
			location.href="logout";
		})
		$("[value=글쓰기]").on("click",function(){
			location.href="write";
		})
		$("[value=검색]").on("click",function(){
			$("form").submit();
		})
		$("#status").on("change",function(){
			let status = $("#status").val();
			$.ajax({
				url : "statusSearch"
				,data : {"status" : status}
				,dataType : "json"
				,type : "post"
				,success : function(list){
					alert("성공");
					let html = "";
					if(list.length==0){
						html += "<tr><td colspan='7'>게시글이 없습니다.</td></tr>";
					}else{
						for(let data of list){
							html += "<tr onclick='select("+data.listno+")'>";
							html += "<td>"+data.listno+"</td>";
							html += "<td>"+data.writer_id+"</td>";
							html += "<td>"+data.title+"</td>";
							html += "<td>"+data.create_date+"</td>";
							html += "<td>"+data.payment_date+"</td>";
							html += "<td>"+data.payment_id+"</td>";
							html += "<td>"+data.payment_status+"</td>";
							html += "</tr>";
						}
					}
					$("#ajaxList").html(html);
				}
				,error : function(){
					alert("실패");
				}
			})
		})
	})
</script>
</html>