<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%
   		String id = request.getParameter("id");
   		String pass = request.getParameter("pass");
   		
   		//session 유지시간 (초*분:자동 로그아웃 시간)
   		session.setMaxInactiveInterval(60*30);
   		
   		if(id.equals("admin") && pass.equals("1234")){
   			//로그인 성공 처리
   			session.setAttribute("login", true);//setAttribute: ("키값",value)
   			session.setAttribute("name", "관리자");//setAttribute: ("키값",value)
   			session.removeAttribute("msg");
   		}else{
   			//로그인 실패 처리
   			session.setAttribute("login", false);
   			session.setAttribute("msg", "로그인에 실패하셨습니다. 아이디와 비밀번호를 확인하세요.");
   		}
	   response.sendRedirect("login.jsp"); 
   %>
   