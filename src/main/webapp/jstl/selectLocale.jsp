<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

<!DOCTYPE html>
<html>
<script src="${cp }/js/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("#locale").change(function(){
			$("#frm").submit();
		})
		//select box option selected 설정
		if ("${param.locale }") $("#locale").val("${param.locale }");
		
	});	
</script>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" action="${cp }/selectLocale" methoed="get">
		<select id="locale" name="locale">
			<option value="ko" <c:if test="${param.locale == 'ko' }">selected</c:if>>한국어</option>
			<option value="en" <c:if test="${param.locale == 'en' }">selected</c:if>>english</option>
			<option value="zh" <c:if test="${parma.locale == 'zh' }">selected</c:if>>中国话</option>
		</select>
<!-- 		<button type="submit" id="regBtn" class="btn btn-default">전송</button> -->
	</form>
	
	<fmt:setLocale value="${param.locale }"/>
	<fmt:setBundle basename="kr.or.ddit.msg.message" var="msg"/>
	<fmt:message key="GREETING" bundle="${msg }"/>
	
	
	
</body>
</html>