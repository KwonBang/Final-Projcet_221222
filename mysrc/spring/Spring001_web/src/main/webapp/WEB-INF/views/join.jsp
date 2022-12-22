<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/shopping.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/home.css">
</head>

<body>
	<%@ include file="header_nav.jsp" %>
	<section>
   <div id="wrap" align="center">
      <h1>회원가입</h1>
      <form name="frm" method="post" action="wrAction">
         <table>
            <tr>
               <th>아이디</th>
               <td><input type="text" name="id"> * 필수
                  <input type="button" value="등록여부확인">
                  <input type="hidden" name="duplexChk" vlaue="0">
               
               </td>
            </tr>
            <tr>
               <th>이름</th>
               <td><input type="text" name="name"> * 필수 (게시물 수정
                  삭제시 필요합니다.)</td>
            </tr>
            <tr>
               <th>전화번호</th>
               <td><input type="text" name="tel"></td>
            </tr>
            <tr>
               <th>포인트</th>
               <td><input type="text" name="point" id="point"> * 필수</td>
            </tr>
            <tr>
               <th>등록일</th>
               <td><input type="text" name="dt"></td>
            </tr>
             <tr>
               <th>등급</th>
               <td><select name="grade" id="grade">
               		<option value="vip">vip</option>
               		<option value="일반">일반</option>
               </select> </td>
            </tr>
         </table>
         <br>
         <br> <input type="submit" value="등록"> <input type="reset"
            value="다시 작성"> <input type="button" value="목록"">
      </form>
   </div>
   </section>
   <%@ include file="footer.jsp" %>
</body>
</html>