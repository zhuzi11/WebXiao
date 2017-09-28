package com.xiangzone.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiangzone.biz.UsersBiz;
import com.xiangzone.biz.impl.UsersBizImpl;
import com.xiangzone.entity.Users;

public class UserServlet extends BaseServlet {

	private UsersBiz biz = new UsersBizImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String index(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Users user = (Users) request.getSession().getAttribute("user");
		List<Users> list = biz.queryAll(user.getNo());//调用业务逻辑的方法，获取所有的用户信息
		request.setAttribute("user", list);//将list保存至request作用域
		return "index.jsp";
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		if(name != null || pwd != null){
			Users user = biz.login(name, pwd);//根据用户名和密码查询用户
			if (user != null) {	//如果user为空，说明用户名或密码错误，否则登录成功
				session.setAttribute("user", user);//将登录成功的用户保存到session中
				response.sendRedirect("UserServlet?method=index");//重定向到IndexServlet
			}else{
				response.sendRedirect("login.jsp");
			}
		
		}else{
			//如果用户名或密码为空，则将页面重定向到登录页面
			response.sendRedirect("login.jsp");
		}
		return null;
	}
	
	public String register(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		//request.getParameterValues("sex");	//复选框用这个方法
		
		//根据str_userId判断当前操作时添加还是修改
		if (null == no || no.equals("")) {//添加
			Users user = new Users(0, name, pwd, phone, sex);
			biz.insert(user);
			response.sendRedirect("login.jsp");//重定向到登录页面
		}else{
			//修改
			Users users = new Users(Integer.valueOf(no), name, pwd, phone, sex);
			biz.update(users);
			response.sendRedirect("UserServlet?method=index");//重定向到首页
		}
		return null;
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		if (null == request.getParameter("no")) {
			//说明没有指定需要删除的用户编号
			response.sendRedirect("UserServlet?method=index");
			return null;//不执行以下代码
		}
		
		int no = Integer.valueOf(request.getParameter("no"));//从request中获取需要删除的用户的ID
		biz.delete(new Users(no, null, null, null, null));
		response.sendRedirect("UserServlet?method=index");//无论删除成功与否，都应该返回所有信息的页面
		return null;
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String no = request.getParameter("no");
		if (null == no) {
			response.sendRedirect("UserServlet?method=index");
		}
		int xno = Integer.valueOf(no);//需要修改的用户的编号
		Users user = new Users();
		user.setNo(xno);
		user = biz.queryByno(user);
		if (user != null) {
			request.setAttribute("user", user);
			return "register.jsp";//页面转发至注册页面
		}else{
			response.sendRedirect("UserServlet?method=index");//如果没有这个用户，则重定向到首页
			return null;
		}
	}
	
	public String loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.getSession().invalidate();//设置session失效
		response.sendRedirect("login.jsp");//重定向到登录页面
		return null;
	}
}
