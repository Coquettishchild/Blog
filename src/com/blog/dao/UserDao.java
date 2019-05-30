package com.blog.dao;

import com.blog.entity.Article;
import com.blog.entity.User;

public interface UserDao {
	//登录
	User getUser(String username) throws Exception;
	//注册
	void insertUser(User user) throws Exception;
	
}
