package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.MemberVo;

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
		System.out.println("login Post");
		//1 
		MemberVo vo = new MemberVo();
		vo.setUserID(request.getParameter("userID"));
		vo.setUserPassword(request.getParameter("userPassword"));

		//2
		MemberVo result = new MemberService().login(vo);
		if(result != null) {
			System.out.println("로그인성공");
			request.setAttribute("msg", "반갑습니다.");
			request.getRequestDispatcher("/msgAlert.jsp").forward(request,response);
			request.getSession().setAttribute("lgnss", result);
		}else {
			System.out.println("로그인실패");
			request.setAttribute("msg", "일치하는 아이디와 패스워드가 없습니다. 다시 확인하시고 로그인해주세요");
			request.getRequestDispatcher("/msgAlert.jsp").forward(request,response);
		}

		//3 페이지이동 및 데이터전달
//		response.sendRedirect("./main.jsp");
	}
	
}
	