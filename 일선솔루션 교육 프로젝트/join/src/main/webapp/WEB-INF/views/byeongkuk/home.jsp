<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>Home</title>
</head>
<body>
<input type="text" value="${a }">
	<div>
		<ul>
			<li>id : 문자(영어), 숫자만, 체크버튼 클릭시 유효성검사 </li>
			<li>pw : 비밀번호, 비밀번호확인 일치하는지 체크(가입신청버튼 클릭시)</li>
			<li>이름 : 5글자(maxlength x)-script 문자(한글,영어) 5글자 넘어갈 시 바로 체크</li>
			<li>이메일 : 이메일유효성검사(가입신청버튼 클릭시)</li>
			<li>휴대폰 : 숫자만 4자리 입력하면 3번째 창으로 커서이동</li>
			<li>주민번호 : 숫자만, 주민번호 유효성검사 입력시 뒷자리 맨첫자리만 숫자 1******</li>
			<li>가입신청버튼 : 버튼 클릭시 null, "", 값체크 모든데이터 입력시 submit</li>
		</ul>
	</div>
	<form action="#" method="get" id="joinform">
 		<table width="1400" height="650">
  			<tr>
   				<td width="100%" height="10%">회원가입
   				</td>
  			</tr>
  			<tr>
   				<td height="60%" align="center" valign="top">
   				<hr><br>
   				<p align="left" style="padding-left:160px">
   				<br><br>
   				ID : <input type="text" size="10" maxlength="15" name="id" id = "id">
   				<input type = "button" name = "idChk" value = "체크" onclick="chk()">
  				 <br><br>
   				비밀번호 : <input type="password" size="15" maxlength="20" name="pass" id = "pass"><br><br>
  				 비밀번호 확인 : <input type="password" size="15" maxlength="20" name="pass2" id = "pass2"><br><br>
  				 이름 : <input type="text" size="13" name="name" id = "name" onkeyup="namelength()"><br><br>
   				이메일 : <input type="text" size="15" name="email1" id = "email1">@<input type="text" size="15" name="email2" id = "email2"><br><br>
   				휴대폰 : <select name="ph1" id="ph1">
					       <option value="010">010</option>
					       <option value="011">011</option>
					       <option value="016">016</option>
					       <option value="017">017</option>
					       <option value="019">019</option>
					   </select>
				     - <input type="text" name="ph2" size="5" maxlength="4" id = "ph2" onkeyup="ph_focus()"> - <input type="text" name="ph3" size="5" maxlength="4" id = "ph3" onkeyup="ph3_set()"><br><br>
				   성별 : <input type="radio" name="gender" value="남자"> 남자&nbsp;&nbsp;
				   <input type="radio" name="gender" value="여자"> 여자<br><br>
				   주민번호 : <input type = "text" name = "jumin1" id = "jumin1" onkeyup="jumin_focus()"> -<input type="text" name="jumin2" id="jumin2" hidden="">  <input type = "text" name = "juminhide" id = "juminhide" onkeyup="jumin_hide()"><br><br>
				   주소 : <input type="text" name="address" size="15" maxlength="15"><br>
				   *주소는 (시/도)만 입력해주세요 (예: 경기도, 서울특별시, 경상남도 등)
				   </p>
				  </td>
			</tr>
			<tr>
				   <td align="center">
				   <hr><br>
				    <input type="button"  id = "regi_btn" value="가입신청" onclick="join()">&nbsp;
				    <input type="reset" value="다시입력">&nbsp;
				    <input type="button" value="취소" onclick="nullchk()">
				  </td>
  			</tr>
	</table>
