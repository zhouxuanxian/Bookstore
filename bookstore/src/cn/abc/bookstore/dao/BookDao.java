package cn.abc.bookstore.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import cn.abc.bookstore.domain.Book;
import cn.abc.bookstore.tools.JDBCUtils;
import cn.abc.bookstore.tools.Page;

public class BookDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * 图书添加
	 */
	public void addBook(Book book) {
		try {
			String sql = "INSERT INTO book(bookname,author,price,booktype,publish,number,uid,picture) VALUES (?,?,?,?,?,?,?,?)";
			Object[] bookData = {
					book.getBookname(),book.getAuthor(),book.getPrice(),book.getBooktype(),book.getPublish(),book.getNumber(),book.getUid(),book.getPicture()
			};
			qr.update(sql,bookData);
			//System.out.println(row);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("数据添加失败!!!");
		}
	}
	/*
	 * 查询一页的图书信息
	 * SELECT  * FROM book LIMIT 3,3
	 */
	
	public List<Book> getOnePageInfo(int currentPage,int pageSize){
		List<Book> lists =null;
		try {
			currentPage=(currentPage-1)*pageSize;
			String selectSql = " SELECT  * FROM book LIMIT "+currentPage+","+pageSize+"";
			//System.out.println(selectSql);
			lists = qr.query(selectSql, new BeanListHandler<>(Book.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	/*
	 * 图书的总条数
	 */
	public int getCount() {
		int count=-1;
		try {
			String countSql = "SELECT COUNT(1) FROM book";
			long countLong =qr.query(countSql, new ScalarHandler<Long>());
			count = Integer.parseInt(String.valueOf(countLong));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Page<Book> getPage(int currentPage,int pageSize){
		int count = this.getCount();
		List<Book> lists = this.getOnePageInfo(currentPage, pageSize);
		return new Page<>(count, pageSize, currentPage, lists);
	}

     /*
      * 删除图书的条目
      * 
      */
	public  void deleteBook(Book book) {
	    try {
			String sql="delete from book where id=?";
			Object[] param = {book.getId()};
			 qr.update(sql,param);
			//System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Book> queryOneBook(int bookid) {
		List<Book> books  = null;
	    try {
			String sql="select * from book where id=?";
			Object[] param = {bookid};
			books =qr.query(sql, new BeanListHandler<>(Book.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return books;
	}
	public List<Book> queryByUserId(int u_id)
	{
		
		List<Book> al = null;

		try {
			String sql = "select * from book where uid=?";
			Object[] param = {u_id};
			al =qr.query(sql, new BeanListHandler<>(Book.class),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   	    return al;
	}
	
	public List<Book> queryByUserLimit(int uid,int currentPage,int pageSize){
		List<Book> lists = null;
		try {
			currentPage=(currentPage-1)*pageSize;
			String selectSql = "select * from (select * from book where uid=?) as a limit ?,?";
			Object[] param = {uid,currentPage,pageSize};
			lists = qr.query(selectSql, new BeanListHandler<>(Book.class),param);
			//System.out.println(lists);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	public List<Book> queryByTypeLimit(String type,int currentPage,int pageSize){
		List<Book> lists = null;
		try {
			currentPage=(currentPage-1)*pageSize;
			String selectSql = "select * from (select * from book where booktype=?) as a limit ?,?";
			Object[] param = {type,currentPage,pageSize};
			lists = qr.query(selectSql, new BeanListHandler<>(Book.class),param);
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return lists;
	}
	public List<Book> queryAllByType(String type)
	{
		List<Book> al = null;
		try {
			String sql = "select * from book where booktype=?";
			Object[] param = {type};
			al = qr.query(sql, new BeanListHandler<>(Book.class),param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	public List<Book> queryByBookNameLimit(String bookname,int currentPage,int pageSize){
		List<Book> lists = null;
		try {
			bookname=bookname+"%";
			currentPage=(currentPage-1)*pageSize;
			String selectSql = "select * from (select * from book where bookname like ?) as a limit ?,?";
			Object[] param = {bookname,currentPage,pageSize};
			lists = qr.query(selectSql, new BeanListHandler<>(Book.class),param);
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return lists;
	}
	public List<Book> queryAllByBookName(String bookname)
	{
		List<Book> al = null;
		bookname = bookname+"%";
		try {
			String sql = "select * from book where bookname like ?";
			Object[] param = {bookname};
			al = qr.query(sql, new BeanListHandler<>(Book.class),param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}   
