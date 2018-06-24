package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import cn.abc.bookstore.dao.BuybookDao;
import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.Buybook;
import cn.abc.bookstore.domain.User;
import cn.abc.bookstore.tools.Page;
public class PageBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public PageBuyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int pageSize=3;
		int pageNoBuy ;
		if (null==request.getParameter("pageNoBuy")) {
			pageNoBuy = 1;
		}
		else
		{
			pageNoBuy = Integer.parseInt(request.getParameter("pageNoBuy"));
		}
		
//		ArrayList<User> userList = new ArrayList<User>();
//		for(Buybook book:buyList)
//		{
//			userList.add(user);
//		}
//	   System.out.println("数据："+buyList.size());
	    List<Buybook> buyList =new BuybookDao().queryByUserLimit(user.getId(), pageNoBuy, pageSize);
		List<Buybook> buybooks = new BuybookDao().queryByUserId(user.getId());
		int totalBuy = 0;
		if (buybooks!=null&&buybooks.size()>0) {
			totalBuy = buybooks.size();
		}
		Page<Buybook> pageBuy = new Page<Buybook>(totalBuy, pageSize, pageNoBuy, buyList);
    	//System.out.println(pageBuy.toString());
//		ArrayList<Page> pageList = new ArrayList<Page>();
//		pageList.add(pageBuy);
//		JSONObject jo = new JSONObject();
		//jo.put("userList", userList);
//		jo.put("pageList", pageList);
//		String json = jo.toString();
    	String json = (new JSONObject(pageBuy)).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
