<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<style>
	span{
		width: 130px;
		background-color: yellow;
		display: inline-block;
	}
</style>
<body>
	<div>
		<span>아이디 : </span><input type="text" name="id" placeholder="아이디를 입력하세요">&nbsp;<input type="button" value="중복체크" id="idCheckBtn"><input type="checkbox" hidden="" id="idCheckbox"><div id="idTest" style="display: inline-block;"></div><br>
		<span>비밀번호 : </span><input type="password" name="password" placeholder="비밀번호를 입력하세요"><br>
		<span>비밀번호 확인 : </span><input type="password" name="passwordCheck" placeholder="비밀번호를 입력하세요"><br>
		<span>이름 : </span><input type="text" name="name" placeholder="이름을 입력하세요"><br>
		<span>우편번호 : </span><input type="text" name="postNum">&nbsp;<input type="button" value="우편번호 찾기" id="searchPostNum"><br>
		<span>주소 : </span><input type="text" name="addr" placeholder="주소를 입력하세요"><br>
		<span>상세주소 : </span><input type="text" name="detailAddr" placeholder="상세주소를 입력하세요"><br>
		<span>이메일 : </span><input type="text" name="emailId">&nbsp;@&nbsp;<input type="text" name="emailAddr">
		<select>
			<option value="">선택</option>
			<option value="naver.com">naver.com</option>
			<option value="gmail.com">gmail.com</option>
			<option value="daum.net">daum.net</option>
			<option value="nate.com">nate.com</option>
		</select>&nbsp;<input type="button" value="인증번호" id="emailCheckBtn"><br>
		<span></span><input type="text" name="emailCheckNum" placeholder="인증번호를 입력하세요">&nbsp;<input type="button" value="확인" id="emailCheckNumBtn"><br>
		<span>연락처 : </span><input type="text" name="phoneNum" placeholder="번호를 입력하세요">&nbsp;<input type="button" value="인증번호" id="phoneCheckBtn"><br>
		<span></span><input type="text" name="phoneCheckNum" placeholder="인증번호를 입력하세요">&nbsp;<input type="button" value="확인" id="phoneCheckNumBtn"><br>
		<span></span><input type="button" value="회원가입" id="joinBtn">
	</div>
	<table>
		<tr>
			<td>이름</td>
			<td>나이</td>
			<td>직업</td>
		</tr>
		<tr>
			<td>kim</td>
			<td>20</td>
			<td title="학생">student</td>
		</tr>
		<tr>
			<td>lee</td>
			<td>25</td>
			<td title="프로그래머">programmer</td>
		</tr>
		<tr>
			<td>choi</td>
			<td>30</td>
			<td title="의사">doctor</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function nullCheck(chk) {
		if(typeof chk.val()=='undefined'||chk.val()==null||''==chk.val()){
			chk.focus();
			return true;
		}else{
			return false;
		}
	}
	$(function() {
		$("#btnz").hover(function() {
			$("#btnz").css("color","red");
		},function(){
			$("#btnz").css("color","black");
		})
		//아이디 수정시 중복체크 해제
		$("[name=id]").on("keyup",function(){
			var idTest = /^[a-zA-Z0-9]*$/;
			$("#idCheckbox").prop("checked",false);
			if(!idTest.test($("[name=id]").val())){
				$("#idTest").html("영문과 숫자만 입력가능 합니다.");
				$("#idTest").css({"color": "red"});
			}else{
				$("#idTest").html("");
			}
		})
		//아이디중복체크버튼
		$("#idCheckBtn").on("click",function(){
			$.ajax({
				url : "idCheck",
				type : "post",
				data : {"id" : $("[name=id]").val()},
				datatype : "json",
				success : function(data) {
					if(data.id==1){
						$("#idCheckbox").prop("checked",true);
						alert("사용할 수 있는 아이디 입니다");
						$("[name=password]").focus();
					}else{
						alert("중복된 아이디입니다.");
						$("[name=id]").val("");
						$("[name=id]").focus();
					}
				}
			})
		})
		//회원가입 버튼
		$("#joinBtn").on("click",function(){
			if(nullCheck($("[name=id]"))){
				alert("아이디를 입력하세요");
			}else if(!$("#idCheckbox").is(":checked")){
				alert("중복체크가 필요합니다");
				$("#idCheckbox").focus();
			}else if(nullCheck($("[name=password]"))){
				alert("비밀번호를 입력하세요");
				$("[name=password]").focus();
			}else if(nullCheck($("[name=passwordCheck]"))){
				alert("비밀번호확인을 입력하세요");
				$("[name=passwordCheck]").focus();
			}else if($("[name=password]").val()!=$("[name=passwordCheck]").val()){
				alert("비밀번호가 일치하지 않습니다");
				$("[name=passwordCheck]").focus();
			}else if(nullCheck($("[name=name]"))){
				alert("이름을 입력하세요");
				$("[name=name]").focus();
			}else if(nullCheck($("[name=postNum]"))){
				alert("우편번호를 입력하세요");
				$("#searchPostNum").focus();
			}

		})
		$("#searchPostNum").on("click",function(){
			new daum.Postcode({
				oncomplete: function(data) {
					let addr = '';
					$("[name=postNum]").val(data.zonecode);
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
					$("[name=addr]").val(addr);
					$("[name=detailAddr]").focus();
					
				}
			}).open();
		})
		
		//휴대폰 번호 인증
		var code2 = "";
		$("#phoneChk").click(function(){
		    alert('인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.');
		    $.ajax({
		        type:"POST", // post 형식으로 발송
		        url:"phone", // controller 위치
		        data: {"phoneNum": $("[name=phoneNum]").val()}, // 전송할 데이터값
		        cache : false,
		        success:function(data){
		            if(data == "error"){ //실패시 
		                alert("휴대폰 번호가 올바르지 않습니다.")
		            }else{            //성공시        
		                alert("휴대폰 전송이  됨.")
		                code2 = data; // 성공하면 데이터저장
		            }
		        }
		        
		    });
		});
		//휴대폰 인증번호 대조
		$("#phoneChk2").click(function(){
			if($("#phone2").val() == code2){ // 위에서 저장한값을 ㅣ교함
				alert('인증성공')
			}else{
				alert('인증실패')
			}
		});
	})
</script>
</html>