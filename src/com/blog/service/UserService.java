package com.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.UserDao;
import com.blog.entity.User;

@Service("userservice")
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	/*
	 * 用户注册，插入用户
	 * 返回最新id
	 */
	public boolean insertUser(User user) {
		try {
			dao.insertUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("插入用户失败");
			return false;
		}
		
	}
	
	public User getUser(String username) {
		try {
			return dao.getUser(username);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("获取用户失败");
			return null;
		}
	}
}
