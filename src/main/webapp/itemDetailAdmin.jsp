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
<div align="center">
<h2>��ǰ �� ����(������)</h2>
<form action="itemModify.do" method="post" onsubmit="return check()"
		name="frm">
	<input type="hidden" name="CODE" value="${ITEM.code }"/>
	<table>
	<tr><th>��ǰ ��ȣ</th><td>${ITEM.code }</td></tr>
	<tr><th>��ǰ �̸�</th><td><input type="text" name="TITLE" 
			value="${ITEM.title }"/></td></tr>
	<tr><th>��ǰ ����</th><td><input type="text" name="PRICE"
			value="${ITEM.price }"/></td></tr>
	<tr><th>�� �� ��</th><td><select name="ORIGIN">
		<option value="KOR" <c:if test="${ITEM.origin == '���ѹα�'}">selected="selected"</c:if> >���ѹα�</option>
		<option value="JPN" <c:if test="${ITEM.origin == '�� ��'}">selected="selected"</c:if> >�� ��</option>
		<option value="CHN" <c:if test="${ITEM.origin == '�� ��'}">selected="selected"</c:if> >�� ��</option>
		<option value="USA" <c:if test="${ITEM.origin == '�� ��'}">selected="selected"</c:if> >�� ��</option>
		<option value="VET" <c:if test="${ITEM.origin == '��Ʈ��'}">selected="selected"</c:if> >��Ʈ��</option>
		<option value="ETC" <c:if test="${ITEM.origin == '�� Ÿ'}">selected="selected"</c:if> >�� Ÿ</option>
		</select></td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="40" 
		name="CONTENT">${ITEM.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="�� ��"
		name="BTN"/> <input type="submit" value="�� ��" name="BTN"/></td></tr>	
	</table>
</form>
</div>
<script type="text/javascript">
function check(){
	if( ! confirm("�۾��� �����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>










