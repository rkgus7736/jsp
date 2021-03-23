package dao;

import java.util.ArrayList;

import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberVO selectMemberVO(String id) {
		return null;
	}
	public void insertMemberVO(MemberVO vo) {
	}

	public void updatePass(String id, String pass) {
		
	}

	public MemberVO login(String id, String pass) {
		return null;
	}

	public void updateMember(MemberVO vo) {
	}

	public ArrayList<MemberVO> selectAllMemberVO() {
		return null;
	}

	public ArrayList<MemberVO> searchMember(String kind, String search) {
		return null;
	}

	public boolean updateManageMember(MemberVO vo) {
		return true;
	}
	
	
	public boolean deleteMember(String id) {
		return true;
	}
	
	
}
