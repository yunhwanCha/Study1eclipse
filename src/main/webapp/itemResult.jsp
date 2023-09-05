<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>구매 총액 : <font color="red"><fmt:formatNumber
	value="${param.TOT }" groupingUsed="true"/></font>원</h2>
	<h3>구매해 주셔서 감사합니다~</h3>
</div>
</body>
</html>