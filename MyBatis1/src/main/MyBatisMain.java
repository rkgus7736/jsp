package main;

import java.util.List;

import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class MyBatisMain {

	public static void main(String[] args) {
		
		EmployeeDAO dao = EmployeeDAO.getInstance();
		Scanner sc = new Scanner(System.in);

	/*
		int count = dao.selectEmployeeAllCount();
		System.out.println("현재 사원 인원수 : "+count);
		
		System.out.println("-------------------------------------------");
		List<EmployeeDTO> list = dao.selectAllEmployee();
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toString());
		
		System.out.println("--------------------------------------------");
		list = dao.selectPositionEmployee(4);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toString());
		
	//원하는 번호만 뽑아서 2,5 레벨의 직원들만 추출
		System.out.println("--------------------------------------------");
		list = dao.selectPositionEmployee(2,5);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toString());
	
		System.out.println("--------------------------------------------");
	//insert
		 String eno = sc.nextLine(); 
		 String name = sc.nextLine(); 
		 String department = sc.nextLine(); 
		 int position = sc.nextInt(); 
		 int count = dao.insertEmployee(new EmployeeDTO(eno,name,department,position));
		 System.out.println("count");
		 System.out.println("-----------------------------------------");
		 List<EmployeeDTO> list = dao.selectAllEmployee();
		 for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toString());
			
	//update
		   String eno = sc.nextLine(); 
 		   String name = sc.nextLine(); 
 		   String department = sc.nextLine(); 
 		   int position = sc.nextInt(); 
		   int count = dao.updateEmployee(new EmployeeDTO(eno,name,department,position)); 
		   System.out.println("count"); 
		   System.out.println("-----------------------------------------"); 
		   list = dao.selectAllEmployee(); 
		   for(int i=0;i<list.size();i++)
		   System.out.println(list.get(i).toString());
		
	//특정 문자 (와일드 카드)
		System.out.println("검색할 이름의 일부를 입력하세요 >");
		String search = sc.nextLine();
		//검색결과가 하나면 EmployDTO, 여러개가 나올수있다면 List 사용해야함
		List<EmployeeDTO> list = dao.selectNameEmployee(search);
		for(int i=0;i<list.size();i++)
		System.out.println(list.get(i).toString());
		
		
		System.out.println("삭제할 사원의 직급을 입력하세요 1~7 : ");
		int position = sc.nextInt();
		System.out.println(dao.deletePositionEmployee(position));
		//검색결과가 하나면 EmployDTO, 여러개가 나올수있다면 List 사용해야함
		List<EmployeeDTO> list = dao.selectAllEmployee();
		for(int i=0;i<list.size();i++)
		System.out.println(list.get(i).toString());
	 */
		List<EmployeeDTO> list = dao.selectSearchEmployee("name","수");
		for(int i=0;i<list.size();i++)
		System.out.println(list.get(i).toString());
	}
}		
