package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDTO;
import model.BoardService;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private BoardService service = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		if (action.equals("list")) { // 寃뚯떆�뙋 紐⑸줉蹂닿린 �슂泥��씠 �뱾�뼱�샂
			String pageStr = req.getParameter("page"); // �럹�씠吏� �뙆�씪誘명꽣 �솗�씤
			int page = 1; // 湲곕낯 1�럹�씠吏�
			if (pageStr != null && pageStr.length() > 0) { // �럹�씠吏� �슂泥� -> �빐�떦 �럹�씠吏�
				page = Integer.parseInt(pageStr);
			}
			req.setAttribute("boardPage", service.makePage(page));
			req.getRequestDispatcher("BoardList.jsp").forward(req, resp);
		} else if (action.equals("write")) {
			// 나중에 회원게시판은 여기서 로그인 체크같은거 해야됨
			req.getRequestDispatcher("BoardWrite.jsp").forward(req, resp);
		} else if (action.equals("update")) {
			int bno = Integer.parseInt(req.getParameter("bno"));
			String pageStr = req.getParameter("page");
			service.updateClick(bno);
			req.getRequestDispatcher("board?action=list&page=" + pageStr).forward(req, resp);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		if (action.equals("write")) {
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");

			BoardDTO board = new BoardDTO(title, writer, content);
			if (service.write(board)) {
				req.getRequestDispatcher("BoardWriteSuccess.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("BoardWriteError.jsp").forward(req, resp);
			}
		}
	}
}
