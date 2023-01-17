package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.UserDTO;
import model.service.UserService;

public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("name", "value");  // ("쿠키명","쿠키값")
		cookie.setMaxAge(60*60*24);  // 쿠키유효시간(초단위)
		resp.addCookie(cookie); 
		
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		UserDTO dto = new UserDTO();
		dto.setUserId(userId);
		dto.setPassword(password);
		
		UserService service = new UserService();
		UserDTO data = service.login(dto);
		
		if(data == null) {
			req.setAttribute("error", "아이디 또는 패스워드가 잘못되었습니다.");
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
		}else {
			resp.sendRedirect(req.getContextPath() + "/");
		}
	}
}