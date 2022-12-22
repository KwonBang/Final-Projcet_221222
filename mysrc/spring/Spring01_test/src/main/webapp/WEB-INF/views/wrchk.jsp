<%@page import="com.human.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/shopping.css">
</head>
<body>
	<%ArrayList<BoardVO> list = (ArrayList)request.getAttribute("list"); %>
	<table>
		<tr>
			<td>이름</td>
			<td>제목</td>
			<td>내용</td>
		</tr>
		<%
      for(int i = 0; i < list.size(); i++) {
    	  BoardVO bvo = list.get(i);
         out.print("<tr>");
         out.print("<td>"+bvo.getName()+"</td>");
         out.print("<td>"+bvo.getTitle()+"</td>");
         out.print("<td>"+bvo.getContent()+"</td>");
         out.print("</tr>");
      }
   %>

	</table>
	<a href=".">홈으로</a>
</body>
</html>