</form>
</body>
<script type="text/javascript">
	var joinform = document.getElementById("joinform");		
	var idChk = document.getElementById("idChk");			
	var id = document.getElementById("id");					
	var pass = document.getElementById("pass");				
	var pass2 = document.getElementById("pass2");			
	var email1 = document.getElementById("email1");			
	var email2 = document.getElementById("email2");			
	var emailchk = /^[A-Za-z0-9]+$/;						
	var emailchk2 = /^[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;		
	var regi_btn = document.getElementById("regi_btn");		
	var pattern = /[^A-Za-z0-9]+$/;							
	var ph1 = document.getElementById("ph1");				
	var jumin1 = document.getElementById("jumin1");			
	var jumin2 = document.getElementById("jumin2");			
	var juminhide = document.getElementById("juminhide");	
	var juminchk = /^[0-9]+$/;								
	var namechk = document.getElementById("name");			
	var ph2 = document.getElementById("ph2");				
	var ph3 = document.getElementById("ph3");				
	var gender = document.getElementsByName("gender");		
	function chk() {
		if(nullchk(id.value)){
			alert("아이디를 입력하세요");
		}else if(pattern.test(id.value)){
			alert("영어와 숫자만 가능");
		}else{
			alert("사용가능");
		}
	}
	function namelength() {
		namechk.value = namechk.value.replace(/[^a-zA-Zㄱ-ㅎ가-힣]/,"");
		if(namechk.value.length>5){
			alert("5글자이내로 입력하세요");
			namechk.value = namechk.value.substr(0, 5);
		}
	}
	function ph_focus() {
		ph2.value = ph2.value.replace(/[^0-9]/,"");
		if(ph2.value.length>=4){
			ph3.focus();
		}
	}
	function ph3_set() {
		ph3.value = ph3.value.replace(/[^0-9]/,"");
	}
	function jumin_focus() {
		jumin1.value = jumin1.value.replace(/[^0-9]/,"");
		if(jumin1.value.length==6){
			jumin3.focus();
		}
	}
	function jumin_hide() {
		/*jumin2.value = juminhide.value;
		let str;
		jumin2.value = jumin2.value.replace(/[^0-9]/, "");
		
		if(juminhide.value.length <= 7){
			jumin2.value = juminhide.value;
			str = juminhide.value.substr(0, 1);
			str += juminhide.value.substring(1).replace(/[^*]/, "*");
			juminhide.value = str;
		}else if(juminhide.value.length > 7){
			juminhide.value = juminhide.value.substr(0, 7);
			jumin2.value = juminhide.value;
			str = juminhide.value.substr(0, 1);
			str += juminhide.value.substring(1).replace(/[^0-9][^*]/, "*");
			jumin3 = str;
			alert("주민번호는 7글자 입니다.");
		}*/
		juminhide.value = juminhide.value.replace(/[^0-9]/, "");
		if(juminhide.value.length > 7){
			juminhide.value = juminhide.value.substr(0, 7);
			alert("주민번호는 7글자 입니다.");
			jumin2 = juminhide.value;
		}else{
			jumin2 = juminhide.value;
		}
	}
	function nullchk(chk) {
		if(typeof chk.value == "undefined"||""==chk.value||chk.value==null){
			chk.focus();
			return true;
		}else{
			return false;
		}
	}
	function join() {
		if(nullchk(id)){
			alert("아이디를 입력하세요.");
		}else if(nullchk(pass)||nullchk(pass2)){
			alert("비밀번호를 입력하세요.");
		}else if(pass.value!=pass2.value){
			alert("비밀번호를 확인하세요.");
		}else if(nullchk(namechk)){
			alert("이름을 입력하세요.");
		}else if(nullchk(email1)||nullchk(email2)){
			alert("이메일을 입력하세요.");
		}else if(!emailchk.test(email1.value)||!emailchk2.test(email2.value)){
			alert("이메일 형식이 잘못 되었습니다.");
		}else if(gender[0].checked==false&&gender[1].checked==false){
			alert("성별을 선택하세요.");
		}else if(nullchk(jumin1)||nullchk(jumin2)){
			alert("주민번호를 입력하세요.");
		}else if(!juminchk.test(jumin1.value)||!juminchk.test(jumin2.value)){
			alert("주민번호는 숫자만 입력 가능합니다.");
		}else{
			jumin2.value = jumin3.value;
			jumin3.value = jumin3.value.substr(0,1)+jumin3.value.substring(1).replace(/[0-9]/g,"*");
			joinform.submit();
		}
	}
</script>
</html>
