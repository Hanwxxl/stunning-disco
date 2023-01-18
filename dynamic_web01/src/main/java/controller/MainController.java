package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MainController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cnt = req.getParameter("count");
		Integer iCnt = 0;
		if(cnt != null) {
			iCnt = Integer.parseInt(cnt);
		}
		req.setAttribute("iCnt", iCnt);
		
		HttpSession session = req.getSession();
		System.out.println("로그인 상태: " + session.getAttribute("login"));
		System.out.println("계정 정보: " + session.getAttribute("user"));
		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
	}

}
