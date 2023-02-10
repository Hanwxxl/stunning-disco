package filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebFilter("/*")
public class LoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;

		// 요청에 대한 선행 작업은 이 곳에서 한다.
		String uriPath = request.getRequestURI();
		// String localPath = request.getServletContext().getRealPath(uriPath);
		String method = request.getMethod();
		// String query = request.getQueryString();
		// Map<String, String[]> params = request.getParameterMap();
		// for(Entry<String, String[]> e: params.entrySet()) {
		// 	System.out.println(e.getKey() + ":" + Arrays.toString(e.getValue()));
		// }

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a KK:mm:ss.SSS");
		Date now = new Date();

		System.out.printf("[%s] - %s: %s\n", df.format(now), method, uriPath);

		chain.doFilter(req, resp);  // 다음 필터 및 서블릿이 실행 될 수 있도록 한다.

		// 응답에 대한 후행 작업은 이 곳에서 한다.
		// System.out.println("LoggingFilter - End");
		int status = response.getStatus();

		now = new Date();
		switch(status / 100) {
			case 2:
				System.out.printf("[%s] - %s: %s\n", df.format(now), status, "정상 응답");
				break;
			case 3:
				String location = response.getHeader("Location");
				System.out.printf("[%s] - %s: %s -> %s\n", df.format(now), status, "리다이렉트 응답", location);
				break;
			case 4:
				System.out.printf("[%s] - %s: %s\n", df.format(now), status, "요청 에러");
				break;
			case 5:
				System.out.printf("[%s] - %s: %s\n", df.format(now), status, "서버 에러");
				break;
		}
	}

}