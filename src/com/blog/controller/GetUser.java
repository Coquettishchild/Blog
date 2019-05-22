package com.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.entity.Response;
import com.blog.entity.User;
import com.blog.util.SendJson;
/*
 * 获取用户信息
 */
@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetUser() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user = (User) request.getSession().getAttribute("user");
			Response re  =new Response();
			re.setFlag(true);
			re.setObj(user);
			SendJson.sendJson(response, re);
	}

}
