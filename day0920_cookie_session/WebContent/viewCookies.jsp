<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신이 들고온 쿠키 목록</title>
</head>
<body>

	당신은 몰랐겠지만 사실 방금 당신이 나한테 쿠키를 아래와 같이 보냈습니다.
	<hr>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
	%>
			쿠키 이름:
			<%=c.getName()%><br> 쿠키 값:
			<%=c.getValue()%><br>
			<hr>
			<%
			}
		}
	%>
</body>
</html>