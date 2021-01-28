<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 전송 버튼 클릭을 했을 때 RouteTest 서블릿에서 
		result 폴더에 있는 Route_result.jsp로 이동하여 입력한 내용을 출력 -->
	<!-- <form action="../RouteTest" method="get"> 두가지 방법으로 경로 설정-->
	<form action="<%=request.getContextPath()%>/RouteTest" method="get"> 
		<input type="text" name="txt"><br>
		<button>전송</button>
	</form>
</body>
</html>