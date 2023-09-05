<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>상품정보 등록</h2>
<form action="putItem.do" method="post" onSubmit="return check(this)" name="fm">
<input type="hidden" name="codeChecked"/>
<table>
	<tr><th>상품번호</th><td><input type="text" name="CODE" id="CODE" size="6"/>
		<input type="button" value="중복 검사" onClick="codeCheck()"/></td></tr>
	<tr><th>상품이름</th><td><input type="text" name="TITLE" size="10"/></td></tr>
	<tr><th>상품가격</th><td><input type="text" name="PRICE" size="10"/></td></tr>
	<tr><th>원산지</th><td><select name="ORIGIN">
			<option value="KOR">대한민국</option><option value="JPN">일 본</option>
			<option value="CHN">중 국</option><option value="USA">미 국</option>
			<option value="VET">베트남</option><option value="ETC">기 타</option>
		</select></td></tr>
	<tr><th>설 명</th><td><textarea rows="5" cols="40" name="CONTENT"></textarea>
		</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="상품 등록"/>
		<input type="reset" value="취 소"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function codeCheck(){
	if(document.fm.CODE.value == ''){
		alert("상품번호를 입력하세요."); document.fm.CODE.focus(); return false;
	}
	var url = "itemCodeCheck.do?CODE="+document.fm.CODE.value;
	window.open(url,"_blank_","width=450, height=200");
}
function check(frm){
	if(frm.CODE.value == ''){
		alert("상품번호를 입력하세요."); frm.CODE.focus(); return false;
	}else {
		if(frm.codeChecked.value == ''){
			alert("상품번호 중복검사를 해주세요."); return false;
		}else {
			if(frm.CODE.value.length > 10){
				alert("상품번호는 10자리 보다 작아야 합니다."); 
				frm.CODE.focus(); return false;
			}
		}
	}
	if(frm.TITLE.value == ''){
		alert("상품이름을 입력하세요."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 20){
			alert("상품이름은 20자리 보다 작아야 합니다."); 
			frm.TITLE.focus(); return false;
		}
	}
	if(frm.PRICE.value == ''){
		alert("가격을 입력하세요."); frm.PRICE.focus(); return false;
	}else {
		if(isNaN(frm.PRICE.value)){
			alert("가격은 숫자로 입력하세요."); frm.PRICE.focus(); return false;
		}else {
			if(parseInt(frm.PRICE.value) <= 0){
				alert("가격은 0보다 커야 합니다."); frm.PRICE.focus(); return false;
			}
		}
	}
	if(frm.CONTENT.value == ''){
		alert("상품설명을 입력하세요."); frm.CONTENT.focus(); return false;
	}else {
		if(frm.CONTENT.value.length > 100){
			alert("상품설명은 100자 이내로 작성하세요."); 
			frm.CONTENT.focus(); return false;
		}
	}
	if( ! confirm("정말로 등록하시겠습니까?")) return false;
}
</script>
</body>
</html>










