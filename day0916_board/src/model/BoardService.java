package model;

import java.util.HashMap;
import java.util.Map;


public class BoardService {
	private static final int COUNT_PER_PAGE = 5;
	private BoardDao dao = new BoardDao();

	public Map<String, Object> makePage(int page) {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("currPage", page);

		int totalCount = dao.selectTotalCount();
		int totalPage = totalCount / COUNT_PER_PAGE;
		if (totalCount % COUNT_PER_PAGE > 0) {
			totalPage++;
		}

		int startPage = (page - 1) / 10 * 10 + 1; 
		int endPage = startPage + 9; 

		if (endPage > totalPage) { 
			endPage = totalPage;
		}

		pageMap.put("totalPage", totalPage);
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);

		int startRow = (page - 1) * COUNT_PER_PAGE;
		pageMap.put("boardList", dao.selectList(startRow, COUNT_PER_PAGE));
		return pageMap;
	}

	public void updateClick(int bno) {
		dao.updateReadCount(bno);
	}
	
	public void delete(int bno) {
		dao.delete(bno);
	}

	public boolean write(BoardDTO board) {
		if (dao.insert(board) == 1) {
			return true;
		}
		return false;
	}
}
