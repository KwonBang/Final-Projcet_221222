<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/home.css">
</head>

<body>
	<%@ include file="header_nav.jsp" %>
<%@ page import="java.util.*"%>
<%@ page import="com.human.vo.*" %>
<%
   ArrayList<VipcusVO> list = (ArrayList)request.getAttribute("list");
   //out.print(al.size() +" / 가나다라마바사 <br>" );

   //for(int i=0; i < al.size(); i++){
//      BoardVO bvo = al.get(i);
   //   out.print(bvo.getNum());
//      out.print(bvo.getName());
   //   out.print("<hr>");      
//   }
%>
  <section>
   <div id="wrap" align="center">
      <h1>회원 목록</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right"><a
               href="movejoin">회원 등록</a></td>
         </tr>
         <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>포인트</th>
            <th>수정/삭제</th>
         </tr>
         <!-- 아래 Tr 이 게시글 수 만큼 반복.. -->
         
         <%
         if(list.size()==0){
            out.print("<tr class='record'>");
            out.print("<td colspan=5>등록된 글이 없습니다.</td>");
            out.print("</tr>");
         }else{
            for(int i=0; i < list.size(); i++){
            	VipcusVO vvo = list.get(i);
               out.print("<tr class='record'>");
               out.print("<td>"+vvo.getId()+"</td>");   
               out.print("<td><a href="+request.getContextPath()+"/selectOne?id="+vvo.getId()+" target='_blank'>"+
               vvo.getName()+"</a></td>");
               out.print("<td>"+vvo.getTel()+"</td>");
               out.print("<td>"+vvo.getPoint()+"</td>");
               out.print("<td><a href="+request.getContextPath()+"/mod_view?id="+vvo.getId()+">"+
                       "m"+"</a>"+"/"+"<a href="+request.getContextPath()+"/del_view?id="+vvo.getId()+">d</a></td>");
               out.print("</tr>");
            }
         }      
         
         %>
            
         <!-- 아래 Tr 이 게시글 수 만큼 반복.. -->
      </table>
   </div>
   </section>
   	<%@ include file="footer.jsp" %>
</body>
</html>