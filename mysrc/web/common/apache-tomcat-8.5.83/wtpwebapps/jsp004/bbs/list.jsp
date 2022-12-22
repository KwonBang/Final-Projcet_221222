<%@page import="com.human.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/shopping.css">
</head>
<body>
	<!-- 1. 컨트롤러 부터 데이터를 받았는지 먼저 확인 -->
	${bList}
	<hr>
	${bList.get(1).getName()}
	<!-- 2. 데이터를 화면에 맞게 문법을 사용하여 구현 -->
	<!-- el표기법 & jstl 문법.. 우리는 무식한 jsp -->
	<!-- html문서안에 jsp문법을 사용한다.
		 지시자 '<'%'@		다른jsp 파일 include, 자바class import 등
		 jsp코드 '>'%		request.getAtrribute if for out.print -->
	<!-- 학생들에게 꼭 습득하면 좋은 감각
		jsp문법을 몰라서 나는 못한다... - 좋지않은 상황을 바라보는 시야.. 수동적.. 성취감 낮아진다.
		목적(구체적) 컨트롤러에서 넘겨 받은 자료를 화면에 출력하고 싶다. 어떻게 출력 : 표형식에 따라 출력한다.
		분석(구체적) 넘겨받은 자료 : 자료형(객체, 원시) - List
					출력 (테이블의 tr)을 추가하면서 출력한다.	List의 size()만큼 추가된다...
		해결해야 할 과제 선정 후 해결합니다. (구글링)
	 -->
	<%@ page import="java.util.*"%>
	<%
	 	ArrayList<BoardVO> al = (ArrayList)request.getAttribute("bList");
	 	/* out.print(al.size()+" / 가나다라마바사");
	 	for(int i = 0;i<al.size();i++){
	 		BoardVO boardVO = al.get(i);
	 		out.print(boardVO.getNum());
	 		out.print(boardVO.getName());
	 		out.print("<hr>");
	 	} */
	 %>
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="wrForm">게시글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<%
         	if(al.size()==0){
        		 out.print("<tr class='record'>");
            	 out.print("<td colspan=5>등록된 글이 없습니다.</td>");   
             	out.print("</tr>");
         	}else{
         		for(int i = 0;i<al.size();i++){
	 	 			BoardVO boardVO = al.get(i);
	 	 			out.print("<tr class='record'>");
	 	 			out.print("<td>"+boardVO.getNum()+"</td>");
	 	 			out.print("<td><a href="+request.getContextPath()+"/boardView?wno="+boardVO.getNum()+">"+boardVO.getTitle()+"</td>");
	 	 			out.print("<td>"+boardVO.getNum()+"</td>");
	 	 			out.print("<td>"+boardVO.getIndate()+"</td>");
	 	 			out.print("<td>"+boardVO.getCnt()+"</td>");
	 	 			out.print("</tr>");
 	 			}
         	}
        	 %>
		</table>
	</div>
</body>
</html>