<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">계정 중복 확인</h2>

<form action="idCheck.do" name="checkFrm">
	계 정 : <input type="text" name="ID" value="${ID }"/>
	<input type="submit" value="중복 검사"/>
</form><br/>

<c:if test="${DUP != null }">
${DUP }는 이미 사용 중입니다.
	<script type="text/javascript">
		opener.document.fm.ID.value = "";
	</script>
</c:if>
<c:if test="${DUP == null }">
${ID }는 사용 가능합니다.
<input type="button" value="사용" onClick="idOk()"/>
</c:if>

<script type="text/javascript">
function idOk(){
	opener.document.fm.ID.value = "${ID}";
	opener.document.fm.ID.readOnly = true;
	opener.document.fm.idChecked.value = "OK";
	self.close();
}
</script>
</body>
</html>