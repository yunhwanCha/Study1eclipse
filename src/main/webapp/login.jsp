<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="right"><a href="template.jsp?BODY=userEntry.jsp">�����ϱ�</a></div>
<form action="loginDo.do" method="post" 
		onSubmit="return check(this)">
�� �� : <input type="text" name="ID" size="10" 
			placeHolder="���̵�"/><br/>
�� ȣ : <input type="password" name="PWD" size="10"
		placeHolder="��ȣ"/><br/>
<input type="submit" value="�α���"/>
<input type="reset" value="�� ��"/>
</form>
<script type="text/javascript">
function check(frm){
	if(frm.ID.value == ''){
		alert("������ �Է��ϼ���."); fm.ID.focus(); return false;
	}
	if(frm.PWD.value == ''){
		alert("��ȣ�� �Է��ϼ���."); fm.PWD.focus(); return false;
	}
}
</script>
</body>
</html>