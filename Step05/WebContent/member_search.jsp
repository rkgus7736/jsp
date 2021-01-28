<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax json 처리</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			var data = $("#frm").serialize();
			$.ajax({
				url : "ServerAjax.jsp",
				data : data,
				method : "get",
				success : function(data) {
					var json = JSON.parse(data);
					console.log(json);
					var txt = "";
					for(i=0;i<json.result.length;i++){
						txt += json.result[i].id + " " +json.result[i].name + " " +
						json.result[i].age+" " +json.result[i].grade_name + "<br>";
					}
					console.log(txt);
					$("#area").html(txt);
				},
				error:function( request, status, error){
					console.log("error_code = " + request.status);
					console.log("message = " + request.responseText);
					console.log("error = " + error);
					console.log("status= " + status);
					location.href = "원하는 페이지 ";
				}
			});
		});
		$("input").keyup(function() {
			$("button").click();
		});
	});
</script>
</head>
<body>
	<form id="frm">
		<input type="text" name="name"><button type="button">검색</button>
	</form>
	<!-- 검색한 결과가 나올 곳 -->
	<div id="area"></div>
</body>
</html>