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
<c:choose>
	<c:when test="${param.R == 'OK' }">
		<script type="text/javascript">
			setTimeout(function(){
				alert("가입되었습니다~ 가입을 축하합니다~.");
			},100);
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			setTimeout(function(){
				alert("가입되지 않았습니다. 관리자에게 문의해 주세요.");
			},100);
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>







