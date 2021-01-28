<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!-- 실행은 person.jsp 에서 해야함  
		person.jsp : 데이터 입력받아서 전송 - form으로 받아서 html로 작성해도 됨 (jquery도 사용가능)
		person_process : 데이터 받아서 처리
		person_result.jsp : 결과를 받아서 화면에 출력-->
		
<!-- 이름,나이 입력받는 폼 -->
	<form action="person_process.jsp" method="get">
		<input type="text" name="name" placeholder="이름 입력">
		<input type="text" name="age" placeholder="나이 입력">
		<button>전송</button>	
	</form>
	

</body>
</html>