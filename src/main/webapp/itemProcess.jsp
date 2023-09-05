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
	String price = request.getParameter("P");
	String count = request.getParameter("C");
	int priceInt = Integer.parseInt(price);
	int countInt = Integer.parseInt(count);
	int total = priceInt * countInt;
	response.sendRedirect(
		"template.jsp?BODY=itemResult.jsp?TOT="+total);
%>
</body>
</html>












