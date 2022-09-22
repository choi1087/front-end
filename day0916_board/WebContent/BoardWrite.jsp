<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 화면</title>
</head>
<body>
	<form action="board" method="post">
		<input type="hidden" name="action" value="write">
		<table border="1">
			<tr>
				<td>제목:</td>
				<td><input type="text" name="title"></td>
			</tr>

			<tr>
				<td>작성자:</td>
				<td><input type="text" name="writer"></td>
			</tr>

			<tr>
				<td>내용:</td>
				<td><textarea rows="20" cols="30" name="content"
						placeholder="여기에 내용을 입력하세요."></textarea></td>
			</tr>
		</table>
		<input type="submit" value="작성완료">
	</form>
	<hr>
	네이버 쇼핑 검색:
	<input type="text" id="keyword">
	<button id="btnSearch">검색</button>
	<table border="1" id="resultSearch">
		<tr>

		</tr>
	</table>

	<script type="text/javascript">
		let btn = document.getElementById("btnSearch");
		btn.onclick= async function(){
			let keyword = document.getElementById('keyword').value;
			//alert(keyword);
			let url = '<%=request.getContextPath()%>/naverShopping?keyword' +keyword;
			let response=await fetch(url);
			
			let data = await response.json();
			//console.log(data);
			let result ='';
			data.items.forEach(function(item){
				result += '<tr>';
				result+= '<td>'+item.title+'</td>';
				result+= '<td>'+item.lprice+'</td>';
				result+= '<td><a href=" '+item.link +'">[바로가기]</a></td>';
				result += '</tr>';
			})
			document.getElementById('resultSearch').innerHTML = result;
		}
		
	</script>
</body>
</html>