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
<h2>��ǰ �� ����</h2>
<table>
	<tr><th>��ǰ ��ȣ</th><td>${ITEM.code }</td></tr>
	<tr><th>��ǰ �̸�</th><td>${ITEM.title }</td></tr>
	<tr><th>��ǰ ����</th><td><fmt:formatNumber 
		groupingUsed="true">${ITEM.price }</fmt:formatNumber>��</td></tr>
	<tr><th>������</th><td>${ITEM.origin }</td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="40"
		readonly="readonly">${ITEM.content }</textarea></td></tr>
</table>
</div>
</body>
</html>

