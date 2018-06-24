package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.User;


public class userLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public userLoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    User user =new User();
	    user.setName(username);
	    user.setPassword(password);
		UserDao userDao = new UserDao();
		List<User> userList= userDao.getLogin(user);
		if (userList!=null&&userList.size()>0) {
			for (User u : userList) {
				session.setAttribute("user", u);
			}
			response.sendRedirect("index.jsp");
		}
		else {
			out.println("<script  type=\"text/javascript\">");
			out.println("alert(\"用户名或密码错误请重新登录！！\");");
			out.println("window.location.href='login.jsp';");
			out.println("</script>");	
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
