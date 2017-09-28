package com.xiangzone.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");//获取需要访问servlet方法名
		if (method == null) {
			method = "index";//默认访问首页
		}
		
		Class<? extends BaseServlet> c = this.getClass();
		
		try {
			Method m = c.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			String url = (String) m.invoke(this, request,response);//需要转发的url地址
			if (null != url) {
				request.getRequestDispatcher(url).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String index(HttpServletRequest request,HttpServletResponse response){
		return null;
	}

}
