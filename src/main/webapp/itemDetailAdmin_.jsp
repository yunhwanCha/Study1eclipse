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
<form action="itemModify.do" method="post" onsubmit="return check(this)">
	<input type="hidden" name="CODE" value="${ITEM.code }"/>
	<table>
	<tr><th>상품 번호</th><td>${ITEM.code }</td></tr>
	<tr><th>상품 이름</th><td><input type="text" name="TITLE" 
			value="${ITEM.title }"/></td></tr>
	<tr><th>상품 가격</th><td><input type="text" name="PRICE"
			value="${ITEM.price }"/></td></tr>
	<tr><th>원 산 지</th><td><select name="ORIGIN">
		<c:choose>
			<c:when test="${ITEM.origin == '대한민국' }">
				<option value="KOR" selected="selected">대한민국</option>
			</c:when>
			<c:otherwise>
				<option value="KOR">대한민국</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${ITEM.origin == '일 본' }">
				<option value="JPN" selected="selected">일 본</option>			
			</c:when>
			<c:otherwise>
				<option value="JPN">일 본</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${ITEM.origin == '중 국' }">
				<option value="CHN" selected="selected">중 국</option>
			</c:when>
			<c:otherwise>
				<option value="CHN">중 국</option>
			</c:otherwise>
		</c:choose>	
		<c:choose>
			<c:when test="${ITEM.origin == '미 국' }">
				<option value="USA" selected="selected">미 국</option>
			</c:when>
			<c:otherwise>
				<option value="USA">미 국</option>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${ITEM.origin == '베트남' }">
				<option value="VET" selected="selected">베트남</option>
			</c:when>
			<c:otherwise>
				<option value="VET">베트남</option>
			</c:otherwise>
		</c:choose>		
		<c:choose>
			<c:when test="${ITEM.origin == '기 타' }">
				<option value="ETC" selected="selected">기 타</option>
			</c:when>
			<c:otherwise>
				<option value="ETC">기 타</option>
			</c:otherwise>
		</c:choose>
		</select></td></tr>
	<tr><th>설 명</th><td><textarea rows="5" cols="40" 
		name="CONTENT">${ITEM.content }</textarea></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="수 정"
		name="BTN"/> <input type="submit" value="삭 제" name="BTN"/></td></tr>	
	</table>
</form>
</div>
</body>
</html>










