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
<h2>��ǰ���� ���</h2>
<form action="putItem.do" method="post" onSubmit="return check(this)" name="fm">
<input type="hidden" name="codeChecked"/>
<table>
	<tr><th>��ǰ��ȣ</th><td><input type="text" name="CODE" id="CODE" size="6"/>
		<input type="button" value="�ߺ� �˻�" onClick="codeCheck()"/></td></tr>
	<tr><th>��ǰ�̸�</th><td><input type="text" name="TITLE" size="10"/></td></tr>
	<tr><th>��ǰ����</th><td><input type="text" name="PRICE" size="10"/></td></tr>
	<tr><th>������</th><td><select name="ORIGIN">
			<option value="KOR">���ѹα�</option><option value="JPN">�� ��</option>
			<option value="CHN">�� ��</option><option value="USA">�� ��</option>
			<option value="VET">��Ʈ��</option><option value="ETC">�� Ÿ</option>
		</select></td></tr>
	<tr><th>�� ��</th><td><textarea rows="5" cols="40" name="CONTENT"></textarea>
		</td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="��ǰ ���"/>
		<input type="reset" value="�� ��"/></td></tr>
</table>
</form>
</div>
<script type="text/javascript">
function codeCheck(){
	if(document.fm.CODE.value == ''){
		alert("��ǰ��ȣ�� �Է��ϼ���."); document.fm.CODE.focus(); return false;
	}
	var url = "itemCodeCheck.do?CODE="+document.fm.CODE.value;
	window.open(url,"_blank_","width=450, height=200");
}
function check(frm){
	if(frm.CODE.value == ''){
		alert("��ǰ��ȣ�� �Է��ϼ���."); frm.CODE.focus(); return false;
	}else {
		if(frm.codeChecked.value == ''){
			alert("��ǰ��ȣ �ߺ��˻縦 ���ּ���."); return false;
		}else {
			if(frm.CODE.value.length > 10){
				alert("��ǰ��ȣ�� 10�ڸ� ���� �۾ƾ� �մϴ�."); 
				frm.CODE.focus(); return false;
			}
		}
	}
	if(frm.TITLE.value == ''){
		alert("��ǰ�̸��� �Է��ϼ���."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 20){
			alert("��ǰ�̸��� 20�ڸ� ���� �۾ƾ� �մϴ�."); 
			frm.TITLE.focus(); return false;
		}
	}
	if(frm.PRICE.value == ''){
		alert("������ �Է��ϼ���."); frm.PRICE.focus(); return false;
	}else {
		if(isNaN(frm.PRICE.value)){
			alert("������ ���ڷ� �Է��ϼ���."); frm.PRICE.focus(); return false;
		}else {
			if(parseInt(frm.PRICE.value) <= 0){
				alert("������ 0���� Ŀ�� �մϴ�."); frm.PRICE.focus(); return false;
			}
		}
	}
	if(frm.CONTENT.value == ''){
		alert("��ǰ������ �Է��ϼ���."); frm.CONTENT.focus(); return false;
	}else {
		if(frm.CONTENT.value.length > 100){
			alert("��ǰ������ 100�� �̳��� �ۼ��ϼ���."); 
			frm.CONTENT.focus(); return false;
		}
	}
	if( ! confirm("������ ����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>










