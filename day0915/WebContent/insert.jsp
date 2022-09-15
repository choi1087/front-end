<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록 페이지</title>
</head>
<body>
	학생을 등록해주세요.
	<form action="<%=request.getContextPath()%>/student" method="post">
		<input type="hidden" name="action" value="insert">

		<table border="1">
			<tr>
				<td>학생 이름:</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>학생 나이:</td>
				<td><input type="text" name="age"></td>
			</tr>

			<tr>
				<td>학생 주소:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>

</body>
</html>