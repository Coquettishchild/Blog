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
 * 更改文章
 */
@WebServlet("/UpdataPaper.action")
public class UpdataPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdataPaper() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String msg = request.getParameter("id");
			String name = request.getParameter("papername");
			String infor = request.getParameter("infor");
			String context = request.getParameter("context");
			Article art =  new Article();
			art.setId(Long.parseLong(msg));
			art.setContent(context);
			art.setInfor(infor);
			art.setName(name);
			ApplicationContext appcontext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ArticleService arts = (ArticleService) appcontext.getBean("articleservice");
			boolean  flag =arts.updataArticle(art);
			Response re = new Response();
			re.setFlag(flag);
			if(flag) {
				re.setMessage("修改成功");
			}else {
				re.setMessage("修改失败");
			}
			SendJson.sendJson(response, re);
	}

}
