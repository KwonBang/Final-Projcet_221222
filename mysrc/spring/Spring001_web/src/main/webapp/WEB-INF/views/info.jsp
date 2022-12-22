<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/resources/css/shopping.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/home.css">
</head>
<body>
	<%@ include file="header_nav.jsp"%>
	<%@ page import="java.util.*"%>
	<%@ page import="com.human.vo.*"%>
	<section>
		<center><h1>자세히 보기</h1></center>
		<% VipcusVO vvo = (VipcusVO)request.getAttribute("vvo"); %>
		<table class="list">
			<tr>
				<td colspan="6" style="border: white; text-align: right">
				<input type="button" value="창닫기" onClick="window.close()">
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>포인트</th>
				<th>등록날짜</th>
				<th>등급</th>
			</tr>
			<%
               out.print("<tr class='record'>");
               out.print("<td>"+vvo.getId()+"</td>");   
               out.print("<td>"+vvo.getName()+"</td>");
               out.print("<td>"+vvo.getTel()+"</td>");
               out.print("<td>"+vvo.getPoint()+"</td>");
               out.print("<td>"+vvo.getDt()+"</td>");
               out.print("<td>"+vvo.getGrade()+"</td>");
               out.print("</tr>");
         %>
		</table>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>