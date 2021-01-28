package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardDTO;
import dto.CommentDTO;
import dto.QnaDTO;

public class QnADAO {
	private static QnADAO instance = new QnADAO();
	private DBManager manager;
	private SqlSession session;
	private QnADAO() {
		manager = DBManager.getInstance();
		session = DBManager.getInstance().getSession();
	}

	public static QnADAO getInstance() {
		if(instance == null)
			instance = new QnADAO();
		return instance;
	}

	public void insertQna(QnaDTO dto) {
		int result = 0;
		result = session.insert("qna.insert",dto);
		session.commit();
	}
	
	//개인 문의 목록을 조회
	public List<QnaDTO> selectQnaList(String id, int pageNo){
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<QnaDTO> list = null;
		list = session.selectList("qna.selectQnaList", map);
		return list;
	}

	public List<QnaDTO> selectQnaAdminList(int pageNo) {
		List<QnaDTO> list = null;
		list = session.selectList("qna.selectQnaAdminList", pageNo);
		return list;
	}

	public List<QnaDTO> selectNoAnswerList() {
		List<QnaDTO> list = null;
		list = session.selectList("qna.selectNoAnswerList");
		System.out.println(list);
		System.out.println(list.size());
		return list;
	}

	public int selectCountQna() {
		int count = session.selectList("qna.selectCountQna");
		session.commit();
		return count;
	}

	public QnaDTO selectQna(int qno) {
		QnaDTO dto =session.selectOne("qna.selectQna", qno);
		return dto;
	}

	public int updateResponse(int qno, String answer) {
		int count = session.update("qna.updateQnAStatus");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qno",qno );
		map.put("answer", answer );
		int count = session.selectOne("qna.updateResponse", map);
		return count;
	}

	public void updateQnAStatus(int qno) {
		int count = 0;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qno",qno );
		count = session.selectOne("qna.updateQnAStatus", map);
	}
}



















