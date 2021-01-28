package service;

import java.util.ArrayList;
import java.util.List;

import dao.QnADAO;
import dto.QnaDTO;

public class QnAService {
	private static QnAService instance = new QnAService();
	private QnADAO dao;
	private QnAService() {
		dao = QnADAO.getInstance();
	}
	
	public static QnAService getInstance() {
		if(instance==null)
			instance= new QnAService();
		return instance;
	}

	public int insertQnA(QnaDTO dto) {
		return dao.insertQna(dto);
	}

	public List<QnaDTO> selectQnaList(String id, int pageNo,String grade) {
		
		if(grade.equals("master"))
			return dao.selectQnaAdminList(pageNo);
		return dao.selectQnaList(id, pageNo);
	}

	public List<QnaDTO> selectNoAnswerList() {
		return dao.selectNoAnswerList();
	}

	public int selectCount() {
		return QnADAO.getInstance().selectCountQna();
	}

	public QnaDTO selectQna(int qno) {
		//문의 글을 읽음 처리
		QnADAO.getInstance().updateQnAStatus(qno);
		//문의 글을 읽어옴
		return QnADAO.getInstance().selectQna(qno);
	}

	public int updateResponse(int qno, String answer) {
		//문의글 답변
		return QnADAO.getInstance().updateResponse(qno,answer);
	}
	
	
}










