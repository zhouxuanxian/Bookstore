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
import cn.abc.bookstore.tools.Page;

public class PageSellIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PageSellIndex() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int pageSize=5;
		int pageNoSell;
		if (null==request.getParameter("pageNoSell")) {
			pageNoSell = 1;	
		}
		else
		{
			pageNoSell = Integer.parseInt(request.getParameter("pageNoSell"));
		}
		List<Book> sellList =new BookDao().getOnePageInfo(pageNoSell, pageSize);
		int totalSell = (new BookDao()).getCount() ;
		Page<Book> pageSell = new Page<Book>(totalSell, pageSize, pageNoSell, sellList);
		String json = (new JSONObject(pageSell)).toString();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
