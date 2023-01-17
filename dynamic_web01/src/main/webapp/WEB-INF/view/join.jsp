<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>회원가입</h1>
	<c:url var="joinUrl" value="/join" />
	<form action="${joinUrl }" method="post">
		<div>
			<label>아이디</label>
			<input type="text" name="userId">
			<c:if test="${not empty requestScope.error }">
				<span style="color: red;">${requestScope.error }</span>
			</c:if>
		</div>
		<div>
			<label>패스워드</label>
			<input type="password" name="password">
		</div>
		<div>
			<label>이메일</label>
			<input type="email" name="email" value="${param.email }">
		</div>
		<div>
			<button type="submit">가입</button>
		</div>
	</form>
</body>
</html>