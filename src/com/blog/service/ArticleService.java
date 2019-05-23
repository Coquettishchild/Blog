package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.ArticleDao;
import com.blog.entity.Article;

@Service("articleservice")
public class ArticleService {
	@Autowired
	private ArticleDao service;
	
	public boolean insertpaper(Article art) {
		try {
			service.insertPaper(art);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("插入文章失败");
			return false;
		}
	}
}
