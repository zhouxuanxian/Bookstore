package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.User;

public class findPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public findPasswordServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		System.out.println(username);
		UserDao userDao = new UserDao();
		List<User> users = userDao.getUserName(username);
		if (null!=users&&users.size()>0) {
			for (User user : users) {
			request.getSession().setAttribute("phone", user.getPhone());	
			request.getSession().setAttribute("username", user.getName());
			}
			request.getSession().setAttribute("passed2", "passed");
			response.sendRedirect("/bookstore/findPassword.jsp#second");
		} else {
			out.println("<script  type=\"text/javascript\">");
			out.println("alert(\"此账户不存在！！！\");");
			out.println("window.location.href='findPassword.jsp#first';");
			out.println("</script>");	
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
