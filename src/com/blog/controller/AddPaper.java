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
import com.blog.entity.User;
import com.blog.service.ArticleService;
import com.blog.util.GetClass;
import com.blog.util.GetThisTime;
import com.blog.util.JSONParase;
import com.blog.util.SendJson;

import net.sf.json.JSONObject;

/**
 * 添加文章
 */
@WebServlet("/AddPaper.action")
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
			Response re = new Response();
			response.setContentType("text/html;charset=utf-8");
			if(request.getSession().getAttribute("user")!=null&&papername==null ||"".equals(papername)) {
				re.setFlag(false);
				re.setMessage("文章名不能空");
			}else if(request.getSession().getAttribute("user")==null) {
				re.setFlag(false);
				re.setMessage("请先登录");
			}else {
				Article art =new Article();
				art.setName(papername);
				art.setContent(context);
				art.setInfor(infor);
				art.setCreatetime(GetThisTime.Gettime());
				art.setAuthor(((User)request.getSession().getAttribute("user")).getUsername());
				ApplicationContext appcontext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
				ArticleService service = (ArticleService) appcontext.getBean("articleservice");
				boolean b =service.insertpaper(art);
				if(b) {
					re.setFlag(true);
					re.setMessage("添加成功");
				}else {
					re.setFlag(true);
					re.setMessage("添加失败");
				}
			}
			SendJson.sendJson(response, re);
	}

}
