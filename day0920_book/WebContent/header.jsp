<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>SSAFY 도서 관리 사이트</h2>
<c:choose>
	<c:when test="${not empty sessionScope.loginInfo }">
		<b>${sessionScope.loginInfo.name }</b>(${sessionScope.loginInfo.id })님 환영합니다.
		</c:when>

	<c:otherwise>
		<form action="member" method="get">
			<input type="hidden" name="action" value="login"> ID: <input
				type="text" name="id"> PW: <input type="password" name="pw">
			<input type="submit" value="로그인">
		</form>
	</c:otherwise>
</c:choose>
<hr>

<a href="book?action=list"> [도서 목록 보러가기] </a>
<a href="BookAdd.jsp">[도서 추가 하러 가기]</a>
<hr>
