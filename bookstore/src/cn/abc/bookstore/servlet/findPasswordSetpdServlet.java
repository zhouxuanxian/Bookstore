package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.User;

public class findPasswordSetpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public findPasswordSetpdServlet() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userPhone =(String) request.getSession().getAttribute("userPhone");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if (password.equals(repassword)) {
			User user = new User();
			user.setPassword(password);
			user.setPhone(userPhone);
			UserDao userDao = new UserDao();
			userDao.updatePassword(user);
			request.getSession().setAttribute("passed4", "passed");
			response.sendRedirect("/bookstore/findPassword.jsp#last");
		} else {
			out.println("<script  type=\"text/javascript\">");
			out.println("alert(\"两次输入密码不一样！！！\");");
			out.println("window.location.href='findPassword.jsp#third';");
			out.println("</script>");

		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
