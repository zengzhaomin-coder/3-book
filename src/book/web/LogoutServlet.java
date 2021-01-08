package book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("���ڿ�ʼע��!");
		HttpSession session = req.getSession();
		
		// session.setAttribute("account", null);
		// session.removeAttribute("account");
		session.invalidate(); // ������ session ���󶼸��ٵ�
		
		req.getRequestDispatcher("/list").forward(req, resp);
	}
}
