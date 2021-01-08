package book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import book.dao.LogDAO;

@WebFilter("/*")
public class FangwenRizhiFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ���и�������ص����ݣ����� tomcat ��װ���� request ����
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		String ip = req.getRemoteAddr();
		String userAgent = req.getHeader("user-agent");
		
		// ���ڿ�����ʱ��鿴���
		System.out.println("url: " + url + " up: " + ip + " userAgent: " + userAgent);
		
		// ��������ݲ��뵽����
		LogDAO logDAO = new LogDAO();
		try {
			logDAO.insert(url, ip, userAgent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ����
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void destroy() {
	}
}
