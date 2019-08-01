<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//jsp에 내장되어있는 기본 객체가 존재: request, response
	
%>


<body>
	request.getLocalAddr() local IP = <%= request.getLocalAddr() %> <br>
	request.getRemoteAddr() 클라이언트 IP = <%= request.getRemoteAddr() %><br>
	request.getContentLength() 요청  정보 길이 = <%= request.getContentLength() %><br>
	request.getCharacterEncoding() 요청 정보 인코딩 = <%= request.getCharacterEncoding() %><br>
	request.getContentType() 요청 정보 콘텐츠 타입 = <%= request.getContentType() %><br>
	request.getProtocol() 요청 프로토콜 = <%= request.getProtocol() %><br>
	request.getMethod() 요청 메소드 <%= request.getMethod() %><br>
	request.getRequestURI() 요청 URI = <%= request.getRequestURI() %><br>
	request.getRequestURL() 요청 URL = <%= request.getRequestURL() %><br>
	request.getContextPath() context path = <%= request.getContextPath() %><br>
	request.getServerName() server name = <%= request.getServerName() %><br>
	request.getServerPort() server port = <%= request.getServerPort() %><br>



</body>
</html>