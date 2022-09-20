package model;

import java.util.List;

public interface IBookDao { // Data Access Object = DAO
	int insert(Book book);
	int delete(int no);
	Book selectOne(int no);
	List<Book> selectAll();
}