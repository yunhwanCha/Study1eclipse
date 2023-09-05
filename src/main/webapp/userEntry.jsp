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
<header>
<h2>개인 정보 입력</h2>
</header>
<section>
<form action="register.do" method="post" name="fm" 
			onSubmit="return check(this)">
이 름 : <input type="text" name="NAME"/><br/>
계 정 : <input type="text" name="ID" />
<input type="button" value="중복검사" onClick="idCheck()"/><br/>
<input type="hidden" name="idChecked"/>
주 소 : <input type="text" name="ADDR"/><br/>
연락처 : <input type="text" name="PHONE"/><br/>
암 호 : <input type="password" name="PWD"/><br/>
암호 확인 : <input type="password" name="CONFIRM"/><br/>
성 별 : 남<input type="radio" name="GENDER" value="M"/>,
여<input type="radio" name="GENDER" value="F"/><br/>
이메일 : <input type="text" name="EMAIL"/><br/>
직 업 : <select name="JOB">
	<option>--선택하세요--</option><option>회사원</option>
	<option>학 생</option><option>자영업</option>
	<option>기 타</option></select><br/><br/>
<input type="submit" value="가 입"/>
<input type="reset" value="취 소"/><br/><br/>
</form>
<script type="text/javascript">
function idCheck(){
	var url = "idCheck.do?ID="+document.fm.ID.value;
	window.open(url,"_blank_","width=450,height=200");
}
function check(frm){
	if(frm.NAME.value == ''){
		alert("이름을 입력하세요."); frm.NAME.focus();
		return false;
	}
	if(frm.ID.value == ''){
		alert("계정을 입력하세요."); frm.ID.focus();
		return false;
	}
	if(frm.idChecked.value == ''){
		alert("ID 중복검사를 하세요."); return false;
	}
	if(frm.ADDR.value == ''){
		alert("주소를 입력하세요."); frm.ADDR.focus();
		return false;
	}
	if(frm.PHONE.value == ''){
		alert("연락처를 입력하세요."); frm.PHONE.focus();
		return false;
	}
	if(frm.PWD.value == ''){
		alert("암호를 입력하세요."); frm.PWD.focus();
		return false;
	}
	if(frm.PWD.value != frm.CONFIRM.value){
		alert("암호가 일치하지 않습니다."); fm.PWD.focus();
		return false;
	}//암호와 암호확인이 다른 경우
	if(! frm.GENDER[0].checked && ! frm.GENDER[1].checked){
		alert("성별을 선택하세요."); return false;
	}
	if(frm.JOB.selectedIndex < 1){
		alert("직업을 선택하세요."); frm.JOB.focus();
		return false;
	}
	if( ! confirm("입력한 내용이 맞습니까?")) return false;
}
</script>
</section>
</div>
</body>
</html>










