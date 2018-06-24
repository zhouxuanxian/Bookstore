package cn.abc.bookstore.domain;

public class Book {
	private Integer id;
	private String bookname;
	private String author;
	private float price;
	private Integer number;
	private String booktype;
	private String publish;
	private int uid;
	private String picture;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
	public Book(Integer id, String bookname, String author, float price, Integer number, String booktype,
			String publish, int uid, String picture) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.number = number;
		this.booktype = booktype;
		this.publish = publish;
		this.uid = uid;
		this.picture = picture;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", author=" + author + ", price=" + price + ", number="
				+ number + ", booktype=" + booktype + ", publish=" + publish + ", uid=" + uid + "]";
	}
	
	
	
}
