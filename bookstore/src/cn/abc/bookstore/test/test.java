package cn.abc.bookstore.test;

import java.util.List;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.domain.Book;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Book> sellList =(new BookDao()).queryByTypeLimit("π§ø∆¿‡", 1, 5);
		  
		//System.out.println(sellList);
 
	}

}
