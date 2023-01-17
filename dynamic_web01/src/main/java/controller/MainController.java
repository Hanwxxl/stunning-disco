package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cnt = req.getParameter("count");
		Integer iCnt = 0;
		if(cnt != null) {
			iCnt = Integer.parseInt(cnt);
		}
		req.setAttribute("iCnt", iCnt);
		
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			System.out.println(c.getName() + "|" + c.getValue());
		}

		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);

		
	}

}