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

import com.blog.entity.Comments;
import com.blog.entity.Response;
import com.blog.service.ArticleService;
import com.blog.util.SendJson;

/**
 * Servlet implementation class GetComment
 */
@WebServlet("/GetComment.action")
public class GetComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String temp = request.getParameter("id");
		int messid = Integer.parseInt(temp);
		ApplicationContext appcontext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ArticleService service = (ArticleService) appcontext.getBean("articleservice");
		List<Comments> list = service.getComment(messid);
		Response re = new Response();
		re.setObj(list);
		SendJson.sendJson(response, re);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
