<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
      String number = request.getParameter("number");
      String number2 = request.getParameter("number2");
      int sum = 0;
      
      for(int i = Integer.parseInt(number); i<=Integer.parseInt(number2); i++) {
    	sum += i;	  
      }
     %>
      
     result : <%=sum %>

</body>
</html>