package com.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blog.entity.Response;
import com.blog.entity.User;
import com.blog.service.UserService;
import com.blog.util.JSONParase;
import com.blog.util.SendJson;

import net.sf.json.JSONObject;

/**
 *用户登录
 */
@WebServlet("/Login.action")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
			UserService service=(UserService) context.getBean("userservice");
			JSONObject json = JSONParase.paraseJson(request, response);
			String username=json.getString("username");
			String password=json.getString("password");
			User user =service.getUser(username);
			Response re = new Response();
			if(user!=null && password!=null&&password.equals(user.getPassword())) {
				re.setFlag(true);
				re.setMessage("登录成功");
				request.getSession().setAttribute("user", user);
			}else if(user==null){
				re.setFlag(false);
				re.setMessage("用户名不存在");
			}else if(password!=null &&!password.equals(user.getPassword())) {
				re.setFlag(false);
				re.setMessage("密码错误");
			}else {
				re.setFlag(false);
				re.setMessage("登录失败");
			}
			SendJson.sendJson(response, re);
		} catch (Exception e) {
			System.err.println("解析json出错");
			e.printStackTrace();
		}
	}

}
