<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
	boolean loginCheck(String id, String pwd){
		String[] ids = {"tiger","lion","manager"};
		String[] pwds = {"1234","4321","1324"};
		boolean flag = false;
		for(int i=0; i < ids.length; i++){
			if(id.equals(ids[i])){//�Է��� ������ ������ ���
				if(pwd.equals(pwds[i])){//�Է��� ��ȣ�� ������ ���
					//�α��� ����!
					flag = true;
					break;
				}//if�� ��
			}//if�� ��
		}//for�� ��
		return flag;
	}//�޼����� ��
%>
<%
	String id = request.getParameter("ID");
	String pwd = request.getParameter("PWD");
	//����:tiger, lion, manager
	//��ȣ:1234, 4321, 1324
	boolean flag = loginCheck(id, pwd);
	String result = "";
	if(flag){//�α��� ����
		//session���尴ü�� ������(����)�� �����Ѵ�.
		session.setAttribute("ID", id);
		result="OK";
	}else {//�α��� ����(1:����X,��ȣX, 2:����O,��ȣX)
		result="NOK";
	}
	//�������� loginResult.jsp�� �ٲ۴�.Redirect
	response.sendRedirect(
		"template.jsp?BODY=loginResult.jsp?R="+result);
%>
</body>
</html>












