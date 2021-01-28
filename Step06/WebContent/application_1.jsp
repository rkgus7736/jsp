<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application-1</title>
</head>
<body>
<%
	application.setAttribute("app_num", 777);
%>
	<!-- 어플리케이션 정보출력 -->
	<%=application.getServerInfo() %><br>
	<%=application.getRealPath("application_1.jsp") %><br>
	<!-- 어플리케이션 저장한 부분 꺼내기 -->
	<a href="application_2.jsp">다음 페이지</a>

</body>
</html>