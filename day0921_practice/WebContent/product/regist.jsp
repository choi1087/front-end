<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<c:if test="${empty sessionScope.loginInfo }">
			<h2>로그인이 필요한 페이지입니다. 상품 정보를 등록하기 위해서 로그인을 해주세요!</h2>
			<a href="index.jsp">홈으로 이동하기</a>
		</c:if>

		<c:if test="${not empty sessionScope.loginInfo }">
			<h2>상품 정보 등록</h2>
			<form id="registForm" action="${root }/item" method="post">
				<input type="hidden" name="action" value="add">
				<!-- 
	    <div class="form-group">
	      <label for="productCode">고유번호</label>
	      <input type="text" class="form-control" id="productCode" placeholder="고유번호 입력">
	    </div>
	     -->
				<div class="form-group">
					<label for="model">상품명</label> <input type="text"
						class="form-control" id="name" name="name" placeholder="모델명 입력">
				</div>
				<div class="form-group">
					<label for="price">가격</label> <input type="number"
						class="form-control" id="price" name="price" placeholder="가격 입력">
				</div>

				<button type="submit" class="btn btn-primary" id="regist">등록</button>
				<a class="btn btn-secondary" href="#">취소</a>
			</form>
		</c:if>

	</div>

	<script>
		let btn = document.getElementById("regist")
		btn.onclick = function() {

			let name = document.getElementById("name").value;
			let price = document.getElementById("price").value;

			if (!name || !price) {
				alert('항목을 모두 입력해주세요!');
				return false;
			}

		}
	</script>
	<%-- --%>
	<%@ include file="/include/footer.jsp"%>