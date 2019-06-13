package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.ArticleDao;
import com.blog.entity.Article;
import com.blog.entity.Comments;

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
	public List<Article> getPaperList(String author, int index) {
		try {
			int begin, length = 3;
			begin = index * length - length;
			List<Article> list = service.getPapers(author, begin, length);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("获取文章列表失败");
			return null;
		}
	}

	/*
	 * 通过id获取文章名
	 */
	public Article getOnePaper(int id) {
		try {
			return service.getonepaper(id);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("通过id获取文章名失败");
			return null;
		}
	}

	/*
	 * 通过id修改文章
	 */
	public boolean updataArticle(Article art) {
		try {
			service.updataPaper(art);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("更新失败");
			return false;
		}
	}

	/*
	 * 通过id删除文章
	 */
	public boolean deleteArticle(long id) {
		try {
			service.deletePaper(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("删除文章失败");
			return false;
		}
	}

	/*
	 * 获取所有文章
	 */
	public List<Article> getall(int index) {
		int begin, length = 3;
		begin = index * length - length;
		try {
			List<Article> list = service.getall(begin, length);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 添加评论
	 */
	public boolean insertcomment(Comments comment) {
		try {
			service.insertCommnet(comment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 获取所有评论
	 */
	public List<Comments> getComment(int messid) {
		try {
			List<Comments> list = service.getComment(messid);
			return list;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
}
