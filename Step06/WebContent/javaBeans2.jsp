<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id : 변수명 scope:이동할 곳 -->
	<jsp:useBean id="person" class="dto.PersonDTO" scope="page"></jsp:useBean>
	<%=person.getName() %> <%=person.getAge() %>
	<hr>
	<jsp:useBean id="person1" class="dto.PersonDTO" scope="session"></jsp:useBean>
	<%=person.getName() %> <%=person.getAge() %>
	<hr>
	<a href="javaBeans1.jsp">페이지 이동</a>
</body>
</html>