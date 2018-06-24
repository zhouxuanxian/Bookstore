package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import cn.abc.bookstore.dao.BuybookDao;
import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.Buybook;
import cn.abc.bookstore.domain.User;
import cn.abc.bookstore.tools.Page;

public class PageBuyIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PageBuyIndex() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize=5;
		int pageNoBuy ;
		if (null==request.getParameter("pageNoBuy")) {
			pageNoBuy = 1;
		}
		else
		{
			pageNoBuy = Integer.parseInt(request.getParameter("pageNoBuy"));
		}
		List<Buybook> buyList =new BuybookDao().getOnePageBuyBookInfo(pageNoBuy,pageSize);
		List<User> userLists = new ArrayList<User>();
		for(Buybook book:buyList)
		{
			List<User> userList = new UserDao().getUserFromBuyBook(book.getUid());
			for(User user:userList) {
				userLists.add(user);
			}
		}
		int totalBuy = (new BuybookDao()).getCount();
		Page<Buybook> pageBuy = new Page<Buybook>(totalBuy, pageSize, pageNoBuy, buyList);
		ArrayList<Page> pageList = new ArrayList<Page>();
		pageList.add(pageBuy);
		JSONObject jo = new JSONObject();
		jo.put("userList", userLists);
		jo.put("pageList", pageList);
		String json = jo.toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
