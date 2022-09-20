<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteCookie</title>
</head>
<body>
	내가 보낸 쿠키중에 cookie1이 있나 찾아보고 있습니다...

	<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie c : cookies) {
			if (c.getName().equals("cookie1")) {
				out.println("<h1>cookie1  찾았다! 너 이제 이거 저장하지마!</h1>");
				Cookie tmp = new Cookie("cookie1", "");
				tmp.setMaxAge(0);
				response.addCookie(tmp);
			}
		}
	}
%>
	탐색 완료
</body>
</html>