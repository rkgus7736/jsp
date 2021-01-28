<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력한 숫자만큼 반복 수행</h1>
	<table border="1">
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>글내용</th>
	</tr>
	<%	
		//getAttribute할거면 형변환을 두번정도 해줘야함
		int ea = Integer.parseInt(request.getParameter("ea"));
		//for(int i=0;i<ea;i++){ //정순서
		for(int i=ea;i>0;i--){ //역순서 
			out.write("<tr>");
			out.write("<td>"+i+"</td>");
			out.write("<td>제목"+i+"</td>");
			out.write("<td>내용"+i+"</td>");
			out.write("</tr>");
		}
	%>
	</table>
</body>
</html>