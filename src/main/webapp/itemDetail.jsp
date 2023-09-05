<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>상품 상세 정보</h2>
<table>
	<tr><th>상품 번호</th><td>${ITEM.code }</td></tr>
	<tr><th>상품 이름</th><td>${ITEM.title }</td></tr>
	<tr><th>상품 가격</th><td><fmt:formatNumber 
		groupingUsed="true">${ITEM.price }</fmt:formatNumber>원</td></tr>
	<tr><th>원산지</th><td>${ITEM.origin }</td></tr>
	<tr><th>설 명</th><td><textarea rows="5" cols="40"
		readonly="readonly">${ITEM.content }</textarea></td></tr>
</table>
</div>
</body>
</html>

