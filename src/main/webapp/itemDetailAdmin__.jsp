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
<form action="itemModify.do" method="post" onsubmit="return check(this)"
		name="frm">
	<input type="hidden" name="CODE" value="${ITEM.code }"/>
	<table>
	<tr><th>��ǰ ��ȣ</th><td>${ITEM.code }</td></tr>
	<tr><th>��ǰ �̸�</th><td><input type="text" name="TITLE" 
			value="${ITEM.title }"/></td></tr>
	<tr><th>��ǰ ����</th><td><input type="text" name="PRICE"
			value="${ITEM.price }"/></td></tr>
	<tr><th>�� �� ��</th><td><select name="ORIGIN">
				<option value="KOR">���ѹα�</option>
				<option value="JPN">�� ��</option>
				<option value="CHN">�� ��</option>
				<option value="USA">�� ��</option>
				<option value="VET">��Ʈ��</option>
				<option value="ETC">�� Ÿ</option>
		</select></td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="40" 
		name="CONTENT">${ITEM.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="�� ��"
		name="BTN"/> <input type="submit" value="�� ��" name="BTN"/></td></tr>	
	</table>
</form>
<script type="text/javascript">
	var combo = document.frm.ORIGIN;
	switch("${ITEM.origin}"){
	case "���ѹα�": combo[0].selected = true; break;
	case "�� ��": combo[1].selected = true; break;
	case "�� ��": combo[2].selected = true; break;
	case "�� ��": combo[3].selected = true; break;
	case "��Ʈ��": combo[4].selected = true; break;
	case "�� Ÿ": combo[5].selected = true; break;
	}
</script>
</div>
</body>
</html>










