<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//������ ��Ȱ��ȭ �Ѵ�.
	session.invalidate();
	response.sendRedirect(
		"template.jsp?BODY=logoutResult.jsp");
%>
</body>
</html>