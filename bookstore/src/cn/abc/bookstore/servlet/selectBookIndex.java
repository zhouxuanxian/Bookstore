package cn.abc.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.domain.Book;
import cn.abc.bookstore.tools.Page;

/**
 * Servlet implementation class selectBookIndex
 */
public class selectBookIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public selectBookIndex() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao=new BookDao();
        int pageSize=8;
        String currentPage = request.getParameter("currentPage");
        if (currentPage==null) {
        	currentPage="1";
        }
        Page<Book> bookPage = bookDao.getPage(Integer.parseInt(currentPage), pageSize);
        HttpSession session=request.getSession();
        session.setAttribute("bookPage", bookPage);
        response.sendRedirect("index.jsp#sell-book");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
