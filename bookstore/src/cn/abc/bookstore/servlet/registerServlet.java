package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.User;

public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public registerServlet() {
		super();

	}

	/*
	 * 
	 * 
	 * private Integer id; private String name; private String phone; private String
	 * password; private String contact;
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String contact = request.getParameter("QQ");
		System.out.println(name);
		if (name.equals("") || phone.equals("") || password.equals("") || contact.equals("")) {
			out.println("<script  type=\"text/javascript\">");
			out.println("alert(\"注册信息请先填写完整！！！\");");
			out.println("window.location.href='register.jsp';");
			out.println("</script>");
		} else {
			User user = new User();
			user.setContact(contact);
			user.setName(name);
			user.setPassword(password);
			user.setPhone(phone);
			UserDao userDao = new UserDao();
			userDao.addUser(user);
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
