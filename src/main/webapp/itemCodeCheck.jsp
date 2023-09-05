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
<h2 align="center">상품번호 중복 확인</h2>
<form action="itemCodeCheck.do" name="frm">
	상품번호 : <input type="text" name="CODE" value="${CODE }"/>
	<input type="submit" value="중복 검사"/>
</form>
<c:if test="${ empty DUP }">
	${CODE }는 사용 가능합니다.
	<input type="button" value="사용" onClick="codeOK()"/>
</c:if>
<c:if test="${ ! empty DUP }">
	${CODE }는 이미 사용 중입니다.
</c:if>
<script type="text/javascript">
function codeOK(){
	opener.document.fm.CODE.value = document.frm.CODE.value;
	opener.document.fm.codeChecked.value = "OK";
	opener.document.fm.CODE.readOnly = true;//편집 불가
	self.close();
}
</script>
</body>
</html>









