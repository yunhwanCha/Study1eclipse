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
<h2>게시판 글쓰기</h2>
<form action="bbsPost.do" method="post" onSubmit="return check(this)">
<table>
	<tr><th>제 목</th><td><input type="text" name="TITLE" size="15"
		placeholder="제목을 입력하세요."/></td></tr>
	<tr><th>내 용</th><td><textarea rows="6" cols="40" name="CONTENT"></textarea>
		</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="올리기"/>
		<input type="reset" value="취 소"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ''){
		alert("제목을 입력하세요."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 30){
			alert("제목은 30자 이내로 작성하세요.");frm.TITLE.focus(); return false;
		}
	}
	if(frm.CONTENT.value == ''){
		alert("내용을 입력하세요."); frm.CONTENT.focus(); return false;
	}else {
		if(frm.CONTENT.value.length > 100){
			alert("내용은 100자 이내로 작성하세요.");frm.CONTENT.focus(); return false;
		}
	}
	if( ! confirm("정말로 등록하시겠습니까?")) return false;
}
</script>
</body>
</html>










