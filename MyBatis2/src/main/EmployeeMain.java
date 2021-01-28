package main;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeMain {

	public static void main(String[]args) {
		EmployeeDAO dao = EmployeeDAO.getInstance();
		Scanner sc = new Scanner(System.in);

		List<EmployeeDTO> list = EmployeeDAO.getInstance().selectAllEmployee();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
	/*
		System.out.println("------------------------------------------");
		System.out.println(EmployeeDAO.getInstance().selectEmployeeCount());
		
		System.out.println("------------------------------------------");
		list = EmployeeDAO.getInstance().selectPositionEmployee(5);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		
		System.out.println("------------------------------------------");
		list = EmployeeDAO.getInstance().selectPositionAreaEmployee(2,5);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("-----------------------------------------");
		
		String eno = sc.nextLine(); 
        String name = sc.nextLine(); 
		String department = sc.nextLine(); 
		int position = sc.nextInt(); 
		System.out.println(EmployeeDAO.getInstance().insertEmployee(new EmployeeDTO(eno,name,department,position)));

		}
		String eno = sc.nextLine(); 
	    String name = sc.nextLine(); 
		String department = sc.nextLine(); 
		int position = sc.nextInt(); 
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("eno", eno);
		map.put("name", name);
		map.put("department", department);
		map.put("position", position);
		System.out.println(EmployeeDAO.getInstance().updateEmployee(map));
	*/		

		System.out.println("-----------------------------------------");
		System.out.println("검색할 이름의 일부를 입력하세요 >");
		String name = sc.nextLine();
		//검색결과가 하나면 EmployDTO, 여러개가 나올수있다면 List 사용해야함
		list = EmployeeDAO.getInstance().selectNameEmployee(name);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
			
		}

	}
}
