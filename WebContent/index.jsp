<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
	<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css" />
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
  </head>
  
  <body>
  		<!-- 
  			items:需要迭代的集合
  			var:集合当前的元素对象
  			${requestScope.list}:EL表达式
  			
  			for(Users item : list){
  			
  			}
  		-->
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-12">
    				<ol class="breadcrumb">
					    <li class="active">欢迎<span>${sessionScope.user.name}</span>登录</li>
					    <li>
					    	<a href="${pageContext.request.contextPath}/UserServlet?method=loginOut">退出</a>
					    </li>
					</ol>
    			</div>
    		</div>
    		<div class="table-responsive">
    			<table class="table">
    				<thead>
    					<tr>
    						<th>编号</th>
    						<th>登录名</th>
    						<th>手机</th>
    						<th>性别</th>
    						<th>操作</th>
    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach items="${requestScope.user}" var="item">
    						<tr>
    							<td>${item.no}</td>
    							<td>${item.name}</td>
    							<td>${item.phone}</td>
    							<td>${item.sex}</td>
    							<td>
    								<a href="${pageContext.request.contextPath}/UserServlet?method=delete&no=${item.no}">删除</a>&nbsp;<a href="${pageContext.request.contextPath}/UserServlet?method=update&no=${item.no}">修改</a>
    							</td>
    						</tr>
				    	</c:forEach>
    				</tbody>
    			</table>
    		</div>
    	</div>
  </body>
</html>
