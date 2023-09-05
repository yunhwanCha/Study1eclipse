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
<h2>공지사항 보기</h2>
<form action="noticeModify.do" method="post" onSubmit="return check()">
<input type="hidden" name="NO" value="${NOTICE.no }"/>
<table>
	<tr><th>글 번호</th><td>${NOTICE.no }</td></tr>
	<tr><th>작성자</th><td>${NOTICE.id }</td></tr>
	<tr><th>제 목</th><td><input type="text" name="TITLE" 
			value="${NOTICE.title }"/></td></tr>
	<tr><th>작성일</th><td>${NOTICE.notice_date}</td></tr>
	<tr><th>내 용</th><td><textarea rows="5" cols="40" 
		name="CONTENT">${NOTICE.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="수정"
		name="BTN"/> <input type="submit" value="삭제" name="BTN"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function check(){
	if( ! confirm("작업을 진행하시겠습니까?")) return false;
}
</script>
</body>
</html>









