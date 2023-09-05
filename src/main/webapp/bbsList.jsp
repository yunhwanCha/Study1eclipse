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
<c:if test="${PAGES == 0 }">
	<h3>등록된 게시글이 존재하지 않습니다.</h3>
</c:if>
<c:if test="${PAGES > 0 }">
	<h2>게시글 목록</h2>
	<table width="100%">
		<tr><td align="right">${STARTROW} ~ ${ENDROW} / ${TOTAL }</td></tr>
	</table>
	<table width="100%">
		<tr><th>글번호</th><th>제 목</th><th>작성자</th><th>작성일</th></tr>
		<c:forEach items="${BBSLIST }" var="bbs">
		<tr><td>${bbs.seqno }</td>
			<td><a href="bbsRead.do?SEQNO=${bbs.seqno }">${bbs.title }</a></td>
			<td>${bbs.id }</td>
			<td>${bbs.bbs_date }</td></tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href="bbsList.do?PAGE_NO=${page }">${page }</a>
	</c:forEach>
</c:if>
</div>
</body>
</html>










