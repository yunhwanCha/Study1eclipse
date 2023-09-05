<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<c:if test="${COUNT == 0 }">
	<h2>등록된 공지글이 존재하지 않습니다.</h2>
</c:if>
<c:if test="${COUNT > 0 }">
	<h2>공지글 목록</h2>
	<table>
		<tr><th>글번호</th><th>제 목</th><th>작성자</th><th>작성일</th></tr>
		<c:forEach items="${NOTICES }" var="notice">
		<tr><td>${notice.no }</td>
			<td><a href="noticeRead.do?NO=${notice.no }">${notice.title }</a></td>
			<td>${notice.id }</td><td>${notice.notice_date }</td></tr>
		</c:forEach>
	</table>
</c:if>
</div>
</body>
</html>













