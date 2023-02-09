<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- 절대경로<link href="<%=request.getContextPath() %>/resources/css/reset.css" rel="stylesheet"> --%>
<link href="./resoruces/css/reset.css" rel="stylesheet">
</head>
<body>
로그인
<form action="loginurl" method="post">
	id:<input type="text" name="n1">
	<br>
	pw:<input type="password" name="n2">
	<br>
	<button type="submit">로그인하기</button>
</form>
</body>
</html>