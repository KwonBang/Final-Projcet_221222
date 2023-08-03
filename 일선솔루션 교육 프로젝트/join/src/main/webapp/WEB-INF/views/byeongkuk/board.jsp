<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.1.min.js"></script>
<style type="text/css">
	ul{
		list-style: none;
	}
	li{
		display: inline;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
		<form action="search" method="POST" id="searchId">
			<input hidden="" value="1" id="page" name="page" >
			<div>
				<select id="searchType" name="searchType">
					<option value="">선택</option>
					<option value="W">작성자</option>
					<option value="T">제목</option>
					<option value="TC">제목+내용</option>
				</select>
				<input type="text" id="searchText" name="searchText">&nbsp;<input type="button" value="검색" id="searchButton" onclick="sear()">
			</div>
			<div>
				<input type="date" id="startDate" name="startDate">&nbsp;~&nbsp;<input type="date" id="endDate" name="endDate">
			</div>
		</form>
		<form action="delete_Controller" method="get" id="deleteForm">
			<input type="button" value="글쓰기" onclick="location.href='board_insert_view'">
			<input type="button" value="삭제" id="delete">
			<table border="1" id="boardTable">
				<tr>
					<td><input type="checkbox" id="AllCheck" name="AllCheck"></td>
					<td>글번호</td>
					<td>작성자(ID)</td>
					<td>제목</td>
					<td>작성일</td>
					<td>수정일</td>
					<td>조회수</td>
				</tr>
				<tbody id="tBody">
				</tbody>
			</table>
		</form>
		<div id="pageDiv">
		</div>
</body>
<script type="text/javascript">
	var pvo;	//ajax로받은 페이징vo
	var list;	//ajax로받은 게시판리스트
	//페이지클릭시
	function paging(num) {
		$("#page").val(num);
		pvo.page= $("#page").val();
		$.ajax({
			url : "pagingJSP",
			type : "post",
			data : pvo,
			dataType : "html",
			success : function(data) {
				$("body").empty();
				$("body").html(data);
			},
			error : function(){
				alert("실패");
			}
		})
		/* $.ajax({
				url : "paging", //action
				type : "POST",//method
				data : pvo,//param
				dataType : "json",
				//contentType : ,param type
				success : function(data) {
					list = data.list;
					pvo = data.pvo;
					let board = "";
					let page = "";
					for(let i = 0;list.length>i;i++){
						board += "<tr>";
						board += "<td><input type='checkbox' name='seq' value='"+list[i].seq+"'></td>";
						board += "<td>"+list[i].seq+"</td>";
						board += "<td>"+list[i].mem_id+"</td>";
						board += "<td><a href='board_one_view?seq="+list[i].seq+"'>"+list[i].board_subject+"</a></td>";
						board += "<td>"+list[i].reg_date+"</td>";
						board += "<td>"+list[i].upt_date+"</td>";
						board += "<td>"+list[i].view_cnt+"</td>";
						board += "</tr>";
					}
					$("#tBody").html(board);
					if(pvo.prev){
						page += "<a href='Javascript:paging(1);'>처음</a>&nbsp;"+
							"<a href='javascript:paging("+(pvo.startPage-1)+");'>이전</a>";
					}
					for(let i = pvo.startPage;i<=pvo.endPage;i++){
						page += "<li style='display: inline;'><a href='javascript:paging("+i+");'>"+i+"</a>&nbsp;</li>";
					}
					if(pvo.next){
						page += "&nbsp;<a href='javascript:paging("+(pvo.endPage+1)+");'>다음</a>";
					}
					$("#pageDiv").html(page);
				},
				error : function() {
					alert("실패");
				}
			}) */
	}
	function sear() {
		let searchId = $("#searchId").serialize();
		$.ajax({
			url : "search", //action
			type : "POST",//method
			data : searchId,//param
			dataType : "json",
			//contentType : ,param type
			success : function(data) {
				list = data.list;
				pvo = data.pvo;
				let board = "";
				let page = "";
				for(let i = 0;list.length>i;i++){
					board += "<tr>";
					board += "<td><input type='checkbox' name='seq' value='"+list[i].seq+"'></td>";
					board += "<td>"+list[i].seq+"</td>";
					board += "<td>"+list[i].mem_id+"</td>";
					board += "<td><a href='board_one_view?seq="+list[i].seq+"'>"+list[i].board_subject+"</a></td>";
					board += "<td>"+list[i].reg_date+"</td>";
					board += "<td>"+list[i].upt_date+"</td>";
					board += "<td>"+list[i].view_cnt+"</td>";
					board += "</tr>";
				}
				$("#tBody").html(board);
				if(pvo.prev){
					page += "<a href='Javascript:paging(1);'>처음</a>&nbsp;"+
						"<a href='javascript:paging("+(pvo.startPage-1)+");'>이전</a>";
				}
				for(let i = pvo.startPage;i<=pvo.endPage;i++){
					page += "<li style='display: inline;'><a href='javascript:paging("+i+");'>"+i+"</a>&nbsp;</li>";
				}
				if(pvo.next){
					page += "&nbsp;<a href='javascript:paging("+(pvo.endPage+1)+");'>다음</a>";
				}
				$("#pageDiv").html(page);
			},
			error : function() {
				alert("실패");
			}
		})
	}
	$(function() {
		//삭제된 게시글이 있을경우 메시지 출력
		//전체체크 클릭시 전체체크,전체해제
		$("#AllCheck").click(function() {
			if($("#AllCheck").is(":checked")){			//AllCheck가 클릭상태일 경우
				$("[name=seq]").prop("checked",true);	//name이 seq인 객체를 체크 상태로
			}else{										
				$("[name=seq]").prop("checked",false);	//아닐경우 체크해제 상태로
			}
		})
		//체크클릭시  전체체크 체크,해제
		$("[name=seq]").click(function() {
			if($("[name=seq]").length == $("[name=seq]:checked").length){	//전체 체크박스와 선택된 체크박스 수 비교
				$("#AllCheck").prop("checked",true);						//전체 체크박수 수와 선택된 체크박스 수가 같을경우 Allcheck 체크 상태로
			}else{
				$("#AllCheck").prop("checked",false);						//같지 않을경우 AllCheck 체크해제 상태로
			}
		})
		//삭제버튼 클릭시
		$("#delete").click(function() {
			if($("[name=seq]:checked").length==0){			//선택한 체크박스가 없을 경우 메시지 출력
				alert("선택된 항목이 없습니다.");
			}else{
				let delList =[];
				$("[name=seq]:checked").each(function(i) {	//체크된 체크박스 값을 배열에 저장
					delList.push($(this).val());
				});
				$.ajax({									 
					url : "delete_Controller",
					type : "post",
					dataType : "json",
					data : {"delList" : delList},
					success : function(data) {
						alert(data+" 건이 삭제되었습니다.");
						paging(pvo.page);
					}
				})
			}
		})
		//검색버튼 클릭시, 페이지
		/* $("#searchButton").click(function() {
			let searchId = $("#searchId").serialize();
			$.ajax({
				url : "search", //action
				type : "POST",//method
				data : searchId,//param
				dataType : "json",
				//contentType : ,param type
				success : function(data) {
					list = data.list;
					pvo = data.pvo;
					let board = "";
					let page = "";
					for(let i = 0;list.length>i;i++){
						board += "<tr>";
						board += "<td><input type='checkbox' name='seq' value='"+list[i].seq+"'></td>";
						board += "<td>"+list[i].seq+"</td>";
						board += "<td>"+list[i].mem_id+"</td>";
						board += "<td><a href='board_one_view?seq="+list[i].seq+"'>"+list[i].board_subject+"</a></td>";
						board += "<td>"+list[i].reg_date+"</td>";
						board += "<td>"+list[i].upt_date+"</td>";
						board += "<td>"+list[i].view_cnt+"</td>";
						board += "</tr>";
					}
					$("#tBody").html(board);
					if(pvo.prev){
						page += "<a href='Javascript:paging(1);'>처음</a>&nbsp;"+
							"<a href='javascript:paging("+(pvo.startPage-1)+");'>이전</a>";
					}
					for(let i = pvo.startPage;i<=pvo.endPage;i++){
						page += "<li style='display: inline;'><a href='javascript:paging("+i+");'>"+i+"</a>&nbsp;</li>";
					}
					if(pvo.next){
						page += "&nbsp;<a href='javascript:paging("+(pvo.endPage+1)+");'>다음</a>";
					}
					$("#pageDiv").html(page);
				},
				error : function() {
					alert("실패");
				}
			})
		}) */
		//초기화면 입력
		$.ajax({
			url : "search", //action
			type : "POST",//method
			dataType : "json",
			//contentType : ,param type
			success : function(data) {
				list = data.list;
				pvo = data.pvo;
				let board = "";
				let page = "";
				for(let i = 0;list.length>i;i++){
					board += "<tr>";
					board += "<td><input type='checkbox' name='seq' value='"+list[i].seq+"'></td>";
					board += "<td>"+list[i].seq+"</td>";
					board += "<td>"+list[i].mem_id+"</td>";
					board += "<td><a href='board_one_view?seq="+list[i].seq+"'>"+list[i].board_subject+"</a></td>";
					board += "<td>"+list[i].reg_date+"</td>";
					board += "<td>"+list[i].upt_date+"</td>";
					board += "<td>"+list[i].view_cnt+"</td>";
					board += "</tr>";
				}
				$("#tBody").html(board);
				if(pvo.prev){
					page += "<a href='Javascript:paging(1);'>처음</a>&nbsp;"+
						"<a href='javascript:paging("+(pvo.startPage-1)+");'>이전</a>";
				}
				for(let i = pvo.startPage;i<=pvo.endPage;i++){
					page += "<li style='display: inline;'><a href='javascript:paging("+i+");'>"+i+"</a>&nbsp;</li>";
				}
				if(pvo.next){
					page += "&nbsp;<a href='javascript:paging("+(pvo.endPage+1)+");'>다음</a>";
				}
				$("#pageDiv").html(page);
			},
			error : function() {
				alert("실패");
			}
		})
	})
</script>
</html>