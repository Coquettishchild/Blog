package com.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.Article;
import com.blog.entity.Comments;

public interface ArticleDao {
	//添加文章
	void insertPaper(Article art) throws Exception;
	//文章列表
	List<Article> getPapers(@Param("author")String author,@Param("begin") int begin ,@Param("length") int length)throws Exception;
	//获取单个文章
	Article getonepaper(int id)throws Exception;
	//修改文章
	void updataPaper(Article art)throws Exception;
	//删除文章
	void deletePaper(long id)throws Exception;
	
	//获取所有文章
	List<Article> getall(@Param("begin") int begin ,@Param("length") int length)throws Exception;
	
	//添加评论
	void insertCommnet(Comments comment)throws Exception;
	
	//获取所有评论
	List<Comments> getComment(int messid)throws Exception;
}
