<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	boolean flag=false;
	//세션 정보를 읽어옴
	if(session.getAttribute("login") !=null)
		flag = (boolean)session.getAttribute("login");//object라서 boolean으로 바꿔줌
	
	//로그인 정보 출력
	if(flag){
		%>
			<%=session.getAttribute("name") %>님 로그인 하셨습니다.<br>
			<a href="logout.jsp">로그아웃</a> | 정보수정
		<%
	//로그인 창 출력
	}else{
		%>				
			<form action="login_process.jsp" method="post">
				<input type="text" name="id"><br>
				<input type="password" name="pass"><br>
				<button>로그인</button>
			</form>
		<%		
	}
%>

</body>
</html>