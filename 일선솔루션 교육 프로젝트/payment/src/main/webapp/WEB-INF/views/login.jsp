<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	<form action="login" method="post">
		<div>
			<div>로그인</div>
			<div>아이디 : <input type="text" name="id" placeholder="아이디를 입력하세요"></div>
			<div>비밀번호 : <input type="password" name="password" placeholder="비밀번호를 입력하세요"></div>
			<div><input type="button" id="loginBtn" value="로그인"></div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function chk(chk) {
		if(chk==null||""==chk||chk=="undefined"){
			return true;
		}else{
			return false;
		}
	}
	$(function() {
		$("#loginBtn").on("click",function(e){
			let formdata = $("form").serialize();
			let id = $("[name=id]").val();
			let password = $("[name=password]").val();
			if(chk(id)){
				alert("아이디를 입력하세요.");
			}else if(chk(password)){
				alert("비밀번호를 입력하세요.");
			}else{
				$.ajax({
					url : "login"
					,type : "post"
					,data : formdata
					,success : function(data) {
						if(data=="성공"){
							location.href="main";
						}else{
						alert(data);
						}
					}
					,error : function() {
						alert("실패");
					}
				})
			}
		})
	})
</script>
</html>