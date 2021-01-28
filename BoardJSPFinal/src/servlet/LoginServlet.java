package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet") //URL Mapping
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Destory LoginServlet");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init LoginServlet");
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //login.jsp의 form에서 전달하는 method의 속성값이 get일때 처리하는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberVO vo = MemberService.getInstance().login(id, pass);
		HttpSession session = request.getSession();
		if(vo != null) {
			//세션 처리
			session.setAttribute("login", true);
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("grade", vo.getGrade().toLowerCase());
			response.sendRedirect("main.jsp");
		}else {
			session.setAttribute("login", false);
			//response.getWriter() : out.write와 같은것
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>alert('아이디와 비번을 확인하세요');history.back();</script>");
			//response.sendRedirect("login.jsp"); or <script>안에 history.back 해주면 됨

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//method의 속성값이 post일때 처리하는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}







