package cn.abc.bookstore.domain;

public class User {
	private Integer id;
	private String name;
	private String phone;
	private String password;
	private String contact;
	private String picture;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer id, String name, String phone, String password, String contact, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.contact = contact;
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", password=" + password + ", contact="
				+ contact + ", picture=" + picture + "]";
	}

	

	
	
}
