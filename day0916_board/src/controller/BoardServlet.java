package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDTO;
import model.BoardDao;
import model.BoardService;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private BoardService service = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		if (action.equals("list")) {
			String pageStr = req.getParameter("page");
			int page = 1;
			if (pageStr != null && pageStr.length() > 0) {
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
			req.setAttribute("board", new BoardDao().selectOne(bno));
			req.getRequestDispatcher("BoardContent.jsp").forward(req, resp);
		} else if (action.equals("delete")) {			
			int bno = Integer.parseInt(req.getParameter("bno"));
			service.delete(bno);			
			req.getRequestDispatcher("BoardDelete.jsp").forward(req, resp);
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
