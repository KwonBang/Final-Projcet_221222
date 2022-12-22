<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header_nav.jsp"%>
	<h1>학생 등록</h1>
	<form action="insert_member" method="get" id="fm">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="text" name="no" id="no" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel"
								placeholder="010-0000-0000" 
                                required
                                pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
                                maxlength="13">
               	</td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" required></td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type="text" name="joindate" required maxlength="8" minlength="8" pattern="[0-9]+"></td>
			</tr>
			<tr>
				<td>학년</td>
				<td><input type="radio" name="grade" value="1" required>1학년 <input
					type="radio" name="grade" value="2">2학년 <input type="radio"
					name="grade" value="3">3학년 <input type="radio" name="grade"
					value="4">4학년</td>
			</tr>
		</table>
	<input type="submit" value="등록" id="smt">
	</form>
	<%@ include file="footer.jsp"%>
</body>
<script type="text/javascript">
	var fm = document.getElementById("fm");
	var smt = document.getElementById("smt");
	smt.onclick = () => {
		if(!fm.no.value==""){
			if(!fm.name.value==""){
				if(!fm.tel.value==""){
					if(!fm.address.value==""){
						if(!fm.grade.value==""){
							if(!fm.joindate.value==""&fm.joindate.value.length==8){
								alert("등록완료");
							}
						}
					}
				}
			}
		}
	}
</script>
</html>