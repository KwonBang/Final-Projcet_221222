<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../random" method="get">
	<input type="submit" value="모든번호 받기" >
	</form>
	<form action="../choice" method="get">
	번호 2개 입력<input type="text" name = "choicenum1" id="choicenum1" maxlength="2" required onkeyup="keyevent();">
	<input type="text" name = "choicenum2" id="choicenum2" maxlength="2" required onkeyup="keyevent();">
	<input type="submit" value="2개번호 지정" onclick="chk()">
	</form>
	<!-- 
기본이  html문서 
<%    %> jsp문법 : html  css javascript jsp영역은 서로 완전히 다른 영역입니다.
                 변수를 공유하는데 한계가 있습니다. 거의 공유하지 못한다고 생각하면 됩니다..
                  >> 불편하고 무거워서  많이 쓰이는 문법이 jstl & el
                  
        jsp문법에서 출력할 데이터는 html 문서로 출력을 시켜야 합니다..(*)
 -->
 
 <% // parameter(클라이언트가 보낸 데이터)랑  Atrribute(서버반에서 주고 받는데이터)랑 구분하세요..
    // 컨트롤러가 setAtrribute로 만들 자료이기에
    int[] a = (int[])request.getAttribute("num");
    for(int i=0; i < a.length; i++){
       //    jsp문법에서 출력할 데이터는 html 문서로 출력을 시켜야 합니다..(*)
         out.print(a[i]+" / "+"<br>");
    }%>
<hr>
 <% // parameter(클라이언트가 보낸 데이터)랑  Atrribute(서버반에서 주고 받는데이터)랑 구분하세요..
    // 컨트롤러가 setAtrribute로 만들 자료이기에
    int[] aa = (int[])request.getAttribute("num");
    for(int i=0; i < aa.length; i++){
       //    jsp문법에서 출력할 데이터는 html 문서로 출력을 시켜야 합니다..(*)%>
       <!--  html영역 -->
       <%= aa[i]%> <span> ---- </span><br>
       
<%    }%>
</body>
<script>
	var chk1 = document.getElementById('choicenum1');
	var chk2 = document.getElementById('choicenum2');
	keyevent = () => {
		chk1.value = chk1.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/, '');
		chk1.value = chk1.value.replace(/[^0-9]/g, '');
		chk2.value = chk2.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/, '');
		chk2.value = chk2.value.replace(/[^0-9]/g, '');
	}
	chk = () => {
		if(chk1.value>45||chk2.value>45||chk1.value==0||chk2.value==0||(chk1.value==chk2.value)){
			alert('숫자 1~45까지 입력');
			chk1.value = '';
			chk2.value = '';
		}
	}
	
</script>
</html>