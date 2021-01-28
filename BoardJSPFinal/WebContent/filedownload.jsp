<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//다운로드할 파일명
	String fileName = request.getParameter("file");
	String writer = request.getParameter("writer");
	//다운로드할 파일 전체 경로
	String path = "c:\\fileupload\\" + writer + File.separator + fileName;
	//String path = fileName;
	File file = new File(path);
	System.out.println(file.toString());
	FileInputStream fis = new FileInputStream(path);
	String encodingName = URLEncoder.encode(path,"utf-8");
	System.out.println("파일이름:"+fileName);
	//다운로드시 나타낼 기본파일명
	fileName = URLEncoder.encode(fileName,"utf-8");
	response.setHeader("Content-Disposition", "attachment;filename="+fileName);
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setContentLength((int)file.length());
	
	//사용자에게 파일을 전송
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	//버퍼 생성
	byte[] buffer = new byte[1024*1024];
	
	while(true){
		int size = fis.read(buffer);//읽어온 바이트수
		if(size == -1) break;//더이상 읽을 내용이 없음
		bos.write(buffer,0,size);
		bos.flush();		
	}
	 
	fis.close();
	bos.close();
%>