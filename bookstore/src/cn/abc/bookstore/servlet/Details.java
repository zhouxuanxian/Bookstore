package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.Book;
import cn.abc.bookstore.domain.User;


public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		Book book = (new BookDao()).queryOneBook(bookid).get(0);
		session.setAttribute("sellBook", book);
		User user = new UserDao().getUserFromBuyBook(book.getUid()).get(0);
		session.setAttribute("seller", user);
		List<Book> sellLike = new BookDao().queryByTypeLimit(book.getBooktype(),1,4);
		session.setAttribute("sellLike", sellLike);
		//response.sendRedirect("details.jsp");
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
