package cn.abc.bookstore.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;
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
import javax.websocket.Session;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.abc.bookstore.dao.BookDao;
import cn.abc.bookstore.domain.Book;

public class releaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public releaseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		PrintWriter out = response.getWriter();
		if ("null".equals(String.valueOf(uid))) {
			uid = 1;
		}
		Book book = new Book();
		book.setUid(uid);
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
						// System.out.println(name);
						// System.out.println(value);
						m1.put(name, value);
					} else {
						//获取上传的文件
						String path = super.getServletContext().getRealPath("//upload");
						System.out.println(path);
						String filename = item.getName();
						filename = filename.substring(filename.lastIndexOf("."));
						List<String> list = Arrays.asList(".bmp", ".jpg", ".png", ".jpeg", ".gif");
						System.out.println("123456");
						if (list.contains(filename)) {
							System.out.println("12345612345");
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
							filename = dateFormat.format(new Date()) + filename;
							path += File.separator + filename;
							// System.out.println(path);
							m1.put("fileName", filename);
							item.write(new File(path));
							String bookname = (String) m1.get("bookname");
							String number = (String) m1.get("number");
							String price = (String) m1.get("price");
							String author = (String) m1.get("author");
							String booktype = (String) m1.get("type");
							String publish = (String) m1.get("publish");
							String picture = (String) m1.get("fileName");
							book.setAuthor(author);
							book.setBookname(bookname);
							book.setBooktype(booktype);
							book.setPicture(picture);
							book.setPublish(publish);
							book.setNumber(Integer.parseInt(number));
							book.setPrice(Float.parseFloat(price));
						    BookDao bDao = new BookDao();
							bDao.addBook(book);
							out.println("<script  type=\"text/javascript\">");
							out.println("alert(\"success!!!\");");
							out.println("window.location.href='userInfo.jsp#release';");
							out.println("</script>");
						} else {
							System.out.println("123456111111");
							out.println("<script  type=\"text/javascript\">");
							out.println("alert(\"图片格式有误!!!\");");
							out.println("window.location.href='userInfo.jsp#release';");
							out.println("</script>");
							System.out.println("1234563333");
						}
					}
				}
		

			}
			System.out.println("12345622");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
