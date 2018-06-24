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

public class findPasswordFromPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public findPasswordFromPhoneServlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username=(String) request.getSession().getAttribute("username");
		String phone = request.getParameter("phone");
		User user = new User();
		user.setName(username);
		user.setPhone(phone);
		UserDao userDao = new UserDao();
		List<User> users =userDao.getUserFromNameAndPhone(user);
		if (null!=users&&users.size()>0) {
				request.getSession().setAttribute("passed3", "passed");
				request.getSession().setAttribute("userPhone",user.getPhone());
				response.sendRedirect("/bookstore/findPassword.jsp#third");
			
		} else {
			out.println("<script  type=\"text/javascript\">");
			out.println("alert(\"电话号码比对不正确！！！\");");
			out.println("window.location.href='findPassword.jsp#second';");
			out.println("</script>");	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
