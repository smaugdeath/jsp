<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.IUserService"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!private IUserService userService = new UserService(); 
		private List<User> userList = userService.getUserList();%>
	
	<%--1. userdao 선언
		2. getUserList() 호출
		3. 호출결과(List<UserVo>)를 for loop를 통해 tr태그를 반복 생성
	--%>
	
	<table border=1>
		<tr>
			<th>이름</th>
		</tr>
		<%
			for (User user : userList) {
		%>
		<tr>
			<td><%= user.getUserNm() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>