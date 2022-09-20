<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginCheck.jsp</title>
</head>
<body>
	<%--
	<%
		String loginInfo = (String) session.getAttribute("loginInfo");
		if (loginInfo != null) {
	%>
	<b><%=loginInfo%></b>님 환영합니다!!
	<br>
	<%
		} else {
	%>
	아직 로그인 정보가 없군요. 로그인 하러 가시려면 링크를 클릭하세요.
	<a href="loginForm.jsp">[로그인]</a>
	<%
		}
	%>
 --%>

	<c:choose>
		<c:when test="${not empty sessionScope.loginInfo }">
			<b>${sessionScope.loginInfo }</b>님 환영합니다!<br>
		</c:when>
		
		<c:otherwise>
			아직 로그인 정보가 없군요. 로그인 하러 가시려면 링크를 클릭하세요.
			<a href="loginForm.jsp">[로그인]</a>
		</c:otherwise>
	</c:choose>

</body>
</html>