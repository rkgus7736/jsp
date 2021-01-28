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
	<!-- property : 구성 요소 name : 내가 접근할 개체 이름-->
	<jsp:setProperty property="name" name="person" value="홍길동"/>
	<jsp:setProperty property="age" name="person" value="20"/>
	<%=person.getName() %> <%=person.getAge() %>
	<hr>
	
	<jsp:useBean id="person1" class="dto.PersonDTO" scope="session"></jsp:useBean>
	<jsp:setProperty property="name" name="person2" value="홍길동2"/>
	<jsp:setProperty property="age" name="person2" value="202"/>
	<%=person.getName() %> <%=person.getAge() %>
	<hr>
	<jsp:useBean id="person2" class="dto.PersonDTO" scope="application"></jsp:useBean>
	<jsp:setProperty property="name" name="person3" value="홍길동3"/>
	<jsp:setProperty property="age" name="person3" value="203"/>
	<%=person.getName() %> <%=person.getAge() %>
	<hr>
	
	<a href="javaBeans2.jsp">페이지 이동</a>
</body>
</html>