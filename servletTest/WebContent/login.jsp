<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
	<!-- 로그인 폼 -->
	<form action="LoginServlet" method="get">
		<label>아이디: <input type="text" name="id"></label><br>
		<label>비밀번호: <input type="password" name="pass"></label><br>
		<button>입력</button>
	</form>
</body>
</html>