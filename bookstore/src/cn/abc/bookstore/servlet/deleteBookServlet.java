package cn.abc.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.domain.Book;

public class deleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     BookDao bDao=new BookDao();
	     Book book = new Book();
	     String id = request.getParameter("id");
	     if(id==null) {
	    	 response.sendRedirect("admin.jsp#one");
	     }else {
		     book.setId(Integer.parseInt(id));
		     bDao.deleteBook(book);
		     response.sendRedirect("selectBookAllServlet?currentPage=1");	
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
