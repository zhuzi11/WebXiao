<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs.js"></script>
</head>
<body>
	<form class="form-horizontal" role="form"  action="${pageContext.request.contextPath}/UserServlet?method=register" method="post">
	  <input type="hidden" name="no" value="${requestScope.user.no}" />
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">用户名</label>
	    <div class="col-sm-10 col-lg-3 col-md-6 col-xs-12">
	      <input type="text" class="form-control" id="name" name="name"  value="${requestScope.user.name}" placeholder="请输入用户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">密码</label>
	    <div class="col-sm-10 col-lg-3 col-md-6 col-xs-12">
	      <input type="password" class="form-control" id="pwd" name="pwd" value="${requestScope.user.pwd}" placeholder="请输入密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">手机</label>
	    <div class="col-sm-10 col-lg-3 col-md-6 col-xs-12">
	      <input type="text" class="form-control" id="phone" name="phone" value="${requestScope.user.phone}" placeholder="请输入手机号码">
	    </div>
	  </div>
	  <div class="form-group">
	  	<label class="col-sm-2 control-label">性别</label>
		<div class="col-sm-10">
			<div class="radio3 radio-inline">
				<input type="radio" id="radio4" name="sex" value="男" <c:if test="${requestScope.user.sex=='男'}">checked="checked"</c:if>   >
				<label for="radio4"> 男 </label>
			</div>
			<div class="radio3 radio-inline">
				<input type="radio" id="radio5" name="sex" value="女" <c:if test="${requestScope.user.sex=='女'}">checked="checked"</c:if>>
				<label for="radio5"> 女 </label>
			</div>
		</div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">提交</button>
	    </div>
	  </div>
	</form>
</body>
</html>