<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.dto.BookmarkDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 수정</title>
</head>
<body>
	<div>
		<a href="../bookmark">돌아가기</a>
	</div>
	<h2>수정 폼</h2>
	<form action="./update" method="post">
		<input type="hidden" name="id" value="<%=((BookmarkDTO)request.getAttribute("data")).getId() %>">
		<input type="text" name="url" value="<%=((BookmarkDTO)request.getAttribute("data")).getUrl() %>">
		<input type="text" name="name" value="<%=((BookmarkDTO)request.getAttribute("data")).getName() %>">
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
</body>
</html>