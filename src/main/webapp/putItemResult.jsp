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
<c:if test="${param.R == 'OK' }">
	<script type="text/javascript">
		setTimeout(function(){
			alert("상품이 등록되었습니다.");
		},100);
	</script>
</c:if>
<c:if test="${param.R == 'NOK' }">
	<script type="text/javascript">
		setTimeout(function(){
			alert("상품 등록 중 문제가 발생했습니다. 관리자에게 문의해 주세요.");
		},100);
	</script>
</c:if>
</body>
</html>










