package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.ArticleDao;
import com.blog.entity.Article;

@Service("articleservice")
public class ArticleService {
	@Autowired
	private ArticleDao service;
	
	/*
	 * 添加文章
	 */
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
	
	/*
	 * 获取文章列表
	 */
	public List<Article> getPaperList(String author,int index){
		try {
			int begin,length=3;
			begin=index*length-length;
			List<Article>list =service.getPapers(author,begin,length);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
