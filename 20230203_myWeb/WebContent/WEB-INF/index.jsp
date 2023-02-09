<%@page import = "java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./errors/500error.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/resources/css/reset.css" rel="stylesheet">
<script src = "xxx.js"></script>
</head>
<body>
<img src="xxx.png">
<hr>
WebContent - WEB-INF - index.jsp
<hr>
<button type="button" onclick="login();">로그인페이지이동</button>
<script>
function login(){
	location.href="<%=request.getContextPath()%>/loginurl";
}
</script>



</body>
</html>