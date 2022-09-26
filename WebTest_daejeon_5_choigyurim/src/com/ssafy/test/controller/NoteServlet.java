package com.ssafy.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.test.dto.NoteDto;
import com.ssafy.test.model.service.NoteServiceImpl;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoteServiceImpl service = NoteServiceImpl.getService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if ("list".equals(action)) {
			List<NoteDto> list = service.getNotes();
			request.setAttribute("notes", list);
			request.getRequestDispatcher("/note/listNote.jsp").forward(request, response);
			;
		} else if ("detail".equals(action)) {
			String noteCode = request.getParameter("noteCode");
			NoteDto noteDto = service.getNote(noteCode);
			request.setAttribute("noteDto", noteDto);
			request.getRequestDispatcher("/note/detailNote.jsp").forward(request, response);
		} else if ("delete".equals(action)) {
			String noteCode = request.getParameter("noteCode");
			service.remove(noteCode);
			request.setAttribute("msg", "책 정보 삭제 성공");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("action");

		if ("regist".equals(action)) {
			String code = request.getParameter("noteCode");
			String model = request.getParameter("model");
			String price = request.getParameter("price");
			String company = request.getParameter("company");

			if (code.equals("") || model.equals("") || price.equals("") || company.equals("")) {
				request.setAttribute("msg", "모두 입력해주세요.");
				request.getRequestDispatcher("/note/registNote.jsp").forward(request, response);
			} else {

				System.out.println("regist servlet");
				NoteDto noteDto = new NoteDto(code, model, Integer.parseInt(price), company);
				if (service.insert(noteDto)) {
					request.setAttribute("msg", "노트북 정보 등록 완료");
					request.getRequestDispatcher("/note/registNote.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "중복된 코드 값입니다.");
					request.getRequestDispatcher("/note/registNote.jsp").forward(request, response);
				}
			}

		}
	}

}
