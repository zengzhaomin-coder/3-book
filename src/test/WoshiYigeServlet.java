package test;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/woshishui")
public class WoshiYigeServlet implements Servlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("�����ڱ���ʼ�������� WoshiYigeServlet ��");
	}
	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().write("hello, world");
	}
}




