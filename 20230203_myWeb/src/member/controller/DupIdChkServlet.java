package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DupIdChkServlet
 */
@WebServlet("/dupid.lo")
public class DupIdChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdChkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
			
		// 1. 전달받은 데이터를 꺼낸다.
		String id = request.getParameter("id");
		System.out.println("전달받은데이터: " + id);
		// 2. DB 갔다오기
		// TODO:
		//new MemberService().
	
		// 3. 결과에 데이터를 전달 (페이지이동안함)
		PrintWriter out = response.getWriter();
		out.append("0");
		out.flush();
		out.close();
	}

}
