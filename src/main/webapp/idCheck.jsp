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
<h2 align="center">���� �ߺ� Ȯ��</h2>

<form action="idCheck.do" name="checkFrm">
	�� �� : <input type="text" name="ID" value="${ID }"/>
	<input type="submit" value="�ߺ� �˻�"/>
</form><br/>

<c:if test="${DUP != null }">
${DUP }�� �̹� ��� ���Դϴ�.
	<script type="text/javascript">
		opener.document.fm.ID.value = "";
	</script>
</c:if>
<c:if test="${DUP == null }">
${ID }�� ��� �����մϴ�.
<input type="button" value="���" onClick="idOk()"/>
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