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
<c:if test="${ empty param.id }">
	<script type="text/javascript">
		alert("게시글이 수정되었습니다.");
		location.href="imageList.do";//게시글 목록
	</script>
</c:if>
<c:if test="${ ! empty param.id }">
	<script type="text/javascript">
		alert("게시글이 수정되지 않았습니다. 암호를 확인하세요.");
		location.href="imageDetail.do?W_ID="+${param.id};
	</script>
</c:if>
</body>
</html>



