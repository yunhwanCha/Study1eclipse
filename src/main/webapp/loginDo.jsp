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
			if(id.equals(ids[i])){//입력한 계정과 동일한 경우
				if(pwd.equals(pwds[i])){//입력한 암호와 동일한 경우
					//로그인 성공!
					flag = true;
					break;
				}//if의 끝
			}//if의 끝
		}//for의 끝
		return flag;
	}//메서드의 끝
%>
<%
	String id = request.getParameter("ID");
	String pwd = request.getParameter("PWD");
	//계정:tiger, lion, manager
	//암호:1234, 4321, 1324
	boolean flag = loginCheck(id, pwd);
	String result = "";
	if(flag){//로그인 성공
		//session내장객체에 데이터(계정)를 저장한다.
		session.setAttribute("ID", id);
		result="OK";
	}else {//로그인 실패(1:계정X,암호X, 2:계정O,암호X)
		result="NOK";
	}
	//페이지를 loginResult.jsp로 바꾼다.Redirect
	response.sendRedirect(
		"template.jsp?BODY=loginResult.jsp?R="+result);
%>
</body>
</html>












