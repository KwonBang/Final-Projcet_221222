<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hm.VO.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header_nav.jsp" %>
	<h1>학생 보기</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>전화</td>
			<td>주소</td>
			<td>가입일자</td>
			<td>학년</td>
		</tr>
		<% ArrayList<MemberVO> mlist = (ArrayList)request.getAttribute("memberList"); %>
		<%
			for(int i = 0;i<mlist.size();i++){
				MemberVO tempvo = mlist.get(i);
			out.print("<tr>");
			out.print("<td>"+tempvo.getNo()+"</td>");
			out.print("<td>"+tempvo.getName()+"</td>");
			out.print("<td>"+tempvo.getTel()+"</td>");
			out.print("<td>"+tempvo.getAddress()+"</td>");
			out.print("<td>"+tempvo.getJoindate()+"</td>");
			out.print("<td>");
			if(tempvo.getGrade().equals("1")){
				out.print("A");
			}else if(tempvo.getGrade().equals("2")){
				out.print("B");
			}else if(tempvo.getGrade().equals("3")){
				out.print("C");
			}else if(tempvo.getGrade().equals("4")){
				out.print("D");
			}
			out.print("</td>");
			out.print("<td><input type='button' value='삭제'></td>");
			out.print("</tr>");
			}
		%>
<%@ include file="footer.jsp" %>
</body>
</html>