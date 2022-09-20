<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="book" method="post">
		<input type="hidden" name="action" value="add">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>

			<tr>
				<td>저자</td>
				<td><input type="text" name="writer"></td>
			</tr>

			<tr>
				<td>가격</td>
				<td><input type="text" name="price"></td>
			</tr>

			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher"></td>
			</tr>
		</table>
		<input type="submit" value="작성완료">
	</form>

</body>
</html>