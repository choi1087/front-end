<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>노트북 정보 등록</h2>
	  <form id="registForm" action="${root }/note" method="post">
	  	<input type="hidden" name="action" value="regist">
	    <div class="form-group">
	      <label for="noteCode">고유번호</label>
	      <input type="text" class="form-control" id="noteCode" name="noteCode" placeholder="고유번호 입력">
	    </div>
	    <div class="form-group">
	      <label for="model">모델명</label>
	      <input type="text" class="form-control" id="model" name="model" placeholder="모델명 입력">
	    </div>
	    <div class="form-group">
	      <label for="price">가격</label>
	      <input type="number" class="form-control" id="price" name="price" placeholder="가격 입력" >
	    </div>
	    	    <div class="form-group">
	      <label for="company">제조사</label>
	      <input type="text" class="form-control" id="company" name="company" placeholder="제조사 입력" >
	    </div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>
	  </form>
	
	
	</div>
<%@ include file="/include/footer.jsp" %>

<script>
	let code = document.getElementById("noteCode").value;
	let model = document.getElementById("model").value;
	let price = document.getElementById("price").value;
	let company = document.getElementById("company").value;

	console.log(code);
	console.log(model);
	console.log(price);
	console.log(company);
	
	if(code ="" || model ="" || price="" || company=""){
		alert("모두 입력해주세요.")
		location.href="${root}/note/registNote.jsp";
	}
	
	let msg = ${msg};
	if(msg){
		alert(msg);		
	}
</script>