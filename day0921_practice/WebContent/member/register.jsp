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



		<h2>회원가입</h2>
		<form id="registForm" action="${root }/member?action=register" method="post">
			<input type="hidden" name="action" value="register">
			<!-- 
	    <div class="form-group">
	      <label for="productCode">고유번호</label>
	      <input type="text" class="form-control" id="productCode" placeholder="고유번호 입력">
	    </div>
	     -->
			<div class="form-group">
				<label for="memberId">회원 아이디</label> <input type="text"
					class="form-control" id="memberId" name="memberId"
					placeholder="아이디 입력">
			</div>
			<div class="form-group">
				<label for="memberPw">비밀번호</label> <input type="password"
					class="form-control" id="memberPw" name="memberPw"
					placeholder="비밀번호 입력">
			</div>

			<div class="form-group">
				<label for="memberName">이름</label> <input type="text"
					class="form-control" id="memberName" name="memberName"
					placeholder="이름 입력">
			</div>

			<div class="form-group">
				<label for="memberAddress">주소</label> <input type="text"
					class="form-control" id="memberAddress" name="memberAddress"
					placeholder="주소 입력">
			</div>

			<div class="form-group">
				<label for="memberPhone">전화번호</label> <input type="text"
					class="form-control" id="memberPhone" name="memberPhone"
					placeholder="전화번호 입력">
			</div>

			<button type="submit" class="btn btn-primary" id="regist">등록</button>
			<a class="btn btn-secondary" href="#">취소</a>
		</form>


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