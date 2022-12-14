<%@page import="model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value='${pageContext.request.contextPath}/board'></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
table {
	border-collapse: collapse;
}

th {
	background-color: lightblue;
}

tr:nth-child(odd) {
	background-color: lightgray;
}

tr:hover {
	background-color: red;
	cursor: pointer;
}
</style>
</head>
<body>

	<%
		HashMap<String, Object> boardPage = (HashMap<String, Object>) request.getAttribute("boardPage");
		int currPage = (int) boardPage.get("currPage");
		int startPage = (int) boardPage.get("startPage");
		int endPage = (int) boardPage.get("endPage");
		int totalPage = (int) boardPage.get("totalPage");

		List<BoardDTO> boardList = (List<BoardDTO>) boardPage.get("boardList");
	%>

	<h2>이곳은 게시판 목록입니다.</h2>

	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
			<th>삭제</th>
		</tr>
		<%
			if (boardPage == null || boardList == null || boardList.size() == 0) {
		%>
		<tr>
			<td clospan="5">작성된 게시글이 없습니다. 게시글을 작성해보세요.</td>
		</tr>
		<%
			} else {
		%>
		<%
			for (BoardDTO b : boardList) {
		%>
		<tr>
			<td><%=b.getBno()%></td>
			<td><a
				href="${root}?action=update&bno=<%=b.getBno()%>&page=<%=currPage%>"><%=b.getTitle()%></a></td>
			<td><%=b.getWriter()%></td>
			<td><%=b.getWriteDate()%></td>
			<td><%=b.getReadCount()%></td>
			<td><button id="btnDelete"
					onclick="deleteFunction(<%=b.getBno()%>)">X</button></td>
		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
	<%
		if (startPage > 1) {
	%>
	<a href="${root }?action=list&page=<%=startPage - 1%>">[이전] </a>
	<%
		}
	%>

	<%
		for (int p = startPage; p <= endPage; p++) {
			if (p == currPage) {
	%>
	<a href="${root }?action=list&page=<%=p%>" style="color: red">[<%=p%>]
	</a>
	<%
		} else {
	%>
	<a href="${root }?action=list&page=<%=p%>">[<%=p%>]
	</a>
	<%
		}
		}
	%>


	<%
		if (endPage < totalPage) {
	%>
	<a href="${root }?action=list&page=<%=endPage + 1%>">[다음] </a>
	<%
		}
	%>

	<button id="btnWrite">글쓰기</button>
	<script>
		let btnWrite = document.getElementById("btnWrite");
		btnWrite.onclick = function() {
			//location.href = "board?action=write";
			//console.log("${root}");
			location.href = "${root}?action=write";
		}
	</script>
	<script>
		function deleteFunction(bno) {
			//location.href = "board?action=delete&bno=" + bno;
			location.href = "${root}?action=delete&bno=" + bno;
		}
	</script>



</body>
</html>
