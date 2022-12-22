<%@page import="hmshopVO.BoardVO"%>
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
	<div id="wrap" align="center">
		<h1>게시글 등록</h1>
		<form name="frm" method="get" action="insert_servlet" id="form">
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th>글번호</th>
					<%
						BoardVO boardVO = (BoardVO) request.getAttribute("no");
						out.print("<td>" + boardVO.getNum() + "<input type='hidden' value='" + boardVO.getNum()
								+ "' name='num'></td>");
					%>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" required minlength="8"
						id="id"> * 필수</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name" required id="name">
						* 필수</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" required id="pass">
						* 필수 (게시물 수정 삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title" id="title">
						* 필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
				<tr>
					<th>비밀글 여부</th>
					<td>
						<input type="radio" name="chkbox" value="Y" onclick="radio()">비밀글O
						<input type="radio" name="chkbox" value="N" onclick="radio()">비밀글X
					</td>
				</tr>
			</table>
			<br> <br> <input type="button" value="등록" onclick="chk()">
			<input type="reset" value="다시 작성"> <input type="button"
				value="목록">
		</form>
	</div>
</body>
<script>
	var select = 0;
	var check = /[~!@#$%^&*()_+|<>?:{}]/;
	var form = document.getElementById('form');
	var id = document.getElementById('id');
	var nname = document.getElementById('name');
	var pass = document.getElementById('pass');
	var title = document.getElementById('title');
	radio = () => {
		select++;
	}
	chk = () => {
		if(id.value.length>=8){
			if(check.test(id.value)){
                if(!nname.value==""){
                    if(!pass.value==""){
                        if(!title.value==""){
                            if(select>0){
                            	select=0;
                                form.submit();
                            }else{
                                alert('비밀글 여부를 선택하세요.');
                            }
                        }else{
                            alert('제목을 입력하세요.');
                        }
                    }else{
                        alert('비밀번호를 하세요.');
                    }
                }else{
                    alert('이름을 입력하세요.');
                }
            }else{
                alert('아이디는 특수문자 1개이상 포함하세요.');
            }
		}else{
            alert('아이디는 8글자 이상 입력하세요.');
		}
	}
</script>
</html>