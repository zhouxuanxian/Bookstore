package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.domain.Book;
import cn.abc.bookstore.domain.User;
import cn.abc.bookstore.tools.Page;

public class PageSellSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PageSellSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        User user =  (User) request.getSession().getAttribute("user");
				int pageSize=3;
				int pageNoSell;
				if (request.getParameter("pageNoSell") == null) {
					pageNoSell = 1;
					
				}
				else
				{
					pageNoSell = Integer.parseInt(request.getParameter("pageNoSell"));
				}

				List<Book> sellList = new BookDao().queryByUserLimit(user.getId(), pageNoSell, pageSize);
				int totalSell = 0;
				
				List<Book> books=  (new BookDao()).queryByUserId(user.getId());
				if (books!=null&&books.size()>0) {
					totalSell = books.size();
				}
				Page<Book> pageSell = new Page<Book>(totalSell, pageSize, pageNoSell, sellList);			
				String json = (new JSONObject(pageSell)).toString();
				System.out.println(json);
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.write(json);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
