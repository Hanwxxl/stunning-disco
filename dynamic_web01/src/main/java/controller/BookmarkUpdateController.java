package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.BookmarkDTO;
import model.service.BookmarkService;

//@WebServlet("/bookmark/update")
public class BookmarkUpdateController extends HttpServlet{
	
	/* 사용자가 수정요청한 id에 해당하는 데이터 조회 후 
	 * 수정 폼이 있는 JSP페이지를 제공하여 
	 * 사용자가 데이터를 수정할 수 있게 한다.
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		BookmarkDTO dto = new BookmarkDTO();
		dto.setId(Integer.parseInt(id));
		
		BookmarkService service = new BookmarkService();
		dto=service.get(dto);
		req.setAttribute("data", dto);
		req.getRequestDispatcher("/WEB-INF/view/bookmarkupdate.jsp").forward(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String url = req.getParameter("url");
		String name = req.getParameter("name");
		
		BookmarkDTO dto = new BookmarkDTO();
		dto.setId(Integer.parseInt(id));
		dto.setUrl(url);
		dto.setName(name);
		
		BookmarkService service=new BookmarkService();
		boolean result = service.update(dto);
		
		if(result) {
			resp.sendRedirect("../bookmark");
		} else {
			resp.sendRedirect("../fail");
		}
	
	}
}
