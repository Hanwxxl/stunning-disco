<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- 절대경로<link href="<%=request.getContextPath() %>/resources/css/reset.css" rel="stylesheet"> --%>
<link href="./resoruces/css/reset.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
로그인
<form action="loginurl" method="post">
	id:<input type="text" name="n1">
	<button type="button" id="dupId">중복id확인</button>
	<span></span>
	<br>
	pw:<input type="password" name="n2">
	<br>
	<button type="submit">로그인하기</button>
</form>

<script>
	$("#dupId").click(checkDupId);
	function checkDupId(){
		$.ajax({ url:"<%=request.getContextPath()%>/dupid.lo"
				, type:"post" 
				, async:false
				// input이면서 type=text인 것 : input[type=text]
				// input 중에 첫번째
				, data: {id:$("input").first().val() }
				, success: function(result){
					console.log(result);
					if(result == 1){
						$("#dupId").next().html("중복아이디가 있습니다. 다시 입력하세요");
						$("#dupId").next().css("color","red");
					} else {
						$("#dupId").next().html("사용가능아이디입니다.");	
						$("#dupId").next().css("color","blue");
					}
				}
				, error: function(request, status, error){
					alert(request.status);
				},		
			});
	}
</script>
</body>
</html>