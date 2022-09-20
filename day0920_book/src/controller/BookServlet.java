package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.BookService;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService service = new BookService();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		// 책 목록
		if ("list".equals(action)) {
			req.setAttribute("bookList", service.selectAll());
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		if ("add".equals(action)) {
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			int price = Integer.parseInt(req.getParameter("price"));
			String publisher = req.getParameter("publisher");

			Book book = new Book(title, price, publisher, writer);
			if (service.insert(book)) {
				req.getRequestDispatcher("BookInsertSuccess.jsp").forward(req, res);
			}

		}
	}

}
