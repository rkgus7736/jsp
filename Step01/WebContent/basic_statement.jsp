<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기초문법</title>
</head>
<body>
	<!-- 순서 
		1.<%! %> : 필드나 메서드 생성
		2.<% %> : 실제로 화면에 출력하기 위한 일을 진행 
		3.<%= %> : 해당 html 위치에 데이터를 출력
		
		//실제 우선순위는 1->3->2순서로 진행 -->
	 
	<!-- 선언문 : jsp에서 변수나 메서드 생성을 위한 문법-->
	<%!
		//필드와 메서드를 작성 jsp:클래스
	String message = "선언문 메세지";
	
	public String getMessage(){
		return message;
	}
		
	%>
	<!-- 표현식 :jsp에서 변수값, 또는 결과값을 웹에 출력할때 사용 -->
	선언문 필드 테스트: <%=message %> <br>
	선언문 메서드 테스트 : <%=getMessage() %> <br>
	<!-- 스크립트릿 : 자바코드 작성할때 사용,
				  사용자가 서버에 데이터를 전달하는 수단 -->
	<% 
		//request : 사용자의 요구사항 및 사용자 정보를 담고있는 객체
		int num=Integer.parseInt(request.getParameter("num"));
		String str = request.getParameter("msg");
	%>
	스크립트릿 테스트: <%=num%> <br>
	스크립트릿 테스트: <%=str%>
	
	<!-- 실제 jsp가 일처리하는 코드 -->
	<% 
		//웹에 출력 
		response.getWriter().println(message+1);
		response.getWriter().println("<br>");
		response.getWriter().println(message+2);
		response.getWriter().println("<br>");		
		//response.getWriter : 사용자에게 응답을 할때 사용 (직접적으로 출력)
	%>
</body>
</html>