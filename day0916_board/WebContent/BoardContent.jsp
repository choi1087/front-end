<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value='${pageContext.request.contextPath}/board'></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 화면</title>
</head>
<body>

	<%
		BoardDTO board = (BoardDTO) request.getAttribute("board");
	%>

	<form>
		<input type="hidden" name="action" value="list">
		<table border="1">
			<tr>
				<td>글 번호</td>
				<td><%=board.getBno()%></td>
			</tr>

			<tr>
				<td>제목</td>
				<td><%=board.getTitle()%></td>
			</tr>

			<tr>
				<td>작성자</td>
				<td><%=board.getWriter()%></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><%=board.getContent()%></td>
			</tr>
			<tr>
				<td>작성일시</td>
				<td><%=board.getWriteDate()%></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><%=board.getReadCount()%></td>
			</tr>
		</table>
		<button id="btnList">목록으로 가기</button>
	</form>
	<script>
		let btnList = document.getElementById("btnList");
		btnList.onclick = function() {
			location.href = "${root}?action=write"
		}
	</script>

</body>
</html>