package com.xiangzone.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiangzone.util.StringUtil;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*
		 * 判断用户是否登录
		 * 判断session中是否含有user
		 * */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String path = req.getServletPath();
		
		if (path.lastIndexOf(".") != -1) {	//如果url地址包含.
			String endWith = path.substring(path.lastIndexOf("."));//.css  .js   .jpg  .png
			if (StringUtil.checkUrl(endWith)) {
				chain.doFilter(request, response);
				return;//如果当前请求的是css，js，jpg，png则放行请求，同时后面的代码不会执行
			}
		}
		if (path.equals("/login.jsp")) {
			chain.doFilter(request, response);
			return;
		}
		String method = request.getParameter("method");
		if (method != null && method.equals("login")) {
			chain.doFilter(request, response);
		}else{
			HttpSession session = req.getSession();
			Object user = session.getAttribute("user");
			if (null != user) {//说明用户登录了
				chain.doFilter(request, response);
				return;
			}else{
				//未登录
				String serverName = req.getServerName();//获取当前服务器IP地址
				int port = req.getServerPort();//获取端口号
				String contextPath = req.getContextPath();//当前项目名称
				//http://localhost:8080/webDemo3/
				String realPath = serverName + ":" + port + contextPath + "/login.jsp";
				resp.sendRedirect(realPath);
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
