package config;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dto.EmployeeDTO;

/*
 * 리턴타입 --> SQL 결과 형태
 * 매개변수 --> PreparedStatement의 ? 처리를 위한 값 
 * 메서드명 --> 실행할 sql문을 지칭
 * SQL문은 어노테이션으로 실행
 * 
 * */
public interface SQLMapper {
	@Select("select * from employee")
	public List<EmployeeDTO> selectEmployeeAll();
	
	@Select("select count(*) from employee")
	public int selectEmployeeCount();
	
	// 매개변수가 하나인 경우 
	@Select("select * from employee where position < #{no}")
	public List<EmployeeDTO> selectPositionEmployee(int param);
	
	// 매개변수가 여러개
		// 매개변수가 여러개인 경우에만 #{ }에 들어가는 이름을 신경써주면 됨 
	@Select("select * from employee where position between #{n1} and #{n2}")
	public List<EmployeeDTO> selectPositionAreaEmployee(@Param("n1") int num1, @Param("n2") int num2);

	//map이나 dto가 들어오면 매개변수와 자동으로 매칭 (정보들이 알아서 들어옴) 
	@Insert("insert into employee(eno,name,department,position) values(#{eno},#{name},#{dapartment},#{position})")
	public int insertEmployee(EmployeeDTO dto);
	
	// Map 사용
	@Update("update employee set name = #{name}, department = #{department}, position = #{position} where eno = #{eno}")	
	public int updateEmployee(HashMap<String,Object> map);
	
	//인터페이스
		//preparedstatement를 쓸거면 #{name}에 ? 로 써도 됨.
		//매개변수가 하나면 @Param은 선택사항
	@Select("select * from employee where name like '%'||#{name}||'%'")
	public List<EmployeeDTO> selectNameEmployee(@Param("name") String name);
	// = public List<EmployeeDTO> selectNameEmployee(String name);
	
}











