<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input_search</title>
</head>
<body>
	<!--form, text box, submit button -->
	<form action="jsp_search.jsp" method="get">
	<!-- action : 데이터를 전송할 서버 페이지 -->
		<input type="text" name="search">
		<button>전송</button>
	</form>
<hr>
	<form action="gugu2.jsp" method="get">
	<!-- action : 데이터를 전송할 서버 페이지 -->
		<input type="text" name="dan" placeholder="출력할 구구단 단을 입력하세요">
		<button>전송</button>
	</form>
</body>
</html>