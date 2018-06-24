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

public class PageTypeIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PageTypeIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize=5;
		int pageNoType;
		if (null==request.getParameter("pageNoType")) {
			pageNoType = 1;
		}
		else
		{
			pageNoType = Integer.parseInt(request.getParameter("pageNoType"));
		}
		String type = request.getParameter("type");
		List<Book> sellList =new BookDao().queryByTypeLimit(type, pageNoType, pageSize);
		int totalSell = (new BookDao()).queryAllByType(type).size();
		Page<Book> pageType = new Page<Book>(totalSell, pageSize, pageNoType, sellList);
		String json = (new JSONObject(pageType)).toString();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
