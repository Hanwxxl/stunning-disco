<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>
<body>
	<h1 style="color: <%=(String)request.getAttribute("color") %>">직접 생성한 JSP/Servlet 페이지</h1>
	<form action="./home" method="get">
		<input type="text" name="color">
		<button type="submit">전송</button>
	</form>
	<p>
	${"EL Test"}<br>
		${10 + 20}<br>
		${10 div 3}<br>
		${10 mod 3}<br>
		${10 eq 10}<br>
		${10 ne 20}<br>
		${10 le 20}<br>
		${10 lt 20}<br>
		${20 ge 10}<br>
		${20 gt 10}<br>
		${true and true}<br>
		${true or true}<br>
		${not true}<br>
		${empty param.color}<br>
		${requestScope.color}<br>
		${param.color }<br>
		${"문자열"} ${"문자열"} ${10}<br>
	</p>
	<h3>JSTL - core</h3>

	<h4>변수 설정</h4>
	<c:set var="name" value="값" />
	${name }
	<br>
	<h4>변수 삭제</h4>
	<c:remove var="name" />
	${empty name ? "삭제됨" : name }
	<br>

	<h4>조건문</h4>
	<c:set var="val" value="10" />
	<c:if test="${val eq 10}" var="result">
		조건식 결과 -> ${result }
	</c:if>
	<br>

	<c:choose>
		<c:when test="${val ne 10 }">
			val 은 10 입니다.
		</c:when>
		<c:otherwise>
			val 은 10 이 아닙니다.
		</c:otherwise>
	</c:choose>

	<br>

	<h4>반복문</h4>
	<c:forEach var="i" begin="0" end="5" step="1">
		${i },
	</c:forEach>
	<br>

	<c:set var="arr">
		a, b, c, d, e, f
	</c:set>

	<c:forEach var="v" items="${arr }">
		${v } /
	</c:forEach>
	<br>

	<c:forEach var="v" items="${arr }" varStatus="loop">
		${loop.index } - ${loop.count } - ${v } - first:${loop.first } - last:${loop.last }<br>
	</c:forEach>
	<br>

	<c:forTokens var="v" items="010-1234-5678" delims="-">
		${v }<br>
	</c:forTokens>
	<br>

	<h4>URL 주소 생성</h4>
	<c:url var="url" value="/home">
		<c:param name="param" value="1" />
		<c:param name="key" value="value" />
	</c:url>
	${url }
	<br>

	<h3>JSTL - function</h3>

	<h4>contains(전체문자열, 일부문자열)</h4>
	${fn:contains("Hello JSTL Tag Library", "jstl") }

	<h4>containsIgnoreCase(전체문자열, 일부문자열)</h4>
	${fn:containsIgnoreCase("Hello JSTL Tag Library", "jstl") }

	<h4>replace(전체문자열, 변경전문자열, 변경후문자열)</h4>
	${fn:replace("Hello JSTL Tag Library", "Tag", "태그") }

	<h4>split(전체문자열, 분리구분문자)</h4>
	<c:forEach var="str" items="${fn:split('Hello JSTL Tag Library', ' ') }">
		${str }<br>
	</c:forEach>

	<h4>join(분리된문자열배열, 결합구분문자)</h4>
	<c:set var="strArr" value="${fn:split('Hello JSTL Tag Library', ' ') }" />
	${fn:join(strArr, "-") }

	<h4>toLowerCase(전체문자열)</h4>
	${fn:toLowerCase("Hello JSTL Tag Library") }

	<h4>toUpperCase(전체문자열)</h4>
	${fn:toUpperCase("Hello JSTL Tag Library") }

	<h4>trim(전체문자열)</h4>
	${fn:trim("    Hello JSTL Tag Library    ") }

	<h4>length(전체문자열)</h4>
	${fn:length("Hello JSTL Tag Library") }

	<h4>substring(전체문자열, 시작위치, 끝위치)</h4>
	${fn:substring("Hello JSTL Tag Library", 6, 10) }
	
	<h3>JSTL - formatting</h3>
	
	
	<h4>number formatting</h4>
	<c:set var="num" value="123456789" />
	<c:set var="flt" value="0.123" />
	<fmt:formatNumber value="${num }" type="number" /><br>
	<fmt:formatNumber value="${num }" type="number"  groupingUsed="false"/><br>
	<fmt:formatNumber value="${num }" type="currency" /><br>
	<fmt:formatNumber value="${flt }" type="percent" /><br>
	
	
	<h4> date formatting</h4>
	<c:set var="now" value="<%=new Date() %>" />
	<fmt:formatDate type="date" value="${now }"/><br>
	<fmt:formatDate type="date" dateStyle="short" value="${now }"/><br>
	<fmt:formatDate type="date" dateStyle="medium" value="${now }"/><br>
	<fmt:formatDate type="date" dateStyle="long" value="${now }"/><br>
	<br>
	<fmt:formatDate type="time" value="${now }"/><br>
	<fmt:formatDate type="time" timeStyle="short" value="${now }"/><br>
	<fmt:formatDate type="time" timeStyle="medium" value="${now }"/><br>
	<fmt:formatDate type="time" timeStyle="long" value="${now }"/><br>
	<br>
	<fmt:formatDate type="both" value="${now }"/><br>
	<fmt:formatDate type="both"  dateStyle="short" timeStyle="short" value="${now }"/><br>
	<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now }"/><br>
	<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now }"/><br>
	<br>
	<fmt:formatDate type="both" pattern="yyyy-MM-dd a hh:mm:ss" value="${now }" /><br>
	<br>
	<c:set var="date" value="2023-01-16" />
	<fmt:parseDate var="date2" value="${date }" pattern="yyyy-MM-dd" />
	<fmt:formatDate type="date" dateStyle="short" value="${date2 }"/><br>
	<fmt:formatDate type="date" dateStyle="medium" value="${date2 }"/><br>
	<fmt:formatDate type="date" dateStyle="long" value="${date2 }"/><br>
	
	
	
	
</body>
</html>