package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberService;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		// 로그인
		if ("login".equals(action)) {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			Member member = service.selectOne(id, pw);
			// 로그인 성공
			if (member != null) {
				System.out.println("login success");
				HttpSession session = req.getSession();
				session.setAttribute("loginInfo", member);
				req.getRequestDispatcher("loginSuccess.jsp").forward(req, res);
			}
			// 로그인 실패
			else {
				System.out.println("login fail");
				req.getRequestDispatcher("loginFail.jsp").forward(req, res);
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

	}

}
