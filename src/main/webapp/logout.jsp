<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="logoutDo.do">
<c:if test="${sessionScope.USER != null }">
환영합니다~<font color="red">${sessionScope.USER }님~</font><br/>
</c:if>
<c:if test="${sessionScope.ADMIN != null }">
환영합니다~<font color="red">${sessionScope.ADMIN }님~</font><br/>
</c:if>
<br/>
<input type="submit" value="로그 아웃"/>
</form>
</body>
</html>






