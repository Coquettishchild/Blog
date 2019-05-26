package com.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blog.entity.Response;
import com.blog.entity.User;
import com.blog.service.UserService;
import com.blog.util.GetUUID;
import com.blog.util.SendJson;
import com.blog.util.WritePhotos;
/*
 * 用户注册
 */

@WebServlet("/Reginster.action")
public class Reginster extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Reginster() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loadfilename=null;
		response.setContentType("text/html;charset=UTF-8");
		DiskFileItemFactory file = new DiskFileItemFactory();
		file.setSizeThreshold(1024*1024*3);
		String url=request.getRealPath("/photos");
		ServletFileUpload fileload = new ServletFileUpload(file);
		fileload.setHeaderEncoding("utf8");
		List<String> user = new ArrayList<String>();
		try {
			List<FileItem> list =fileload.parseRequest(request);
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()) {
					String value = fileItem.getString("utf8");
					user.add(value);
				}else {
					String filelast = fileItem.getName();
					System.out.println(filelast);
					int idex = filelast.lastIndexOf(".");
					filelast=filelast.substring(idex+1);
					loadfilename = GetUUID.getUUID();
					loadfilename+="."+filelast;
					WritePhotos.wirtephotos(fileItem, loadfilename, url);
				}
			}
			//判断用户名是否已经存在
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
			UserService service=(UserService) context.getBean("userservice");
			if(service.getUser(user.get(0))==null) {
				User newuser = new User();
				newuser.setUsername(user.get(0));
				newuser.setAge(Integer.parseInt(user.get(1)));
				newuser.setMajor(user.get(2));
				newuser.setEmail(user.get(3));
				newuser.setPassword(user.get(4));
				newuser.setInformation(user.get(6));
				newuser.setPhotos(loadfilename);
				if(user.get(4)!=null&&user.get(5)!=null&&user.get(4).equals(user.get(5))) {
					service.insertUser(newuser);
					request.getSession().setAttribute("user",newuser );
					response.sendRedirect("./index.html");
				}else {
					response.getWriter().print("<script>alert('两次输入的密码不同');window.location.href='./singup.html'</script>");
				}
			}else {
				response.getWriter().print("<script>alert('用户名已存在');window.location.href='./singup.html'</script>");
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
