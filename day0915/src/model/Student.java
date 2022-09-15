package model;

public class Student {
	private int no;
	private String name;
	private int age;
	private String address;

	public Student() {
		super();
	}

	public Student(int no, String name, int age, String address) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

}