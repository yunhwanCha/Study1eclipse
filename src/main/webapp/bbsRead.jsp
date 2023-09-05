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
	<h3>존재하지 않는 게시글입니다.</h3>
</c:if>
<c:if test="${BBS != null }">
	<h3>게시글 보기</h3>
	<table width="100%">
		<tr><th>글번호</th><td>${BBS.seqno }</td></tr>
		<tr><th>작성자</th><td>${BBS.id }</td></tr>
		<tr><th>제 목</th><td>${BBS.title }</td></tr>
		<tr><th>작성일</th><td>${BBS.bbs_date }</td></tr>
		<tr><th>내 용</th>
			<td><textarea rows="5" cols="40" readonly="readonly">${BBS.content }</textarea></td></tr>
	</table>
</c:if>
</div>
</body>
</html>