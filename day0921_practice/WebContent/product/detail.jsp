<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<div class="container p-4">

		<table border="1">
			<tr>
				<td>상품명:</td>
				<td>${requestScope.item.name }</td>
			</tr>
			<tr>
				<td>상품가격:</td>
				<td>${requestScope.item.price }</td>
			</tr>
			<tr>
				<td>상품 조회수:</td>
				<td>${requestScope.item.clicked }</td>
			</tr>
		</table>

		<a href="${root }/item?action=delete&no=${requestScope.item.no}">[현재
			아이템 삭제하기]</a>


	</div>

	<%@ include file="/include/footer.jsp"%>