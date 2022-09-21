package com.ssafy.sample.dto;

public class Item {
	private int no;
	private String name;
	private int price;
	private int clicked;

	public Item() {
		super();
	}

	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Item(String name, int price, int clicked) {
		super();
		this.name = name;
		this.price = price;
		this.clicked = clicked;
	}
	
	

	public Item(int no, String name, int price, int clicked) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.clicked = clicked;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getClicked() {
		return clicked;
	}

	public void setClicked(int clicked) {
		this.clicked = clicked;
	}

	@Override
	public String toString() {
		return "ItemDto [no=" + no + ", name=" + name + ", price=" + price + ", clicked=" + clicked + "]";
	}

}
