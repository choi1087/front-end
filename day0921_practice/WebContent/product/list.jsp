<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>

<style>
table {
	width: 100%;
	border: 1px solid #444444;
}

th, td {
	border: 1px solid #444444;
}
</style>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<div class="container p-4">
		<c:if test="${empty sessionScope.loginInfo }">
			<h2>로그인이 필요한 페이지 입니다. 목록을 보기 위해서 로그인을 해주세요!</h2>
			<a href="index.jsp">홈으로 이동</a>
		</c:if>

		<c:if test="${not empty sessionScope.loginInfo }">
			<table border="1px">
				<tr>
					<th>상품명</th>
					<th>상품 가격</th>
					<th>상품 조회수</th>
				</tr>

				<c:forEach items="${ requestScope.itemList}" var="i">
					<tr>
						<td><a href="${root }/item?action=detail&no=${i.no}">${i.name }</a></td>
						<td>${i.price }</td>
						<td>${i.clicked }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</div>

	<%@ include file="/include/footer.jsp"%>