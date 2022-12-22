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
	<%@ page import="java.util.*"%>
	
   <div id="wrap" align="center">
      <h1>게시글 상세보기</h1>
      <table>
         <tr>
            <th>글번호</th>
            <td>${boardVO.getNum() }</td>
            <th>작성자</th>
            <td>${boardVO.getName() }</td>
         </tr>
         <tr>
            <th>작성일</th>
            <td>${boardVO.getIndate() }</td>
            <th>아이디</th>
            <td>${boardVO.getId() }</td>
         </tr>
         <tr>
            <th>제목</th>
            <td colspan="3">${boardVO.getTitle() }</td>
         </tr>
         <tr>
            <th>내용</th>
            <td colspan="3">${boardVO.getContent() }</td>
         </tr>
      </table>
      <br> <br> <input type="button" value="게시글 수정"
         >
      <input type="button" value="게시글 삭제"
         >
      <input type="button" value="게시글 리스트"
         > 
      <input type="button" value="게시글 등록"
         >
   </div>
</body>
</html>