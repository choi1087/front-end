<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>

<%@ include file="/include/footer.jsp" %>

<script>
	let msg = ${msg};
	if(msg){
		alert(msg);		
	}
	location.href="${root}/note/listNote.jsp"
</script>