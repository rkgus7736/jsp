package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.QnaDTO;
import model.ModelAndView;
import service.QnAService;

public class QnaViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		//해당 아이디에 해당되는 문의 목록을 조회, 처음에는 페이지 번호 1
		int pageNo = 1;
		//아이디는 session에서 읽음
		String id = (String) request.getSession().getAttribute("id");
		if(id == null) {
			view.setPage("main.jsp");
			view.setSendRedirect(true);
			return view;
		}
		//단, 관리자면 모든 사용자의 문의 목록을 조회 
		//관리자가 한명이 아닐수있어서 세션으로 grade를 받아서 관리자 여부를 확인함
		// 문의목록은 request or session 영역에 저장
		String grade = (String) request.getSession().getAttribute("grade");
		List<QnaDTO> list = QnAService.getInstance().selectQnaList(id,pageNo,grade);
		request.setAttribute("list", list);
		//페이지는 qna.jsp로 이동
		view.setPage("qna.jsp");
		view.setSendRedirect(false);
		return view;
	}

}


