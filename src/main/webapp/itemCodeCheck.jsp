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
<h2 align="center">��ǰ��ȣ �ߺ� Ȯ��</h2>
<form action="itemCodeCheck.do" name="frm">
	��ǰ��ȣ : <input type="text" name="CODE" value="${CODE }"/>
	<input type="submit" value="�ߺ� �˻�"/>
</form>
<c:if test="${ empty DUP }">
	${CODE }�� ��� �����մϴ�.
	<input type="button" value="���" onClick="codeOK()"/>
</c:if>
<c:if test="${ ! empty DUP }">
	${CODE }�� �̹� ��� ���Դϴ�.
</c:if>
<script type="text/javascript">
function codeOK(){
	opener.document.fm.CODE.value = document.frm.CODE.value;
	opener.document.fm.codeChecked.value = "OK";
	opener.document.fm.CODE.readOnly = true;//���� �Ұ�
	self.close();
}
</script>
</body>
</html>









