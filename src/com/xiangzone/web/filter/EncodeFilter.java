package com.xiangzone.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {

	private String code;//utf-8   从web.xml中filter配置文件获取
	
	/**
	 * 销毁的方法，只会执行一次
	 */
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.code);//设置编码方式
		chain.doFilter(request, response);//通过请求，放送请求至下一个过滤器或者Servlet/JSP
		response.setCharacterEncoding(this.code);
	}

	/**
	 * 初始化方法，只会执行一次
	 */
	public void init(FilterConfig config) throws ServletException {
		this.code = config.getInitParameter("code");
	}

}
