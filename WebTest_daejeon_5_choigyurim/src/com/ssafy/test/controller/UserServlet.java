package com.ssafy.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.test.dto.UserDto;
import com.ssafy.test.model.service.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl service = UserServiceImpl.getService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("login".equals(action)) {
			System.out.println("login servlet");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			UserDto userDto = service.login(id, pw);
			System.out.println(id + " " + pw);
			System.out.println(userDto);

			// 로그인 성공
			if (userDto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", userDto);
				request.getRequestDispatcher("index.jsp").forward(request, response);;
			}
			// 로그인 실패
			else {
				request.setAttribute("msg", "로그인 실패");
				request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			}
		}
		//로그아웃
		else if("logout".equals(action)) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}

}
