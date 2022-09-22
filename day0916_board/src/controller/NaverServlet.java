package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/naverShopping")
public class NaverServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		System.out.println("검색어 들어옴 : " + keyword);
		String responseBody = HttpUtil.execute(keyword); // 검색 키워드 넣어서 네이버와 통신 결과 받아오기.
		resp.setContentType("text/json;charset=UTF-8");
		resp.getWriter().write(responseBody);
	}
}
