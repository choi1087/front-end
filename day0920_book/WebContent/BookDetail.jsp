<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<form>
		<table border="1">

			<tr>
				<td>제목</td>
				<td>${book.title }</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>${book.writer}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${book.price }</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>${book.publisher }</td>
			</tr>


		</table>
		<a
			href="${pageContext.request.contextPath }/book?action=delete&no=${book.no}">[현재
			책 삭제하기]</a>
	</form>
</body>
</html>