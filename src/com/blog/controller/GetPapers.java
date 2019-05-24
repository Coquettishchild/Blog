package com.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blog.entity.Article;
import com.blog.entity.Response;
import com.blog.entity.User;
import com.blog.service.ArticleService;
import com.blog.util.SendJson;

/**
 *获取用户的博客列表
 */
@WebServlet("/GetPapers")
public class GetPapers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPapers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = request.getParameter("index");
		int index = Integer.parseInt(temp);
		String author=((User)request.getSession().getAttribute("user")).getUsername();
		ApplicationContext contxt = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ArticleService art = (ArticleService) contxt.getBean("articleservice");
		Response re =new Response();
		if(author!=null) {
			List<Article> list =art.getPaperList(author,index);
			re.setFlag(true);
			re.setObj(list);
		}else {
			re.setFlag(false);
			re.setMessage("获取失败");
		}
		SendJson.sendJson(response, re);
	}

}
