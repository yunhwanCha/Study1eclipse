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
<form action="noticePost.do" method="post" onsubmit="return check(this)">
<table>
	<tr><th>�� ��</th><td><input type="text" name="TITLE" size="20"/></td></tr>
	<tr><th>�� ��</th><td><textarea rows="6" cols="40" name="CONTENT"></textarea>
		</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="�ø���"/>
		<input type="reset" value="�� ��"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.NO.value == ''){
		alert("������ ��ȣ�� �Է��ϼ���."); frm.NO.focus(); return false;
	}else {
		if(isNaN(frm.NO.value)){
			alert("�۹�ȣ�� ���ڷ� �Է��ϼ���."); frm.NO.focus(); return false;
		}
	}
	if(frm.TITLE.value == ''){
		alert("������ ������ �Է��ϼ���."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 30){
			alert("������ ������ 30�� �̳��� �ۼ��ϼ���."); frm.TITLE.focus();
			return false;
		}
	}
	if(frm.CONTENT.value == ''){
		alert("������ ������ �Է��ϼ���."); frm.CONTENT.focus(); return false;
	}else {
		if(frm.CONTENT.value.length > 100){
			alert("������ ������ 100�� �̳��� �ۼ��ϼ���."); frm.CONTENT.focus();
			return false;
		}
	}
	if( ! confirm("������ �ø��ðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>












