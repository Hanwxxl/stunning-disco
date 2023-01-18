package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.UserDTO;
import model.dto.VisitDTO;
import model.service.VisitService;

/**
 * 방명록을 위한 컨트롤러
 * @author user1
 */
public class VisitController extends HttpServlet {

	/**
	 * 방명록 페이지 요청이 있을 경우 사용하는 메서드
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VisitService service = new VisitService();
		List<VisitDTO> visitList = service.getList();
		req.setAttribute("dataList", visitList);
		req.getRequestDispatcher("/WEB-INF/view/visit.jsp").forward(req, resp);
	}

	/**
	 * 방명록 작성 후 저장 요청이 있을 경우 사용하는 메서드
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("login") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		UserDTO userData = (UserDTO)session.getAttribute("user");
		
		VisitDTO dto = new VisitDTO();
		String context = req.getParameter("context");
		dto.setUserId(userData.getUserId());
		dto.setContext(context);

		VisitService service = new VisitService();
		boolean result = service.add(dto);

		if(result) {
			resp.sendRedirect("./visit");
		} else {
			req.getRequestDispatcher("/WEB-INF/view/fail.jsp").forward(req, resp);
		}
	}
}