<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20230214 myWeb home</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	
	
	<script>
	$(".btn.login").on("click", handelerClickBtnLogin);
	$(".btn.logout").on("click", handelerClickBtnLogout);
	
	function handelerClickBtnLogin(){
		console.log("btnLogin버튼 눌림");
		location.href="<%=request.getContextPath()%>/login";
	}
	
	function handelerClickBtnLogout(){
		console.log("btnLogout버튼 눌림");
	}
	</script>
</body>
</html>