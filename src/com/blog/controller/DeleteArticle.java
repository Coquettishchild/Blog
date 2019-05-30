package com.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.blog.entity.Response;
import com.blog.service.ArticleService;
import com.blog.util.GetClass;
import com.blog.util.SendJson;

/**
 * 删除文章
 */
@WebServlet("/DeleteArticle.action")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("id");
		long id = Long.parseLong(msg);
		ApplicationContext appcontext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ArticleService service = (ArticleService) appcontext.getBean("articleservice");
		boolean flag=service.deleteArticle(id);
		Response re = new Response();
		re.setFlag(flag);
		SendJson.sendJson(response, re);
	}

}
