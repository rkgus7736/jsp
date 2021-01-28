package conn.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet") //URL Mapping
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //login.jsp의 form에서 전달하는 method의 속성값이 get일때 처리하는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //화면에 출력시 문자코드 및 내용 형식을 설정해주는 부분
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(request.getParameter("id"));
		
		//세션 : request로 정보를 넘겨도 가지고 있어야하는 정보가 있을때 세션사용
		HttpSession session = request.getSession(); //request에선 세션 정보를 읽어옴
		session.setAttribute("text", "session message");
		
		//페이지 이동
			//1번째 방법
		//response.sendRedirect("login_result.jsp"); : 사용자의 요청사항이 전부 소실(더이상의 응답을 받을 필요가 없을 때 사용)
			// 2번째 방법
		System.out.println(request.getRequestURL());
		request.setAttribute("id", request.getParameter("id"));
		request.getRequestDispatcher("/result/login_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//method의 속성값이 post일때 처리하는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글 깨짐 방지 인코딩 (데이터를 받았을때 문자코드 변경해주는 부분)
		doGet(request, response);
	}

}
