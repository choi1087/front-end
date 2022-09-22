package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.model.service.ItemService;

@WebServlet("/item")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemService service = ItemService.getService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		try {

			// 아이템 목록
			if ("list".equals(action)) {
				request.setAttribute("itemList", service.getItems());
				request.getRequestDispatcher("product/list.jsp").forward(request, response);
			}
			// 아이템 등록
			else if ("add".equals(action)) {
				request.getRequestDispatcher("product/regist.jsp").forward(request, response);
			}

			// 아이템 상세
			else if ("detail".equals(action)) {
				int no = Integer.parseInt(request.getParameter("no"));
				service.updateClicked(no);
				request.setAttribute("item", service.getItem(no));
				request.getRequestDispatcher("product/detail.jsp").forward(request, response);
			}
			// 아이템 삭제
			else if ("delete".equals(action)) {
				int no = Integer.parseInt(request.getParameter("no"));
				service.removeItem(no);
				request.setAttribute("resultMsg", "삭제 완료");
				request.getRequestDispatcher("product/result.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("action");

		try {

			// 아이템 추가
			if ("add".equals(action)) {
				String name = request.getParameter("name");
				int price = Integer.parseInt(request.getParameter("price"));
				service.addItem(name, price);
				request.setAttribute("resultMsg", "아이템 추가 완료");
				request.getRequestDispatcher("product/result.jsp").forward(request, response);

			}
		} catch (Exception e) {

			if (e instanceof SQLIntegrityConstraintViolationException) {
				request.setAttribute("errorMsg", "중복 에러");
			} else {
				request.setAttribute("errorMsg", "모든 항목을 채워주세요");
			}

			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
