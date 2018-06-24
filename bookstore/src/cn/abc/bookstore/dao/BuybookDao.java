package cn.abc.bookstore.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.abc.bookstore.domain.Book;
import cn.abc.bookstore.domain.Buybook;
import cn.abc.bookstore.tools.JDBCUtils;
import cn.abc.bookstore.tools.Page;

public class BuybookDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * 图书需求添加
	 */
	public void addBook(Buybook buybook) {
		try {
			String sql = "INSERT INTO buybook(bookname,author,uid,picture) VALUES (?,?,?,?)";
			Object[] buybookData = {buybook.getBookname(),buybook.getAuthor(),buybook.getUid(),buybook.getPicture()};
			qr.update(sql,buybookData);
			//System.out.println(row);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("数据添加失败!!!");
		}
	}
	
	public  void deleteBook(Buybook buybook) {
	    try {
			String sql="delete from buybook where id=?";
			Object[] param = {buybook.getId()};
			int num = qr.update(sql,param);
			System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Buybook> getOnePageBuyBookInfo(int currentPage,int pageSize){
		List<Buybook> lists =null;
		try {
			currentPage=(currentPage-1)*pageSize;
			String sql = "select * from buybook limit ?,?";
			Object[] param = {
					currentPage,pageSize
			};
			lists = qr.query(sql, new BeanListHandler<>(Buybook.class), param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	public List<Buybook> queryByUserLimit(int uid,int currentPage,int pageSize){
		List<Buybook> lists =null;
		try {
			currentPage=(currentPage-1)*pageSize;
			String sql = "select * from buybook where uid=? limit ?,?";
			Object[] param = {
					uid,currentPage,pageSize
			};
			lists =qr.query(sql, new BeanListHandler<>(Buybook.class), param);
			//System.out.println(lists);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	public int getCount() {
		int count = -1;
		String sqlCount = "select count(1) from buybook";
		try {
			Long countLong = qr.query(sqlCount,new ScalarHandler<Long>());
			count = Integer.parseInt(String.valueOf(countLong)); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public Page<Buybook> getPage(int currentPage,int pageSize) {
		int count = this.getCount();
		List<Buybook> lists = this.getOnePageBuyBookInfo(currentPage, pageSize);
		return new Page<>(count, pageSize, currentPage, lists);
	}
	
	public List<Buybook> queryByUserId(int u_id){
		List<Buybook> lists = new ArrayList<>();
		try {
			String sql = "select * from buybook where uid=?";
			Object[] param = {u_id};
			lists =qr.query(sql, new BeanListHandler<>(Buybook.class),param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
}
