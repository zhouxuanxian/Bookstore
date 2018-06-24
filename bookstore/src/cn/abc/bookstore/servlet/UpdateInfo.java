package cn.abc.bookstore.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

import cn.abc.bookstore.dao.UserDao;
import cn.abc.bookstore.domain.User;


public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateInfo() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try 
			{
	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("user"); 
			Map<String, String> map = new HashMap();
			DiskFileItemFactory dif = new DiskFileItemFactory();
	    	dif.setSizeThreshold(10*1024*1024);
			ServletFileUpload sUpload = new ServletFileUpload(dif);
			sUpload.setSizeMax(5*1024*1024);
			sUpload.setHeaderEncoding("utf-8");		
			List<FileItem> items = sUpload.parseRequest(request);
			if (items != null) {
				for(FileItem item: items)
				{
					if (item.isFormField()) {
						String key = item.getFieldName();
						String value = item.getString("utf-8");
						map.put(key, value);					
					}
					else
					{
						String savepath = this.getServletContext().getRealPath("//upload");
						System.out.println(savepath);						
						String filetype = item.getName().substring(item.getName().lastIndexOf(".") + 1).toLowerCase();						
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
						String filename = dateFormat.format((new Date()).getTime())+"."+filetype;					
						String filepath = savepath+File.separator+filename;
						map.put("picture", filename);
						item.write(new File(filepath));
						item.delete();						
					}
				}
			}

	        user.setName(map.get("name").toString());
	        user.setPassword(map.get("password").toString());
	        user.setPhone(map.get("phone").toString());
	        user.setContact(map.get("contact").toString());
	        user.setPicture(map.get("picture").toString());
	       
	        new UserDao().update(user);
	        session.removeAttribute("user");
	        User user2 = new UserDao().getUserFromBuyBook(user.getId()).get(0);
	      
	        session.setAttribute("user", user2);
	        request.getRequestDispatcher("userInfo.jsp").forward(request, response);
			} 
	        catch (Exception e) {
				e.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
