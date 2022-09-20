package model;

import java.util.List;

public class BookService {
	private BookDao bookDao = new BookDao();

	public boolean insert(Book book) {
		if (bookDao.insert(book) == 1) {
			return true;
		}
		return false;
	}

	public boolean delete(int no) {
		if (bookDao.delete(no) == 1) {
			return true;
		}
		return false;
	}

	public Book selectOne(int no) {
		return bookDao.selectOne(no);
	}

	public List<Book> selectAll() {
		return bookDao.selectAll();
	}

}
