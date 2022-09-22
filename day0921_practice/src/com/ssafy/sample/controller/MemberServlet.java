package com.ssafy.sample.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.model.service.MemberService;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.getService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			// 회원 정보 조회
			if ("detail".equals(action)) {

			}
			// 회원 삭제
			else if ("delete".equals(action)) {
				int no = Integer.parseInt(request.getParameter("no"));
				service.removeMember(no);

			}
			// 로그아웃
			else if ("logout".equals(action)) {
				request.getSession().invalidate();
				request.setAttribute("msg", "로그아웃 완료되었습니다.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("error/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("action");
		try {
			// 회원 추가
			if ("add".equals(action)) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				service.insert(new Member(id, pw, name, address, phone));

			} else if ("login".equals(action)) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				service.login(id, pw);
				System.out.println("LOGIN");
				request.getSession().setAttribute("loginInfo", id);
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}

		} catch (Exception e) {

			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
