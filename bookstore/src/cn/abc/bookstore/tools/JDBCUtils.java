package cn.abc.bookstore.tools;
import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
 
	private static BasicDataSource datasource = new BasicDataSource();
	static {
		   datasource.setDriverClassName("com.mysql.jdbc.Driver");
		   datasource.setUrl("jdbc:mysql://localhost:3306/bookstore");
		   datasource.setUsername("root");
		   datasource.setPassword("root");
		   datasource.setMaxActive(10);
		   datasource.setMaxIdle(5);  
		   datasource.setMinIdle(1);
		   datasource.setInitialSize(10);
	}
	public static BasicDataSource getDataSource() {
	 	return datasource;	
	}	
}
