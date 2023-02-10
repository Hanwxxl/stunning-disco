package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;


public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		UserDTO userData = (UserDTO)session.getAttribute("user");
		BookmarkDTO dto = new BookmarkDTO();
		dto.setUserId(userData.getUserId());
		
		BookmarkService service = new BookmarkService();
		List<BookmarkDTO> data = service.getPage(dto);
		req.setAttribute("data", data);
		
		req.getRequestDispatcher("/WEB-INF/view/bookmark.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		UserDTO userData = (UserDTO)session.getAttribute("user");

		BookmarkDTO dto = new BookmarkDTO();
		dto.setUserId(userData.getUserId());
		dto.setUrl(req.getParameter("url"));
		dto.setName(req.getParameter("name"));
		
		BookmarkService service = new BookmarkService();
		boolean result = service.add(dto);
		
		if(result) {
			resp.sendRedirect("./bookmark");
		} else {
			resp.sendRedirect("./fail");
		}
	}

}
