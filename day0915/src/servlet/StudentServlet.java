package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action.equals("insert")) {
			req.getRequestDispatcher("insert.jsp").forward(req, resp);
		} else if (action.equals("list")) {
			req.setAttribute("studentList", new StudentDao().selectAll());
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");

		if (action.equals("insert")) {
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			String address = req.getParameter("address");

			Student student = new Student(0, name, age, address);
			if (new StudentDao().insert(student) == 1) {
				req.getRequestDispatcher("insertSuccess.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("insertFail.jsp").forward(req, resp);
			}
		}
	}
}
