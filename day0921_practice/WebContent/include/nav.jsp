<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link"
			href="${root }/item?action=list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${root }/item?action=add">상품 정보 등록</a></li>

		<c:if test="${empty sessionScope.loginInfo }">
			<form action="${root }/member?action=login" method="post">
				ID: <input type="text" name="id"> PW: <input type="password"
					name="pw"> <input type="submit" value="LOGIN">
			</form>
		</c:if>

		<c:if test="${not empty sessionScope.loginInfo }">
			<span style="color: white"><b>${loginInfo }</b>님 반갑습니다.</span>
			<a href="${root }/user?action=logout">로그아웃</a>
		</c:if>

	</ul>
</nav>