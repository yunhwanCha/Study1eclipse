<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<c:if test="${BBS == null }">
	<h2>존재하지 않는 게시글입니다.</h2>
</c:if>
<c:if test="${BBS != null }">
	<h2>게시글 보기</h2>
	<form action="bbsModify.do" method="post" onSubmit="return check()">
	<input type="hidden" name="SEQNO" value="${BBS.seqno }"/>
	<table>
		<tr><th>글번호</th><td>${BBS.seqno }</td></tr>
		<tr><th>작성자</th><td>${BBS.id }</td></tr>
		<tr><th>제 목</th><td><input type="text" name="TITLE"
			value="${BBS.title }"/></td></tr>
		<tr><th>작성일</th><td>${BBS.bbs_date }</td></tr>
		<tr><th>내 용</th><td><textarea rows="5" cols="40" 
				name="CONTENT">${BBS.content }</textarea></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="수정"
			name="BTN"/> <input type="submit" value="삭제" name="BTN"/></td></tr>
	</table>
	</form>
</c:if>
</div>
<script type="text/javascript">
function check(){
	if( ! confirm("정말로 작업을 진행하시겠습니까?")) return false;
}
</script>
</body>
</html>








