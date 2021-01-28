<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
	margin:0;
	padding:0;
	}
	#container{
	width:700px;
	padding:20px;
	}
	h4{
	font-size: 18px;
	font-weight: bold;
	margin-top:15px;
	margin-left:15px;
	}
	a{
	width:50px;
	padding:10px 10px;
	background-color: green;
	float:right;
	text-decoration: none;
	text-align: center;
	margin:5px;
	}
	section{
	border:1px solid #e8e8e8;
	}
	textarea{
	width:600px;
	height:200px;
	border:none;
	resize: none;
	margin:5px;
	padding:15px;
	}
	footer{
	border:1px solid #e8e8e8;
	}
	a:hover{
	background-color: lime;
	}
</style>
</head>
<body>
	<jsp:useBean id="person" class="dto.PersonDTO" scope="page"></jsp:useBean>
	
	<jsp:setProperty property="name" name="person" value="홍길동"/>
		<div id="container">
			<section>
				<h4><%=person.getName() %></h4>
				<textarea rows="2" cols="7" placeholder="주제와 무관한 댓글이나 스포일러, 악플은 경고조치 없이 삭제되어 징계 대상이 될 수 있습니다."></textarea>
			</section>
			<footer>
				<a href="insertComment.jsp">등록</a>
			</footer>
		</div>
		
</body>
</html>