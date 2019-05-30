package com.blog.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.blog.service.ArticleService;
import com.blog.service.UserService;

public class GetClass {
	private static final ApplicationContext application= new ClassPathXmlApplicationContext("spring-mybatis.xml");
	private static final ArticleService artservice = (ArticleService) application.getBean("articleservice");
	private static final UserService userservice=(UserService) application.getBean("userservice");
	public GetClass() {
	}
	public static ApplicationContext getApplication() {
		return application;
	}
	public static UserService getUserService() {
		return userservice;
	}
	public static ArticleService getArticleService() {
		return artservice;
	}
}
