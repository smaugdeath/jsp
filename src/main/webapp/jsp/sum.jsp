<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/jsp/sumJsp.jsp" method="get">
		number : <input type="text" name="number"> <br>
		number2 : <input type="text" name="number2"> <br>
		<br><br>
		<input type="submit" value="전송">
	</form>

	
</body>
</html>