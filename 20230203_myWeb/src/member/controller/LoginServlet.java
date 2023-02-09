package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import first.common.JDBCTemplate;
import member.model.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginurl")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.append("Served at: ").append(request.getContextPath());
//		out.append("<h1>추가</h1>");
//		request.setAttribute("aaa", "전달할 데이터");
//		response.sendRedirect(request.getContextPath()+"/?aaa=전달할데이터");
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginurl - doPost()");
		String id = request.getParameter("n1");    // 아이디 꺼내오기
		String pw = request.getParameter("n2");    // 비번 꺼내오기
		// TODO : DB갔다오기
		int result = new MemberService().login(id,pw); // 1로그인성공, 0로그인실패
		if(result == 1) {
//			response.sendRedirect(request.getContextPath()+"/");
			request.setAttribute("msg", "xx님 로그인 되었습니다. 반갑습니다.");
		}else if(result == -1) {
			request.setAttribute("msg", "죄송합니다. 현재 시스템이 비정상동작하여 잠시 후 다시 시도해주세요.");
		}else{
			request.setAttribute("msg", "일치하는 아이디와 패스워드가 없습니다. 다시 확인하시고 로그인해주세요");
		}
		request.getRequestDispatcher("/WEB-INF/msgAlert.jsp").forward(request, response);
			
		}
	}


