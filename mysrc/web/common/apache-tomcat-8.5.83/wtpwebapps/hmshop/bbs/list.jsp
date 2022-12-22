<%@page import="hmshopVO.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<%
		ArrayList<BoardVO> list = (ArrayList) request.getAttribute("list");
	%>
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<form action="del_servlet" method="get">
		<table class="list">
			<tr>
				<td colspan="6" style="border: white; text-align: right"><a
					href="insertView_servlet">게시글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>아이디</th>
				<th>체크</th>
			</tr>
			<%
				if(list.size() == 0) {
					out.print("<tr class='record'>");
					out.print("<td colspan=6>등록된 글이 없습니다.</td>");
					out.print("</tr>");
				}else {
					for(int i = 0; i < list.size(); i++) {
						BoardVO boardVO = list.get(i);
						out.print("<tr class='record'>");
						out.print("<td><a href="+request.getContextPath()+"/select_servlet?no="+boardVO.getNum()+">"
						+ boardVO.getNum() + "</td>");
						if(boardVO.getChkbox().equals("Y")) {
							out.print("<td>*"+boardVO.getTitle()+"</td>");
						}else {
							out.print("<td>"+boardVO.getTitle()+"</td>");
						}
						out.print("<td>" + boardVO.getName() + "</td>");
						out.print("<td>" + boardVO.getIndate() + "</td>");
						out.print("<td>" + boardVO.getId() + "</td>");
						out.print("<td><input name='del_num' type='checkbox' value="+boardVO.getNum()+"></td>");
						out.print("</tr>");
					}
				}
				%>
		</table>
			<input type="submit" id="del_btn" value="선택 삭제" style="float:right">
		</form>
	</div>
</body>
</html>