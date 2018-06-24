package cn.abc.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.domain.Book;

public class deleteSellBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteSellBookServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     BookDao bDao=new BookDao();
	     Book book = new Book();
	     String id = request.getParameter("bookid");
	     if(id==null) {
	    	 response.sendRedirect("/bookstore/userInfo.jsp#sell");
	     }else {
		     book.setId(Integer.parseInt(id));
		     bDao.deleteBook(book);
		     response.sendRedirect("/bookstore/userInfo.jsp#sell");	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
