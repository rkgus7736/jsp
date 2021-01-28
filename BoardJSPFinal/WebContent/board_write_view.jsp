<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
<style type="text/css">
	#container{
		height: 600px;
		/* background-color: lime; */
		width:1200px;
		margin:0 auto;
	}
	#container table{
		width:600px;
		border-collapse: collapse; //테이블 셀 간격 없애기(표 하나당 간격을 셀이라고 함)
		margin:0 auto;
	}
	#container th{
		width:150px !important;
		text-align: right;
		padding:5px;
	}
	#container td{
		width: 500px;
		padding:5px;
		height: 40px;
	}
	#container input{
		width: 100%;
		height:40px;
		box-sizing:border-box;
		border-width : 1px; //선 굵기 조절가능(강조)
		border-radius: 5px;
	}
	h2{
		text-align: center;
	}
	.btn{
		text-decoration: none;
		background-color: #e8e8e8;
		width: 80px;
		display: inline-block;
		padding:5px 0px;
		font-weight:normal;
		border : 1px solid #585858;
		text-align:center;
		color : black;
		font-size:14px;
		box-sizing: border-box;
	}
	.btn:hover{
		background-color: #282828;
		color:#FFFFFF
	}
	textarea {
		width:100%;
		height: 300px;
		resize: none;
		box-sizing: border-box;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		var count = 3; //첨부파일 태그 개수
		$("#plus").click(function(){
			if(count == 5) return;
			count++;
			$("#file_form").append("<p><input type= 'file' name='file"+count+"'></p>")
		});
		$("#minus").click(function(){
			if(count==1) return;
			//alert($(this).parent()parent().children("p").length);
			//$(this).parent()parent().children("p").last().children().attr("name"));
				//p태그 자기자신을 remove
			$(this).parent()parent().children("p").last().remove());
			count--;
		});
	});
</script>
</head>
<body>
	<c:if test ="${sessionScope.login == null || sessionScope.login == false }">
				<c:set var = "result_url" value ="${requestScope.requestURI + requestScope.queryString }"
				scope="session"> 
				</c:set>
				<script>
					console.log("${sessionScope.result_url}");
					alert("로그인을 하셔야 이용할수 있습니다.");
					location.href = "loginView.do";
				</script>
		</c:if>
			
	<jsp:include page="/template/header.jsp" flush="false"></jsp:include>
	<div id="container">
		<h2>글쓰기 페이지</h2>
		<form action="boardWriteAction.do" method="post">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="hidden" name="writer" value="<%=session.getAttribute("id")%>">
						<%=session.getAttribute("id")%>					
					</td>
				</tr>
				<tr>
					<th style="vertical-align: top;">내용</th><td><textarea name="content"></textarea></td>
				</tr>
					<!-- 첨부파일 -->
				<tr>
					<td colspan="2" id="file_form">
						<p><input type="text" name="writer" placeholder="작성자"></p>
						<p><button>전송</button></p>
						<p><input type="file" name="file1"> 
						<button type="button" id="plus">+</button><button type="button" id="minus">-</button></p>
						<p><input type="file" name="file2"></p>
						<p><input type="file" name="file3"></p>
					</td>
				</tr>
				<tr>
					<th><a href="main.do?pageNo=${requestScope.pageNo == null ? 1 : requestScope.pageNo }" class="btn">목록보기</a></th>
					<td style="text-align: right;">
						<a href="javascript:history.back();" class="btn">뒤로가기</a>
						<button class="btn">글쓰기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="/template/footer.jsp" flush="false"></jsp:include>
</body>
</html>
