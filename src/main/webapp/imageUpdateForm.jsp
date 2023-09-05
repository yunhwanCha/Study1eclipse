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
<form action="imageUpdateDo.do" method="post" enctype="multipart/form-data"
	onSubmit="return check(this)">
<input type="hidden" name="id" value="${BBS.w_id }"/>
<table width="100%" border="1">
<tr><th>글제목</th><td><input type="text" name="title" size="20"
		value="${BBS.title }"/></td></tr>
<tr><th>작성자</th><td>${BBS.id }</td></tr>
<tr><th>암 호</th><td><input type="password" name="pwd" size="10"/></td></tr>
<tr><th>이미지</th><td><input type="file" name="image_name"/><br/>
	<img alt="" src="upload/${BBS.image_name }" width="250" height="200"></td></tr>
<tr><th>글내용</th><td><textarea rows="4" cols="40" 
	name="content">${BBS.content }</textarea></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="수정"/>
	<input type="reset" value="취소"/></td></tr>
</table>
</form>
<script type="text/javascript">
function check(frm){
	if(frm.title.value == ''){
		alert("제목을 입력하세요."); frm.title.focus(); return false;
	}
	if(frm.pwd.value == ''){
		alert("암호를 입력하세요."); frm.pwd.focus(); return false;
	}
	if(frm.content.value == ''){
		alert("글내용을 입력하세요."); frm.content.focus(); return false;
	}
	if( ! confirm("정말로 변경하시겠습니까?")) return false;
}
</script>
</div>
</body>
</html>










