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
 * Servlet implementation class EnrollController
 */
@WebServlet("/enroll")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		request.getRequestDispatcher("/WEB-INF/view/member/enroll.jsp").forward(request, response);
	    	}
    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		request.setCharacterEncoding("UTF-8"); // 한글깨짐방지
    		String userID = request.getParameter("userID");  
    		String userPassword = request.getParameter("userPassword"); 
    		String userName = request.getParameter("userName");
    		String userEmail = request.getParameter("userEmail");
    		MemberVo vo = new MemberVo();
    		vo.setUserID(userID);
    		vo.setUserPassword(userPassword);
    		vo.setUserName(userName);
    		vo.setUserEmail(userEmail);
    		
    		
    		System.out.println("Ctrl param:" + vo);
    		
    		// DB갔다오기
    		int result = new MemberService().enroll(vo);
    		
    		if(result<1) {
    			System.out.println("회원가입실패.");
    		} else {
    			System.out.println("회원가입성공");
    			response.sendRedirect(request.getContextPath()+"/");
    		}
    	}
    }
