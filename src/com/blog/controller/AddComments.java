package com.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.blog.entity.Comments;
import com.blog.entity.Response;
import com.blog.entity.User;
import com.blog.service.ArticleService;
import com.blog.util.SendJson;

/**
 * Servlet implementation class AddComments
 */
@WebServlet("/AddComments.action")
public class AddComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temp = request.getParameter("messid");
		String commnet = request.getParameter("comment");
		int messid = Integer.parseInt(temp);
		ApplicationContext appcontext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ArticleService service = (ArticleService) appcontext.getBean("articleservice");
		String name = ((User)request.getSession().getAttribute("user")).getUsername();
		Comments comment = new Comments();
		comment.setMessage(commnet);
		comment.setMessid(messid);
		comment.setName(name);
		boolean flag=service.insertcomment(comment);
		Response re =new Response();
		re.setFlag(flag);
		if(flag) {
			re.setMessage("评论成功");
		}else {
			re.setMessage("评论失败");
		}
		SendJson.sendJson(response, re);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
