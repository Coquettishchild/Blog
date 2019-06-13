package com.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.blog.entity.Article;
import com.blog.entity.Response;
import com.blog.service.ArticleService;
import com.blog.util.SendJson;

/**
 * Servlet implementation class GetAllPapers
 */
@WebServlet("/GetAllPapers.action")
public class GetAllPapers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = request.getParameter("index");
		int index = Integer.parseInt(temp);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ArticleService art = (ArticleService) context.getBean("articleservice");
		Response re =new Response();
		List<Article> list =art.getall(index);
		re.setFlag(true);
		re.setObj(list);
		SendJson.sendJson(response, re);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
