<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//검색할 종류도 DAO 객체까지 전달해줘야 함
	//검색할 종류 : kind
	String kind = request.getParameter("kind");
	//검색어
	String search = request.getParameter("search");
	
	//검색 결과를 받아서 클라이언트에게 출력 (여기서는 out.write)	
	if(kind.equals("grade"))
		kind = "grade_name";
	search = search.toUpperCase();
	ArrayList<MemberVO> list = MemberService.getInstance().searchMember(kind,search);
	
	//json 생성	
	JSONObject jsonObject = new JSONObject();
	//결과만 받을거라서 array만
	JSONArray jsonArray = new JSONArray(); 
	
	for(int i=0;i<list.size();i++){
		JSONObject temp = new JSONObject();
		temp.put("id", list.get(i).getId());
		temp.put("name",list.get(i).getName());
		temp.put("age",list.get(i).getAge());
		temp.put("grade",list.get(i).getGrade());
		jsonArray.put(temp);		
	}
	jsonObject.put("result", jsonArray);
	out.write(jsonObject.toString());	
	//json 사용 X
//		result += list.get(i).getId()+ " " + list.get(i).getName()
//				+ " " + list.get(i).getAge()+ " " + list.get(i).getGrade()+",";
		
//		String result=""; //사용자가 받았을때 적절한 형태를 띄어줘야함
//		out.write(result);
//		//" " : 띄어쓰기로 입력한 내용 구분 ","" : 줄 구분
//		for(int i=0;i<list.size();i++){
//		result += list.get(i).getId()+ " " + list.get(i).getName()
//				+ " " + list.get(i).getAge()+ " " + list.get(i).getGrade()+",";
		
//		}	
		//DAO에서는 검색할 때 sql문을 직접 조립	
		// name, id, grade 셋중 뭘로 할건지 결정해줘야함
		//select * from memeber where name like '%검색어%'
		//select * from memeber where id like '%검색어%'
		//select * from memeber where grade like '%검색어%'
%>





