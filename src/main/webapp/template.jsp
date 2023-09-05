<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
		prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table {
	width:90%; height:80%; border:1px solid blue;
	border-collapse:collapse; margin-left:20px; 
	margin-right:20px; background-color:skyblue;
}
td.main {	width:30%; border:1px solid green; }
#menu {
	margin-left:10px; margin-top:10px; margin-right:10px;
	width:90%; border:1px dashed red; 
	background-color:lightgreen;
}
#content {	background-color:wheat; }
#login {
	margin-left:10px; margin-top:10px; width:90%;
	border:1px dashed orange; background-color:yellow;
}
</style>
</head>
<body onload="startClock()">
<script type="text/javascript">
function workingClock(){
	var days=["��","��","ȭ","��","��","��","��"];
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	if(month < 10) month = "0"+ month;
	var date = today.getDate();
	if(date < 10) date = "0" + date;
	var index = today.getDay();
	var day = days[index];
	var hour = today.getHours();
	var min = today.getMinutes();
	if(min < 10) min = "0" + min;
	var sec = today.getSeconds();
	if(sec < 10) sec = "0" + sec;
	var html=year+"/"+month+"/"+date+" "+day+" "+hour+":"+
				min+":"+sec;
	document.getElementById("clock").innerHTML = html;
}
function startClock(){
	workingClock();
	setInterval(workingClock, 1000);
}
</script>
<header>
	<div align="center"><img alt="" src="img/logo.gif"></div>
</header>
<section>
	<table id="body">
		<tr>
			<td width="40%" height="300px" class="main">
				<div id="login">
				<c:choose>
					<c:when test="${sessionScope.USER != null ||
							sessionScope.ADMIN != null }">
						<jsp:include page="logout.jsp"/>
					</c:when>
					<c:otherwise>
						<jsp:include page="login.jsp"/>
					</c:otherwise>
				</c:choose>
				</div>
				<div id="menu">
			
				<c:if test="${sessionScope.USER != null }">
				<a href="template.jsp?BODY=bbsInput.jsp">�Խñ� ����</a><br/>
				<a href="cartList.do">��ٱ��� ����</a><br/>
				<a href="template.jsp?BODY=imageWriteForm.jsp">�̹��� �� ��� �Խñ� ����</a><br/>
				</c:if>
				<a href="imageList.do">�̹��� �� ��� ���</a><br/>
				<a href="bbsList.do">�Խñ� ���</a><br/>
				<c:if test="${sessionScope.ADMIN != null }">
				<a href="template.jsp?BODY=noticeInput.jsp">�������� ����</a><br/>
				<a href="template.jsp?BODY=itemInput.jsp">��ǰ���� ���</a><br/>
				</c:if>
				<a href="noticeList.do">�������� ���</a><br/>
				<a href="itemList.do">��ǰ ���</a><br/>
				</div>
			</td>
			<td id="content">
				<jsp:include page="${param.BODY }"/>
			</td>		
		</tr>
	</table>
</section>
<footer>
	<h3 align="center">CopyRight 2023. MyHome.
	<font color="red"><span id="clock"></span></font></h3>
</footer>
</body>
</html>





