package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.domain.Book;
import cn.abc.bookstore.tools.Page;

public class selectBookAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public selectBookAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookDao=new BookDao();
        int pageSize=10;
        String currentPage = request.getParameter("currentPage");
        if (currentPage==null) {
        	currentPage="1";
        }
        Page<Book> bookPage = bookDao.getPage(Integer.parseInt(currentPage), pageSize);
        request.getSession().setAttribute("bookPage", bookPage);
        response.sendRedirect("admin.jsp#one");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
