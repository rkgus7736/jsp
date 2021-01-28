<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		int age = Integer.parseInt(request.getParameter("age")); //form으로 전송한건 getParameter로 읽어옴
	
		
		String path = " ";
		if(age >= 20)
			path="age_result_1.jsp";
		else 
			path="age_result_2.jsp";
		
		//처리 방법 1
	//	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	//	dispatcher.forward(request, response);

		//처리 방법 2 (한줄로 끝낼수있다는 장점)
		request.getRequestDispatcher(path).forward(request, response);
	%>