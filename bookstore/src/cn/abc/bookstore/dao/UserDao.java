package cn.abc.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import cn.abc.bookstore.domain.User;
import cn.abc.bookstore.tools.JDBCUtils;
import cn.abc.bookstore.tools.Page;

public class UserDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * ÃÌº””√ªß
	 */
	public void addUser(User user) {
		try {
			String sql="INSERT INTO `user`(`name`,`password`,phone,contact) VALUES(?,?,?,?)";
			Object[] param= {
					user.getName(),user.getPassword(),user.getPhone(),user.getContact()
			};
			qr.update(sql,param);
			//System.out.println(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<User> getOnePageInfo(int currentPage,int pageSize){
		List<User> lists =null;
		try {
			currentPage=(currentPage-1)*pageSize;
			String selectSql = "SELECT  * FROM user LIMIT "+currentPage+","+pageSize+"";
			//System.out.println(selectSql);
			lists = qr.query(selectSql, new BeanListHandler<>(User.class));
			//System.out.println(lists);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	public int getCount() {
		int count=-1;
		try {
			String countSql = "SELECT COUNT(1) FROM user";
			long countLong =qr.query(countSql, new ScalarHandler<Long>());
			count = Integer.parseInt(String.valueOf(countLong));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public Page<User> getPage(int currentPage,int pageSize){
		int count = this.getCount();
		List<User> lists = this.getOnePageInfo(currentPage, pageSize);
		return new Page<>(count, pageSize, currentPage, lists);
	}
	
	public List<User> getLogin(User user) {
		List<User> userList = null;
		try {
			String sql="SELECT * FROM USER WHERE NAME=? AND PASSWORD=?";
			Object[] param = {user.getName(),user.getPassword()};
			userList = qr.query(sql, new BeanListHandler<>(User.class),param);
//			System.out.println(userList); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	public List<User> getUserName(String name) {
		List<User> userList = null;
		try {
			String sql="SELECT * FROM USER WHERE NAME=?";
			Object[] param = {name};
			userList = qr.query(sql, new BeanListHandler<>(User.class),param);
//			System.out.println(userList); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	public List<User> getUserFromNameAndPhone(User user) {
		List<User> userList = null;
		try {
			String sql="SELECT * FROM USER WHERE NAME=? AND PHONE=?";
			Object[] param = {user.getName(),user.getPhone()};
			userList = qr.query(sql, new BeanListHandler<>(User.class),param);
//			System.out.println(userList); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	public List<User> getUserFromBuyBook(int id){
		List<User> userLists = null;
		try {
			String sql="SELECT * FROM USER WHERE id=?";
			Object[] param = {id};
			userLists = qr.query(sql, new BeanListHandler<>(User.class),param);
     		//System.out.println(userLists); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userLists;
	}
	public void update(User user) {
		
		try {
			String sql = 
					"update user set name=? , password=?, phone=?,contact=?,picture=?"
					+ "where id=?";
			Object[] param = {user.getName(),user.getPassword(),user.getPhone(),user.getContact(),user.getPicture(),user.getId()};
			qr.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void updatePassword(User user) {
		try {
       String sql = "update user set password=?"+"where phone=?";
			Object[] param = {user.getPassword(),user.getPhone()};
			qr.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
