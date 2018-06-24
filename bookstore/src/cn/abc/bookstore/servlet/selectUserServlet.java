package cn.abc.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.User;
import cn.abc.bookstore.tools.Page;


public class selectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public selectUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    int pageSize=10;
	        String currentPage = request.getParameter("currentPage1");
	        if (currentPage==null) {
	        	currentPage="1";
	        }
	        UserDao uDao = new UserDao();
	        //List<User> users = uDao.getOnePageInfo(Integer.parseInt(currentPage), pageSize);
	        Page<User> userPage = uDao.getPage(Integer.parseInt(currentPage), pageSize);
	        HttpSession session=request.getSession();
	        session.setAttribute("userPage", userPage);
	        response.sendRedirect("admin.jsp#three");
	        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
