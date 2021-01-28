<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btn").click(function(){
			var url = "AjaxTest.jsp";
			$.ajax({
				url:url,
				//data : data, 보낼 데이터가 있을때 쓰는건데 지금은 없음.
				type:'get',
				success: function result(data){
					alert(data);
					$("#result").html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<a href="#" id="btn">ajax 테스트</a>
	<div id="result"></div>
</body>
</html>