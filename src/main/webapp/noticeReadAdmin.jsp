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
<h2>�������� ����</h2>
<form action="noticeModify.do" method="post" onSubmit="return check()">
<input type="hidden" name="NO" value="${NOTICE.no }"/>
<table>
	<tr><th>�� ��ȣ</th><td>${NOTICE.no }</td></tr>
	<tr><th>�ۼ���</th><td>${NOTICE.id }</td></tr>
	<tr><th>�� ��</th><td><input type="text" name="TITLE" 
			value="${NOTICE.title }"/></td></tr>
	<tr><th>�ۼ���</th><td>${NOTICE.notice_date}</td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="40" 
		name="CONTENT">${NOTICE.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="����"
		name="BTN"/> <input type="submit" value="����" name="BTN"/></td></tr>
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









