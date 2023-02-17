package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginurl")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.getRequestDispatcher("./login.jsp").forward(request, response);  // login.jsp로 이동
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginurl - doPost()");
		String id = request.getParameter("n1"); 
		String pw = request.getParameter("n2");
		System.out.println(id);
		System.out.println(pw);
		
		//TODO: DB갔다오기
		int result = new MemberService().login(id,pw); // 1로그인성공, 0로그인실패
		if(result==1) {
			request.setAttribute("msg", "반갑습니다.");
		}else if(result == -1) {
			request.setAttribute("msg", "죄송합니다. 현재 시스템이 비정상동작하여 잠시 후 다시 시도해주세요.");
		}else {
			request.setAttribute("msg", "일치하는 아이디와 패스워드가 없습니다. 다시 확인하시고 로그인해주세요");
		}
		request.getRequestDispatcher("./msgAlert.jsp").forward(request,response);
	}

}
