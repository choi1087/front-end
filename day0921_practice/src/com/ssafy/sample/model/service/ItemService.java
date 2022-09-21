package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Item;
import com.ssafy.sample.model.dao.ItemDao;

public class ItemService {
	private ItemService() {
	}

	private static ItemService service = new ItemService();

	public static ItemService getService() {
		return service;
	}

	private ItemDao dao = ItemDao.getInstance();

	public int addItem(String name, int price) throws SQLException {
		return dao.insert(name, price);
	}

	public List<Item> getItems() throws SQLException {
		return dao.selectAll();
	}

	public Item getItem(int no) throws SQLException {
		return dao.selectOne(no);
	}

	public int removeItem(int no) throws SQLException {
		return dao.delete(no);
	}

	public void updateClicked(int no) throws SQLException {
		dao.updateClicked(no);
	}
}
