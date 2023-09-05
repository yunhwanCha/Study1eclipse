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
<h2>�̹��� �Խñ� �ۼ�</h2>
<form action="imageWrite.do" method="post" enctype="multipart/form-data" 
	onsubmit="return check(this)">
<input type="hidden" name="orderno" value="${imageBBS.order_no + 1 }"/>
<c:if test="${ ! empty imageBBS.group_id }">
<input type="hidden" name="groupid" value="${imageBBS.group_id }"/>
</c:if>	
<c:if test="${ ! empty imageBBS.parent_id }">
<input type="hidden" name="parentid" value="${imageBBS.parent_id }"/>
</c:if>
	<table>
	<tr><th>�� ��</th><td><input type="text" name="TITLE" value="${title}"/></td></tr>
	<tr><th>�� ȣ</th><td><input type="password" name="PWD"/></td></tr>
	<tr><th>�̹���</th><td><input type="file" name="IMAGENAME"/></td></tr>
	<tr><th>�� ��</th><td><textarea rows="8" cols="40" name="CONTENT"></textarea>
		</td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="�� �ø���"/>
		<input type="reset" value="�� ��"/></td></tr>
	</table>	
</form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ''){
		alert("������ �Է��ϼ���."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 30){
			alert("������ 30�� �̳��� �ۼ��ϼ���."); frm.TITLE.focus(); return false;
		}
	}
	if(frm.PWD.value == ''){
		alert("��ȣ�� �Է��ϼ���. ���� �� ������ �ʿ��մϴ�."); frm.PWD.focus();
		return false;
	}else {
		if(frm.PWD.value.length > 20){
			alert("��ȣ�� 20�� �̳��� �ۼ��ϼ���."); frm.PWD.focus(); return false;
		}
	}
	if(frm.IMAGENAME.value == ''){
		alert("�̹��� ������ �����ϼ���."); frm.IMAGENAME.focus(); return false;
	}
	if(frm.CONTENT.value == ''){
		alert("������ �Է��ϼ���."); frm.CONTENT.focus(); return false;
	}else {
		if(frm.CONTENT.value.length > 150){
			alert("������ 150�� �̳��� �ۼ��ϼ���."); frm.CONTENT.focus(); return false;
		}
	}
	if( ! confirm("�Է��� ������ �½��ϱ�?")) return false;
}
</script>
</body>
</html>















