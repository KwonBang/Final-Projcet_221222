<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginPass" method="get" id="form">
		<input type="text" name="id" id="id">
		<input type="password" name="pwd" id="pwd">
		<input type="button" name="입력" id="sub" value="입력">
		<input type="radio" name="gender" value="man">남자
		<input type="radio" name="gender" value="woman">여자
		<select id="job" name="job">
        	<option>군인</option>
        	<option>일반인</option>
		</select>
		<select multiple id="coffee" name="coffee">
            <option>에스프레소</option>
            <option>카라멜</option>
            <option>라떼</option>
            <option>더치</option>
        </select>
	</form>
</body>
<script>
	var id = document.getElementById('id');
	var pwd = document.getElementById('pwd');
	var form = document.getElementById('form');
	sub.onclick = () => {
        var id_text = id.value;
        var pwd_text = pwd.value;
        if(id_text.length>=4&pwd_text.length>=4){
        	form.submit();
        }else{
        	alert('4글자 이상 입력하세요.');
        }
    }
</script>
</html>