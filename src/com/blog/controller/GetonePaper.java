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

import com.blog.entity.Article;
import com.blog.entity.Response;
import com.blog.service.ArticleService;
import com.blog.util.GetClass;
import com.blog.util.SendJson;

/**
 * 获取一个文章的详情
 */
@WebServlet("/GetonePaper.action")
public class GetonePaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetonePaper() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str =request.getParameter("id");
		int id =Integer.parseInt(str);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ArticleService art = (ArticleService) context.getBean("articleservice");
		System.out.println(art);
		Article article =art.getOnePaper(id);
		Response re =new Response();
		re.setFlag(true);
		re.setObj(article);
		SendJson.sendJson(response, re);
	}

}
