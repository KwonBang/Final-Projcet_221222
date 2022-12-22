<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hrd.VO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="top_nav.jsp"%>
	<% ArrayList<ViewMoneyVO> totalList = (ArrayList)request.getAttribute("totalList"); %>
	<h1>회원매출조회</h1>
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>고객등급</td>
			<td>매출</td>
		</tr>
		<%
			for(int i = 0;i<totalList.size();i++){
				ViewMoneyVO tempvo = totalList.get(i);
				out.print("<tr>");
				out.print("<td>"+tempvo.getCustno()+"</td>");
				out.print("<td>"+tempvo.getCustname()+"</td>");
				out.print("<td>");
				if(tempvo.getCustgrade().equals("A")){
					out.print("VIP");
				}else if(tempvo.getCustgrade().equals("B")){
					out.print("일반");
				}else if(tempvo.getCustgrade().equals("C")){
					out.print("직원");
				}
				out.print("</td>");
				out.print("<td>"+tempvo.getTotalprice()+"</td>");
				out.print("</tr>");
			}
		%>
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>