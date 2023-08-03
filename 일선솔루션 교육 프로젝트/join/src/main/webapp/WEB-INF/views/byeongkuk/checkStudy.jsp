<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.1.min.js"></script>

</head>
<body>
	<div>
		<label><input type="checkbox" value="전체" id="addrAll" name="addrAll">전체</label>&nbsp;<input type="button" value="버튼" id="btn"><br>
		<label><input type="checkbox" value="서울" name="addr" onclick="checkSet(this)">서울</label>
		<label><input type="checkbox" value="인천" name="addr" onclick="checkSet(this)">인천</label>
		<label><input type="checkbox" value="경기" name="addr" onclick="checkSet(this)">경기</label>
		<label><input type="checkbox" value="강원" name="addr" onclick="checkSet(this)">강원</label>
		<label><input type="checkbox" value="부산" name="addr" onclick="checkSet(this)">부산</label>
		<label><input type="checkbox" value="대전" name="addr" onclick="checkSet(this)">대전</label>
		<label><input type="checkbox" value="전남" name="addr" onclick="checkSet(this)">전남</label>
		<label><input type="checkbox" value="제주" name="addr" onclick="checkSet(this)">제주</label>
		<label><input type="checkbox" value="평양" name="addr" onclick="checkSet(this)">평양</label>
	</div>
	<div id="addrtext">
		
	</div>
</body>
<script type="text/javascript">
	$(function() {
		//버튼클릭시 4개이상 선택시 성공 아닐시 실패 메시지출력
		$("#btn").click(function() {
			let addrCnt = $("[name=addr]:checked").length;
			if(addrCnt>=4){
				alert("성공");
			}else{
				alert("실패");
			}
		})
		/*addrAll 클릭시 addrAll선택상태일경우 선택하지않은 항목 체크 
					addrAll 해제상태일경우 선택된 항목 체크해제*/
		$("#addrAll").click(function() {
			if($("#addrAll").is(":checked")){
				$("[name=addr]:not(:checked)").prop("checked",true);
			}else{
				$("[name=addr]:checked").prop("checked",false);
			}
		})
	})
	/*체크박스 클릭시 전체항목과 체크된항목 수 비교, 같을시addrAll 체크 아닐시 해제
		클릭시 선택상태일경우 항목출력 해제상태일시 출력된 항목 삭제 */
	function checkSet(chk) {
		let addrAllCnt = $("[name=addr]").length;
		let addrCnt = $("[name=addr]:checked").length;
		if($("[name=addr]").length == $("[name=addr]:checked").length){
			$("#addrAll").prop("checked",true);
		}else{
			$("#addrAll").prop("checked",false);
		}
		if(chk.checked){
			document.getElementById("addrtext").innerHTML += "<span id='"+chk.value+"'>"+chk.value+" </span>";
		}else{
			document.getElementById(chk.value).remove();	
		}
	}
	
	
	
	/*var addrAll = document.getElementById("addrAll");
	var btn = document.getElementById("btn");
	addrAll.onclick=function() {
		let addrs = document.getElementsByName("addr");
		addrs.forEach((checkbox) => {
			if(addrAll.checked){
				if(addrAll.checked!=checkbox.checked){
					checkbox.checked = addrAll.checked;
					document.getElementById("addrtext").innerHTML += "<span id='"+checkbox.value+"'>"+checkbox.value+" </span>";
				}
			}else{
				checkbox.checked = addrAll.checked;
				document.getElementById(checkbox.value).remove();
			}
	 	})
	}
	function checkSet(chk) {
		let addrAllCnt = $("[name=addr]").length;
		let addrCnt = $("[name=addr]:checked").length;
		if(addrAllCnt==addrCnt){
			addrAll.checked = true;
		}else{
			addrAll.checked = false;
		}
		if(chk.checked){
			document.getElementById("addrtext").innerHTML += "<span id='"+chk.value+"'>"+e.value+" </span>";
		}else{
			document.getElementById(chk.value).remove();	
		}
	} */
</script>
</html>