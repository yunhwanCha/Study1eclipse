<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="right"><a href="template.jsp?BODY=userEntry.jsp">가입하기</a></div>
<form action="loginDo.do" method="post" 
		onSubmit="return check(this)">
계 정 : <input type="text" name="ID" size="10" 
			placeHolder="아이디"/><br/>
암 호 : <input type="password" name="PWD" size="10"
		placeHolder="암호"/><br/>
<input type="submit" value="로그인"/>
<input type="reset" value="취 소"/>
</form>
<script type="text/javascript">
function check(frm){
	if(frm.ID.value == ''){
		alert("계정을 입력하세요."); fm.ID.focus(); return false;
	}
	if(frm.PWD.value == ''){
		alert("암호를 입력하세요."); fm.PWD.focus(); return false;
	}
}
</script>
</body>
</html>