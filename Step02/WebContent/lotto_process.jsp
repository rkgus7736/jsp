<%@page import="java.util.Random"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
	
	<!-- 입력받은 세트 갯수만큼 로또번호를 생성후 lotto_result.jsp로 전송 -->
<%!
	boolean checkNumber(int arr[], int n){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==n) 
				return false;
		}
		return true;
	}
%>
<%
		//개수 입력
		int ea = Integer.parseInt(request.getParameter("ea"));
		
		//로또 번호를 생성(set이나 2차원 배열 사용하면 됨)
		Random r = new Random();
		int arr[][] = new int[ea][6];
		for(int i=0;i<ea;i++){
			for(int j=0;j<arr[i].length;j++){
				int n = r.nextInt(45)+1;
				if(checkNumber(arr[j], n)){
					arr[i][j]=n;
				}else{
					j--;
				}
			}
		}
		request.setAttribute("lotto", arr);
		request.getRequestDispatcher("lotto_result.jsp").forward(request, response);
%>
