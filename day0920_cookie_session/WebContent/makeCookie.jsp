<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>makeCookie</title>
</head>
<body>
	지금 당신에게 쿠키를 발급합니다.
	<%
	Cookie cookie = new Cookie("cookie1", "valueIsOnlyString");
	response.addCookie(cookie);

	Cookie cookie2 = new Cookie("cookie2", "1MinuteCookie");
	cookie2.setMaxAge(60);
	response.addCookie(cookie2);
	
	
%>
</body>
</html>