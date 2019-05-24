package com.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.Article;

public interface ArticleDao {
	public void insertPaper(Article art) throws Exception;
	public List<Article> getPapers(@Param("author")String author,@Param("begin") int begin ,@Param("length") int length)throws Exception;
}
