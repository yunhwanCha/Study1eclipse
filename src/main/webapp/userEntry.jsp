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
<header>
<h2>���� ���� �Է�</h2>
</header>
<section>
<form action="register.do" method="post" name="fm" 
			onSubmit="return check(this)">
�� �� : <input type="text" name="NAME"/><br/>
�� �� : <input type="text" name="ID" />
<input type="button" value="�ߺ��˻�" onClick="idCheck()"/><br/>
<input type="hidden" name="idChecked"/>
�� �� : <input type="text" name="ADDR"/><br/>
����ó : <input type="text" name="PHONE"/><br/>
�� ȣ : <input type="password" name="PWD"/><br/>
��ȣ Ȯ�� : <input type="password" name="CONFIRM"/><br/>
�� �� : ��<input type="radio" name="GENDER" value="M"/>,
��<input type="radio" name="GENDER" value="F"/><br/>
�̸��� : <input type="text" name="EMAIL"/><br/>
�� �� : <select name="JOB">
	<option>--�����ϼ���--</option><option>ȸ���</option>
	<option>�� ��</option><option>�ڿ���</option>
	<option>�� Ÿ</option></select><br/><br/>
<input type="submit" value="�� ��"/>
<input type="reset" value="�� ��"/><br/><br/>
</form>
<script type="text/javascript">
function idCheck(){
	var url = "idCheck.do?ID="+document.fm.ID.value;
	window.open(url,"_blank_","width=450,height=200");
}
function check(frm){
	if(frm.NAME.value == ''){
		alert("�̸��� �Է��ϼ���."); frm.NAME.focus();
		return false;
	}
	if(frm.ID.value == ''){
		alert("������ �Է��ϼ���."); frm.ID.focus();
		return false;
	}
	if(frm.idChecked.value == ''){
		alert("ID �ߺ��˻縦 �ϼ���."); return false;
	}
	if(frm.ADDR.value == ''){
		alert("�ּҸ� �Է��ϼ���."); frm.ADDR.focus();
		return false;
	}
	if(frm.PHONE.value == ''){
		alert("����ó�� �Է��ϼ���."); frm.PHONE.focus();
		return false;
	}
	if(frm.PWD.value == ''){
		alert("��ȣ�� �Է��ϼ���."); frm.PWD.focus();
		return false;
	}
	if(frm.PWD.value != frm.CONFIRM.value){
		alert("��ȣ�� ��ġ���� �ʽ��ϴ�."); fm.PWD.focus();
		return false;
	}//��ȣ�� ��ȣȮ���� �ٸ� ���
	if(! frm.GENDER[0].checked && ! frm.GENDER[1].checked){
		alert("������ �����ϼ���."); return false;
	}
	if(frm.JOB.selectedIndex < 1){
		alert("������ �����ϼ���."); frm.JOB.focus();
		return false;
	}
	if( ! confirm("�Է��� ������ �½��ϱ�?")) return false;
}
</script>
</section>
</div>
</body>
</html>










