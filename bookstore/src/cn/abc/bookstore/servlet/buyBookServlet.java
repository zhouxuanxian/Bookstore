package cn.abc.bookstore.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.abc.bookstore.dao.BuybookDao;
import cn.abc.bookstore.domain.Buybook;


public class buyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public buyBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("uid");
		if (uid == null) {
			uid = "1";
		}
		PrintWriter out = response.getWriter();
		Buybook buybook =new Buybook();
		buybook.setUid(Integer.parseInt(uid));
		System.out.println(buybook.getUid());
		DiskFileItemFactory dif = new DiskFileItemFactory();
		dif.setSizeThreshold(10 * 1024 * 1024);
		try {
			ServletFileUpload sUpload = new ServletFileUpload(dif);
			sUpload.setSizeMax(5 * 1024 * 1024);
			sUpload.setHeaderEncoding("utf-8");
			List<FileItem> items = sUpload.parseRequest(request);
			Map m1 = new HashMap();
			if (items != null) {
				for (FileItem item : items) {
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = item.getString("utf-8");
						m1.put(name, value);
					} else {
						String path = super.getServletContext().getRealPath("//upload");
						//System.out.println(path);
						String filename = item.getName();
						filename = filename.substring(filename.lastIndexOf("."));
						List<String> list = Arrays.asList(".bmp", ".jpg", ".png", ".jpeg", ".gif");
						if (list.contains(filename)) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
							filename = dateFormat.format(new Date()) + filename;
							path += File.separator + filename;
							// System.out.println(path);
							m1.put("fileName", filename);
							item.write(new File(path));
							String bookname = (String) m1.get("bookname");
							String author = (String) m1.get("author");
			        		String picture = (String) m1.get("fileName");
			        		String description = (String)m1.get("description");
							buybook.setAuthor(author);
							buybook.setBookname(bookname);
							buybook.setPicture(picture);
					
			                BuybookDao buybookDao = new BuybookDao();
			                buybookDao.addBook(buybook);
							out.println("<script  type=\"text/javascript\">");
							out.println("alert(\"发布成功\");");
							out.println("window.location.href='userInfo.jsp#buybook';");
							out.println("</script>");
						} else {
							out.println("<script  type=\"text/javascript\">");
							out.println("alert(\"只能是(.bmp|.jpg|.png|.jpeg|.gif)\");");
							out.println("window.location.href='userInfo.jsp#buybook';");
							out.println("</script>");
						}
					}
				}			
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
