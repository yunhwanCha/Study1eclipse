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
	<h3>�������� �ʴ� �������Դϴ�.</h3>
</c:if>
<c:if test="${ ! empty NOTICE }">
	<h3>�������� ����</h3>
	<table width="100%">
		<tr><th>�� ��ȣ</th><td>${NOTICE.no }</td></tr>
		<tr><th>�� ��</th><td>${NOTICE.title }</td></tr>
		<tr><th>�ۼ���</th><td>${NOTICE.id }</td></tr>
		<tr><th>�ۼ���</th><td>${NOTICE.notice_date }</td></tr>
		<tr><th>�� ��</th><td><textarea rows="5" cols="40"
			readonly="readonly">${NOTICE.content }</textarea></td></tr>	
	</table>
</c:if>
</div>
</body>
</html>









