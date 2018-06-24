package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.abc.bookstore.dao.AdminDao;
import cn.abc.bookstore.domain.Admin;

/**
 * Servlet implementation class adminLoginServlet
 */
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
	    String username = request.getParameter("admin_name");
	    String password = request.getParameter("admin_password");
		Admin admin =new Admin();
		admin.setAdmin_name(username);
		admin.setAdmin_password(password);
        AdminDao adminDao = new AdminDao();
        List<Admin> adminList = adminDao.getAdminLogin(admin);
        if (adminList!=null&&adminList.size()>0) {
        	response.sendRedirect("admin.jsp#one");
        	for (Admin admin2 : adminList) {
        		session.setAttribute("admin_name", admin2.getAdmin_name());
			}
		} else {
			out.println("<script  type=\"text/javascript\">");
			out.println("alert(\"用户名或密码错误请重新登录！！\");");
			out.println("window.location.href='admin/login.jsp';");
			out.println("</script>");	
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
