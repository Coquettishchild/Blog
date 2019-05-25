package com.blog.controller;

import java.io.IOException;
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
import com.blog.util.GetThisTime;
import com.blog.util.JSONParase;
import com.blog.util.SendJson;

import net.sf.json.JSONObject;

/**
 * 添加文章
 */
@WebServlet("/AddPaper")
public class AddPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPaper() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String papername = request.getParameter("papername");
			String context = request.getParameter("context");
			String infor = request.getParameter("infor");
			response.setCharacterEncoding("utf8");
			response.setContentType("text/html;charset=utf-8");
			if(papername==null ||"".equals(papername)) {
				response.getWriter().print("<script>alert('文章名称不能为空');window.location.href='./uedit.html';</script>");
			}else {
				Article art =new Article();
				art.setName(papername);
				art.setContent(context);
				art.setInfor(infor);
				art.setCreatetime(GetThisTime.Gettime());
				art.setAuthor(((User)request.getSession().getAttribute("user")).getUsername());
				ApplicationContext applicationcontext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
				ArticleService service = (ArticleService) applicationcontext.getBean("articleservice");
				boolean b =service.insertpaper(art);
				if(b) {
					response.getWriter().print("<script>alert('提交成功');window.location.href='./index.html';</script>");
				}else {
					response.getWriter().print("<script>alert('提交失败');window.location.href='./uedit.html';</script>");
				}
			}
	}

}
