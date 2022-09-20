package day0920_cookie_session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");

		if (userid.equals("ssafy") && userpw.equals("ssafy")) {
			HttpSession session = req.getSession();
			session.setAttribute("loginInfo", userid); // 로그인 성공 기록
			System.out.println("로그인 성공");
		} else {
			// 로그인 실패 => 추후에 로그아웃 기능 이렇게 만듬
			HttpSession session = req.getSession();
			session.removeAttribute("loginInfo"); // 이럴수도 잇지만 보통은 로그아웃하면 그냥 세션 객체를 새로 갱신함.
			session.invalidate(); // 기존 세션 객체를 통으로 삭제	
		}
	}
}
