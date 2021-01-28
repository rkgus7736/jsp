package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import config.SQLMapper;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private SqlSession session;
	private SQLMapper mapper;
	
	private EmployeeDAO() {
		session = DBManager.getInstance().getSqlSession();
		//일을 실행하는 주체 getMapper(어떤 mapper를 쓸것인지 써줘야함)
		mapper = session.getMapper(SQLMapper.class);
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public List<EmployeeDTO> selectAllEmployee(){
		return mapper.selectEmployeeAll();
	}
	public int selectEmployeeCount() {
		return mapper.selectEmployeeCount();
	}
	
	public List<EmployeeDTO> selectPositionEmployee(int pos) {
		return mapper.selectPositionEmployee(pos);
	}
	public List<EmployeeDTO> selectPositionAreaEmployee(int n1, int n2){
		return mapper.selectPositionAreaEmployee(n1, n2);
	}
	
//select를 제외하고 insert,update,delete는 정수로 return 되기때문에 public int로 써줘야 함
	public int insertEmployee(EmployeeDTO dto) {
		return mapper.insertEmployee(dto);
	}
	
	public int updateEmployee(HashMap<String,Object> map) {
		return mapper.updateEmployee(map);

	}
	
	public List<EmployeeDTO> selectNameEmployee(String name){
		return mapper.selectNameEmployee(name);
	}

}

