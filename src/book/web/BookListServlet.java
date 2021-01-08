package book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.bean.Book;
import book.dao.BookDAO;

@WebServlet("/list")
public class BookListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("���� list �У����й���");

		try {
			List<Book> books = new BookDAO().list();

			// �� books �������ݣ������浽�� req �� xxx ��
			req.setAttribute("xxx", books);

			// �� /book/linshigong ��������Ǹ� Servlet ȥ����������������߼�
			req.getRequestDispatcher("/book/bookList.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("message", "Error Ocurred.");
			req.getRequestDispatcher("/book/bookResult.jsp").forward(req, resp);
		}
	}
}
