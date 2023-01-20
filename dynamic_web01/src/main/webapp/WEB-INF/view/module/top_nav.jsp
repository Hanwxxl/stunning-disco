<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="mainUrl" value="/" />
<div>
	<a href="${mainUrl}">메인</a>
	<a href="${mainUrl}visit">방명록</a>
	<c:choose>
		<c:when test="${sessionScope.login }">
			<a href="${mainUrl}bookmark">즐겨찾기</a>
			<a href="${mainUrl}logout">로그아웃</a>
			<a href="${mainUrl}myinfo">개인정보</a>
		</c:when>
		<c:otherwise>
			<a href="${mainUrl}login">로그인</a>
			<a href="${mainUrl}join">회원가입</a>
		</c:otherwise>
	</c:choose>
</div>