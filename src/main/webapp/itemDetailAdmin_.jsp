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
<form action="itemModify.do" method="post" onsubmit="return check(this)">
	<input type="hidden" name="CODE" value="${ITEM.code }"/>
	<table>
	<tr><th>��ǰ ��ȣ</th><td>${ITEM.code }</td></tr>
	<tr><th>��ǰ �̸�</th><td><input type="text" name="TITLE" 
			value="${ITEM.title }"/></td></tr>
	<tr><th>��ǰ ����</th><td><input type="text" name="PRICE"
			value="${ITEM.price }"/></td></tr>
	<tr><th>�� �� ��</th><td><select name="ORIGIN">
		<c:choose>
			<c:when test="${ITEM.origin == '���ѹα�' }">
				<option value="KOR" selected="selected">���ѹα�</option>
			</c:when>
			<c:otherwise>
				<option value="KOR">���ѹα�</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${ITEM.origin == '�� ��' }">
				<option value="JPN" selected="selected">�� ��</option>			
			</c:when>
			<c:otherwise>
				<option value="JPN">�� ��</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${ITEM.origin == '�� ��' }">
				<option value="CHN" selected="selected">�� ��</option>
			</c:when>
			<c:otherwise>
				<option value="CHN">�� ��</option>
			</c:otherwise>
		</c:choose>	
		<c:choose>
			<c:when test="${ITEM.origin == '�� ��' }">
				<option value="USA" selected="selected">�� ��</option>
			</c:when>
			<c:otherwise>
				<option value="USA">�� ��</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${ITEM.origin == '��Ʈ��' }">
				<option value="VET" selected="selected">��Ʈ��</option>
			</c:when>
			<c:otherwise>
				<option value="VET">��Ʈ��</option>
			</c:otherwise>
		</c:choose>		
		<c:choose>
			<c:when test="${ITEM.origin == '�� Ÿ' }">
				<option value="ETC" selected="selected">�� Ÿ</option>
			</c:when>
			<c:otherwise>
				<option value="ETC">�� Ÿ</option>
			</c:otherwise>
		</c:choose>
		</select></td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="40" 
		name="CONTENT">${ITEM.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="�� ��"
		name="BTN"/> <input type="submit" value="�� ��" name="BTN"/></td></tr>	
	</table>
</form>
</div>
</body>
</html>










