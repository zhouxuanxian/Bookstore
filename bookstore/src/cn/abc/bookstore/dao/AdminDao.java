package cn.abc.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.abc.bookstore.domain.Admin;
import cn.abc.bookstore.tools.JDBCUtils;

public class AdminDao {
	
	QueryRunner qRunner= new QueryRunner(JDBCUtils.getDataSource());
	public List<Admin> getAdminLogin(Admin admin) {
		List<Admin> adminList=null;
		try {
			String sql="select * from admin where admin_name=? and admin_password=?";
			Object[] param = {admin.getAdmin_name(),admin.getAdmin_password()};
			adminList = qRunner.query(sql,new BeanListHandler<>(Admin.class),param);
			//System.out.println(adminList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminList;
	}

}
