<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="imageDeleteDo.do" method="post" onsubmit="return check(this)">
<input type="hidden" name="id" value="${BBS.w_id }"/>
	<table width="100%">
		<tr><th>�� ��</th><td>${BBS.title }</td></tr>
		<tr><th>�ۼ���</th><td>${BBS.id }</td></tr>
		<tr><th>�� ȣ</th><td><input type="password" name="password" /></td></tr>
		<tr><th>�̹���</th><td><img alt="" src="upload/${BBS.image_name }"
			width="250" height="200"></td></tr>
		<tr><th>�� ��</th><td>${BBS.content }</td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="����"/>
			<input type="reset" value="���"/></td></tr>
	</table>
</form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.password.value == '') {
		alert("��ȣ�� �Է��ϼ���."); frm.password.focus(); return false;
	}
	if( ! confirm("������ �����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>
















