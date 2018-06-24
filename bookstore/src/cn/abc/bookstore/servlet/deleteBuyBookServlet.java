package cn.abc.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.dao.BuybookDao;
import cn.abc.bookstore.domain.Book;
import cn.abc.bookstore.domain.Buybook;

/**
 * Servlet implementation class deleteBuyBookServlet
 */
public class deleteBuyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteBuyBookServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Buybook buybook = new Buybook();
		 BuybookDao buybookDao = new BuybookDao();
	     String id = request.getParameter("id");
	     if(id==null) {
	    	 response.sendRedirect("/bookstore/userInfo.jsp#buy");
	     }else {
	    	 buybook.setId(Integer.parseInt(id));
	    	 buybookDao.deleteBook(buybook);
		     response.sendRedirect("/bookstore/userInfo.jsp#buy");	
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
