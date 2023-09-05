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
<h2>상품 상세 정보(관리자)</h2>
<form action="itemModify.do" method="post" onsubmit="return check(this)"
		name="frm">
	<input type="hidden" name="CODE" value="${ITEM.code }"/>
	<table>
	<tr><th>상품 번호</th><td>${ITEM.code }</td></tr>
	<tr><th>상품 이름</th><td><input type="text" name="TITLE" 
			value="${ITEM.title }"/></td></tr>
	<tr><th>상품 가격</th><td><input type="text" name="PRICE"
			value="${ITEM.price }"/></td></tr>
	<tr><th>원 산 지</th><td><select name="ORIGIN">
				<option value="KOR">대한민국</option>
				<option value="JPN">일 본</option>
				<option value="CHN">중 국</option>
				<option value="USA">미 국</option>
				<option value="VET">베트남</option>
				<option value="ETC">기 타</option>
		</select></td></tr>
	<tr><th>설 명</th><td><textarea rows="5" cols="40" 
		name="CONTENT">${ITEM.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="수 정"
		name="BTN"/> <input type="submit" value="삭 제" name="BTN"/></td></tr>	
	</table>
</form>
<script type="text/javascript">
	var combo = document.frm.ORIGIN;
	switch("${ITEM.origin}"){
	case "대한민국": combo[0].selected = true; break;
	case "일 본": combo[1].selected = true; break;
	case "중 국": combo[2].selected = true; break;
	case "미 국": combo[3].selected = true; break;
	case "베트남": combo[4].selected = true; break;
	case "기 타": combo[5].selected = true; break;
	}
</script>
</div>
</body>
</html>










