package com.blog.fifter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/*
 * 编码拦截器
 */
@WebFilter(filterName = "/EncodingFifter",urlPatterns = "/")
public class EncodingFifter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		chain.doFilter(request, response);
	}


}
