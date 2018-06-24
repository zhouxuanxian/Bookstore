package cn.abc.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.abc.bookstore.dao.BuybookDao;
import cn.abc.bookstore.domain.Buybook;
import cn.abc.bookstore.tools.Page;


public class selectBuyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public selectBuyBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuybookDao buydao = new BuybookDao();
        int pageSize = 8;
        String currentPage = request.getParameter("buyCurrentPage");
        if (currentPage==null) {
        	currentPage="1";
        }
        Page<Buybook> buyBookPage = buydao.getPage(Integer.parseInt(currentPage), pageSize);
        request.getSession().setAttribute("buyBookPage", buyBookPage);
        response.sendRedirect("index.jsp#buy-book");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
