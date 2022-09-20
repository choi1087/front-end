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

	<table border="1">
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>저자</th>
			<th>가격</th>
			<th>출판사</th>
			<th>삭제여부</th>
		</tr>
		<c:if test="${empty requestScope.bookList  }">
			<tr>
				<td colspan="6">작성된 게시글이 없습니다. 게시글을 작성해보세요.</td>
			</tr>
		</c:if>
		<c:if test="${not empty requestScope.bookList  }">
			<c:forEach items="${requestScope.bookList }" var="b">
				<tr>
					<td>${b.no }</td>
					<td>${b.title }</td>
					<td>${b.writer }</td>
					<td>${b.price }</td>
					<td>${b.publisher }</td>
					<td><input type="checkbox" value="ROW_1"></td>
				</tr>
			</c:forEach>

		</c:if>
	</table>
	
	<input type="button" value="체크한 도서 모두 삭제">
	<a href="BookAdd.jsp">도서 추가 하러 가기</a>


</body>
</html>