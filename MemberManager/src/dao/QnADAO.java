package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.QnaDTO;

public class QnADAO {
	private static QnADAO instance = new QnADAO();
	
	private QnADAO() {

	}

	public static QnADAO getInstance() {
		if(instance == null)
			instance = new QnADAO();
		return instance;
	}

	public int insertQna(QnaDTO dto) {
		int result = 0;
		
		String sql = "insert into qna(qno, title, content, writer) "
				+ "values(qno_seq.nextval, ?, ? ,?)";
		try {
			PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	//개인 문의 목록을 조회
	public ArrayList<QnaDTO> selectQnaList(String id, int pageNo){
		String sql = "select * from (select ceil(rownum / 5) as page, qno, title, content, wdate, writer, status, nvl(response,'입력된 답변이 없습니다') from (select * from qna where writer = ? order by qno desc)) where page = ?";
		ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, pageNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnaDTO(rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<QnaDTO> selectQnaAdminList(int pageNo) {
		String sql = "select * from (select ceil(rownum / 5) as page, qno, title, content, wdate, writer, status, response from (select * from qna order by status asc, qno desc)) where page = ?";
		ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setInt(1, pageNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnaDTO(rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<QnaDTO> selectNoAnswerList() {
		String sql = "select * from qna where status in(0,1)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new QnaDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	public int selectCountQna() {
		String sql = "select count(*) from qna";
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public QnaDTO selectQna(int qno) {
		String sql = "select qno, title, content, wdate, writer, status, "
				+ "nvl(response,'답변 없음') from qna where qno = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaDTO dto = null;
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setInt(1, qno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new QnaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	public int updateResponse(int qno, String answer) {
		String sql = "update qna set response = response || ?, status=2 where qno = ?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setString(1, answer);
			pstmt.setInt(2, qno);
			count = pstmt.executeUpdate();
			DBManager.getInstance().getConn().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public void updateQnAStatus(int qno) {
		String sql = "update qna set status = 1 where qno = ? and status not in(1,2)";
		int count = 0;
		
		PreparedStatement pstmt = null;
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setInt(1, qno);
			count = pstmt.executeUpdate(); 
			if(count == 0) throw new SQLException("해당 문의글이 없습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(pstmt, null);
		}
		
	}
}



















