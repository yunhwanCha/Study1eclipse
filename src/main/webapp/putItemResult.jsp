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
			alert("��ǰ�� ��ϵǾ����ϴ�.");
		},100);
	</script>
</c:if>
<c:if test="${param.R == 'NOK' }">
	<script type="text/javascript">
		setTimeout(function(){
			alert("��ǰ ��� �� ������ �߻��߽��ϴ�. �����ڿ��� ������ �ּ���.");
		},100);
	</script>
</c:if>
</body>
</html>









