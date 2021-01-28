<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container{
		height: 600px;
		/* background-color: lime; */
	}
	
</style>
</head>
<body>
	
<!-- 메뉴부분 -->
<style>
	nav {
		width:1200px;
		margin:0 auto;/* 가운데 정렬  */
		border:1px solid black;
		text-align: center;
	}
	ul{
		list-style-type: none;
		height: auto;
		display: inline-block;
	}
	li{
		display: inline-block;
	}
	#menu_bar a:link,#menu_bar a:visited {
		color:black;
		text-decoration: none;
		font-size: 17px;
		text-align: center;
		padding: 20px 30px;
	}
</style>

	<nav id="menu_bar">
		<ul>
			<li><a href="index.jsp">HOME</a></li>
			<li><a href="#">회원가입</a></li>
			<li><a href="login.jsp">로그인</a></li>
			<li><a href="#">회원관리</a></li>
		</ul>
	</nav>
	<div id="container">
	메인페이지
	</div>
	
<style>
	footer{
		height: 100px;
		background-color: gray;
		text-align: center;
		font-size:20px;
		padding-top:40px;
	}
</style>

	<footer>
	카피라이트,회사정보 출력,사업자 정보 출력
	</footer>

</body>
</html>