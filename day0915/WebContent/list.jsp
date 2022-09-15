<%@page import="model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List<Student> studentList = (List<Student>) request.getAttribute("studentList");
	%>

	<table border="1">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<%
			for (Student s : studentList) {
		%>
		<tr>
			<td><%=s.getNo()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getAge()%></td>
			<td><%=s.getAddress()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>