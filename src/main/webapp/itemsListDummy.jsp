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
<c:if test="${TOTAL == 0 }">
	<h3>등록된 상품이 존재하지 않습니다.</h3>
</c:if>
<c:if test="${TOTAL > 0 }">
	<h2>상품 목록</h2>
	<table width="100%">
		<tr><td align="right">${START }~${END }/${TOTAL }</td></tr>
	</table>
	<table width="100%">
		<tr><th>상품번호</th><th>상품이름</th><th>가 격</th><th>원산지</th></tr>
		<c:forEach items="${ITEMS }" var="item">
		<tr><td>${item.code }</td>
			<td><a href="itemDetail.do?CODE=${item.code }">${item.title }</a></td>
			<td>${item.price }</td>
			<td>${item.origin }</td></tr>
		</c:forEach>
	</table>
	<c:forEach begin="1" end="${PAGES }" var="page">
		<a href="itemList.do?PAGE=${page }">${page }</a>
	</c:forEach>
</c:if>
</div>
</body>
</html>













