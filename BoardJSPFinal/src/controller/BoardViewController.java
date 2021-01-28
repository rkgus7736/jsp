package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.CommentDTO;
import dto.FileDTO;
import model.ModelAndView;
import service.BoardService;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getAttribute("board") == null) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			System.out.println("bno = "+ bno);
			BoardDTO board = BoardService.getInstance().selectBoardDTO(bno);
			System.out.println(board.toString());
			request.setAttribute("board", board);
			List<CommentDTO> list = BoardService.getInstance().selectCommentDTO(bno);
			request.setAttribute("comment", list);
			List<FileDTO> fList = BoardService.getInstance().selectFileList(bno);
			request.setAttribute("file", fList);
		}
		return new ModelAndView("board_detail_view.jsp", false);
	}

}