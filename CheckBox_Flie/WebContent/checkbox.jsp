<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkbox</title>
</head>
<body>
	<form action="CheckServlet" method="get">
		<input type="checkbox" name="chk" value="chk1">체크 1<br>
		<input type="checkbox" name="chk" value="chk2">체크 2<br>
		<input type="checkbox" name="chk" value="chk3">체크 3<br>
		<input type="checkbox" name="chk" value="chk4">체크 4<br>
		<button>전송</button>
	</form>
</body>
</html>