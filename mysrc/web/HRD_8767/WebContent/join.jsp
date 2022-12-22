<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="top_nav.jsp" %>
	<h1>홈쇼핑 회원 등록</h1>
      <form action="joinAction" method="post" id="inputForm">
         <table border="1">
            <tr>
               <td>회원번호(자동발생)</td>
               <td><input type="text" name="custno" value="${nowNumber }" readonly="readonly" id="custno"></td>
            </tr>
            <tr>
               <td>회원성명</td>
               <td><input type="text" name="custname" id="custname"></td>
            </tr>
            <tr>
               <td>회원전화</td>
               <td><input type="text" name="phone"></td>
            </tr>
            <tr>
               <td>회원주소</td>
               <td><input type="text" name="address"></td>
            </tr>
            <tr>
               <td>가입일자</td>
               <td><input type="text" name="joindate"></td>
            </tr>
            <tr>
               <td>고객등급</td>
               <td><input type="text" name="grade"></td>
            </tr>
            <tr>
               <td>도시코드</td>
               <td><input type="text" name="city"></td>
            </tr>
            <tr>
               <td colspan="2"><center><input type="button" value="등록" onclick="chk()"> <input
                  type="button" value="조회"></center></td>
            </tr>
         </table>
      </form>
	<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript">
	chk = () => {
		alert("유효성 검사");
		var inputfrm = document.querySelector('#inputForm');
		alert(inputfrm.custname.value);
		var name = inputfrm.custname.value;
		//유효성 검사 코드를 작성
		if(name==''){
			alert("이름은 필수 입력입니다.");
			return;
		}
		inputfrm.submit();
		alert("등록을 성공하였습니다.");
	}
</script>
</html>