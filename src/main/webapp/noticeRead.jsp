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
<c:if test="${empty NOTICE }">
	<h3>존재하지 않는 공지글입니다.</h3>
</c:if>
<c:if test="${ ! empty NOTICE }">
	<h3>공지사항 보기</h3>
	<table width="100%">
		<tr><th>글 번호</th><td>${NOTICE.no }</td></tr>
		<tr><th>제 목</th><td>${NOTICE.title }</td></tr>
		<tr><th>작성자</th><td>${NOTICE.id }</td></tr>
		<tr><th>작성일</th><td>${NOTICE.notice_date }</td></tr>
		<tr><th>내 용</th><td><textarea rows="5" cols="40"
			readonly="readonly">${NOTICE.content }</textarea></td></tr>	
	</table>
</c:if>
</div>
</body>
</html>









