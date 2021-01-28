<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
	<h1>구구단 출력 1번째</h1>
	<% // <% : 서비스 부분 (메서드 내부), 메인이라고 생각하면 됨
		
		for(int i=1;i<10;i++){
			//System.out.println(3+"*"+i+"="+3*i); : 이클립스 콘솔에서 출력됨	
			response.getWriter().println(3 + "*" + i + "=" + 3*i + "<br>");			
			//response.getWriter : 사용자에게 응답을 할때 사용 (직접적으로 출력)
			//request :사용자가 요구사항을 보낼때 사용
		}
	%>
	<h1>구구단 출력 2번째</h1>
	<%! //!가 붙으면 우선 순위 필드로 선언됨,!를 안붙이면 미리 만들어둔 구성요소 (클래스 내부에 생성)
		public String getGuGu(int n){
			String result = ""; //구구단 결과 누적
			for(int i=1;i<10;i++){
				result += n + "*" + i + "=" + n*i + "<br>";
			}
			return result;
			}	
	%>
	<%=getGuGu(3) %> //불러다 쓰는 부분
</body>
</html>