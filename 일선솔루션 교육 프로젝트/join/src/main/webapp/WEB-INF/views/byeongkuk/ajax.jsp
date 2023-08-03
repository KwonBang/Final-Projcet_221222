<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<form action="search" method="POST" id="searchId">
		<input hidden="" value="${pvo.page }" id="page" name="page" >
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
			
			<c:forEach items="${list}" var="list">
				<tr>
					<td><input type="checkbox" name="seq" value="${list.seq }"></td>
					<td>${list.seq }</td>
					<td>${list.mem_id }</td>
					<td><a href="board_one_view?seq=${list.seq }">${list.board_subject }</a></td>
					<td>${list.reg_date }</td>
					<td>${list.upt_date }</td>
					<td>${list.view_cnt }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</form>
	<div id="pageDiv">
		<c:if test="${pvo.prev}">
			<a href="Javascript:paging(1);">처음</a>&nbsp;
			<a href="javascript:paging(${pvo.startPage -1});">이전</a>
		</c:if>
		<c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" var="idx">
				<li style="display: inline;" ><a href="javascript:paging(${idx});">${idx}</a>&nbsp;</li>
		</c:forEach>
		<c:if test="${pvo.next}">
			&nbsp;<a href="javascript:paging(${pvo.endPage +1});">다음</a>
		</c:if>
	</div>
    