<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ErrorPage</title>
</head>
<body>
	페이지 처리 중 에러가 났습니다.
	Exception Class : <%=exception.getClass().getName() %><br>
	Exception Message : <%=exception.getMessage() %><br>
	<a href="javascript:history.back();">뒤로가기</a>
</body>
</html>