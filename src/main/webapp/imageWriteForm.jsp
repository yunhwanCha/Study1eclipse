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
<h2>이미지 게시글 작성</h2>
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
	<tr><th>제 목</th><td><input type="text" name="TITLE" value="${title}"/></td></tr>
	<tr><th>암 호</th><td><input type="password" name="PWD"/></td></tr>
	<tr><th>이미지</th><td><input type="file" name="IMAGENAME"/></td></tr>
	<tr><th>내 용</th><td><textarea rows="8" cols="40" name="CONTENT"></textarea>
		</td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="글 올리기"/>
		<input type="reset" value="취 소"/></td></tr>
	</table>	
</form>
</div>
<script type="text/javascript">
function check(frm){
	if(frm.TITLE.value == ''){
		alert("제목을 입력하세요."); frm.TITLE.focus(); return false;
	}else {
		if(frm.TITLE.value.length > 30){
			alert("제목은 30자 이내로 작성하세요."); frm.TITLE.focus(); return false;
		}
	}
	if(frm.PWD.value == ''){
		alert("암호를 입력하세요. 수정 및 삭제에 필요합니다."); frm.PWD.focus();
		return false;
	}else {
		if(frm.PWD.value.length > 20){
			alert("암호는 20자 이내로 작성하세요."); frm.PWD.focus(); return false;
		}
	}
	if(frm.IMAGENAME.value == ''){
		alert("이미지 파일을 선택하세요."); frm.IMAGENAME.focus(); return false;
	}
	if(frm.CONTENT.value == ''){
		alert("내용을 입력하세요."); frm.CONTENT.focus(); return false;
	}else {
		if(frm.CONTENT.value.length > 150){
			alert("내용은 150자 이내로 작성하세요."); frm.CONTENT.focus(); return false;
		}
	}
	if( ! confirm("입력한 내용이 맞습니까?")) return false;
}
</script>
</body>
</html>















