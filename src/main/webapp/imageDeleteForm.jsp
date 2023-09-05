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
<form action="imageDeleteDo.do" method="post" onsubmit="return check(this)">
<input type="hidden" name="id" value="${BBS.w_id }"/>
	<table width="100%">
		<tr><th>제 목</th><td>${BBS.title }</td></tr>
		<tr><th>작성자</th><td>${BBS.id }</td></tr>
		<tr><th>암 호</th><td><input type="password" name="password" /></td></tr>
		<tr><th>이미지</th><td><img alt="" src="upload/${BBS.image_name }"
			width="250" height="200"></td></tr>
		<tr><th>내 용</th><td>${BBS.content }</td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="삭제"/>
			<input type="reset" value="취소"/></td></tr>
	</table>
</form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.password.value == '') {
		alert("암호를 입력하세요."); frm.password.focus(); return false;
	}
	if( ! confirm("정말로 삭제하시겠습니까?")) return false;
}
</script>
</body>
</html>
















