<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
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
	<form class="form-horizontal" role="form"  action="${pageContext.request.contextPath}/UserServlet?method=login" method="post">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">用户名</label>
	    <div class="col-sm-10 col-lg-3 col-md-6 col-xs-12">
	      <input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">密码</label>
	    <div class="col-sm-10 col-lg-3 col-md-6 col-xs-12">
	      <input type="text" class="form-control" id="pwd" name="pwd" placeholder="请输入密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">登录</button>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
	    </div>
	  </div>
	</form>
</body>
</html>