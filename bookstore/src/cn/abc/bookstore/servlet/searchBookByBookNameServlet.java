package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.domain.Book;
import cn.abc.bookstore.domain.Buybook;
import cn.abc.bookstore.tools.Page;

public class searchBookByBookNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public searchBookByBookNameServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String bookname = request.getParameter("bookname");
	     String currentPage = request.getParameter("currentPage");
	     
	     if (null==currentPage||currentPage.length()<=0) {
	    	 currentPage="1";
	     }
	     System.out.println(currentPage);
	     int pageSize=5;
	     int count=0;
	     List<Book> books = new BookDao().queryByBookNameLimit(bookname, Integer.parseInt(currentPage), pageSize);
	     List<Book> booksLists= new BookDao().queryAllByBookName(bookname);
	     if (booksLists!=null) {
	    	 count = booksLists.size();
		}
	     Page<Book> pageBookByName = new Page<>(count, pageSize, Integer.parseInt(currentPage), books);
	     request.getSession().setAttribute("pageBookByName", pageBookByName);
	     response.sendRedirect("/bookstore/index.jsp#search-book");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
