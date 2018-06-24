package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.User;

public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public addUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String contact = request.getParameter("contact");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		user.setContact(contact);
		UserDao uDao = new UserDao();
		uDao.addUser(user);
		response.sendRedirect("admin.jsp#three");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
