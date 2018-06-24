package cn.abc.bookstore.domain;

public class Buybook {
	private Integer id;
	private String bookname;
	private String author;
	private Integer uid;

	private String picture;
	
	public Buybook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buybook(Integer id, String bookname, String author, Integer uid, String picture) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.uid = uid;
		
		this.picture = picture;
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Buybook [id=" + id + ", bookname=" + bookname + ", author=" + author + ", uid=" + uid + ", picture=" + picture + "]";
	}
	

    
}
