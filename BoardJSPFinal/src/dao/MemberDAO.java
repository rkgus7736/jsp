package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import exception.MemberException;
import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private SqlSession session;
	private MemberDAO() {
		session = DBManager.getInstance().getSession();
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberVO selectMemberVO(String id) {
		return session.selectOne("member.selectMemberVO", id);
	}
	
	public void insertMemberVO(MemberVO vo) throws MemberException {
		session.insert("member.insertMemberVO",vo);
	}

	public void updatePass(String id, String pass) throws MemberException {
		HashMap<String, Object>map = new HashMap<String,Object>();
		//아이디값 맞춰주기
		map.put("id", id);
		map.put("pass", pass);
		session.update("member.updatePass",pass);
	}

	public MemberVO login(String id, String pass) {
		HashMap<String, Object>map = new HashMap<String,Object>();
		//아이디값 맞춰주기
		map.put("id", id);
		map.put("pass", pass);
		//객체가 한개라서 selectOner
		return session.selectOne("member.login",map);
	}

	public void updateMember(MemberVO vo) throws MemberException {
		session.update("member.updateMember",vo);
		session.commit(); //오토커밋 아닐때
	}

	public List<MemberVO> selectAllMemberVO() {
		//반드시 ArrayList를 사용할 필요는 없다
		//조회에 빠른건 ArrayList,수정이나 삭제에 빠른건 LinkedList
		//그냥 받아오는거면 List를 써도 됨
		List<MemberVO> list = session.selectList("member.selectAllMember");
		return list;
	}

	public List<MemberVO> searchMember(String kind, String search) {
		HashMap<String, Object>map = new HashMap<String,Object>();
		map.put("kind", kind);
		map.put("search", search);
		return session.selectList("member.searchMember",map);
	}

	public int updateManageMember(MemberVO vo) {
		return session.update("member.updateManageMember",vo);
	}
	
	
	public int deleteMember(String id) {
		return session.delete("member.deleteMember",id);
	}
	
	
	
	
}



















