package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAndView;

public interface Controller {
	//이동할 경로를 잡아줘야해서 void 쓰면 X, execute로 추상화
	//ModelAndView 는 내가 이동할 페이지 정보, sendredirect로 할것인지,forward로 할건지 결정해주는 부분
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response);
}
