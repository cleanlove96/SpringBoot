
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
img{
				
				position: relative;
				top: -90%;
				
				width:40%;
				height:40%;
				border-radius:80%;
			}
</style>
<meta name="description" content="xxxxx">
<meta name="author" content="xxxxx">
<meta name="keyword" content="xxxxx">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>教务管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>asset/css/bootstrap.min.css">
<!-- plugins -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>asset/css/plugins/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>asset/css/plugins/simple-line-icons.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>asset/css/plugins/animate.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>asset/css/plugins/icheck/skins/flat/aero.css"/>
<link href="<%=basePath%>asset/css/style.css" rel="stylesheet">
</head>
<body id="mimin" class="dashboard form-signin-wrapper">
<div class="container">
  <form class="form-signin" action="<%=basePath%>userController/logindd.do">
    <div class="panel periodic-login"> <span class="atomic-number">V3.0</span>
      <div class="panel-body text-center">
      <font color="red">${loginError}</font>
        <h1 class="atomic-symbol"><img src="<%=basePath%>images/logo1.jpg" width="30%" alt=""></h1>
        <!-- <p class="atomic-mass">嘻嘻嘻嘻嘻嘻</p>
        <p class="element-name">哈哈哈哈</p> -->
        <i class="icons icon-arrow-down"></i>
        <div class="form-group form-animate-text" style="margin-top:40px !important;">
          <input type="text" class="form-text" name="loginName" required>
          <span class="bar"></span>
          <label>账号</label>
        </div>
        <div class="form-group form-animate-text" style="margin-top:40px !important;">
          <input type="password" class="form-text" name="password" required>
          <span class="bar"></span>
          <label>密码</label>
        </div>
        <label class="pull-left">
          <input type="checkbox" class="icheck pull-left" name="checkbox1"/>
          记住密码 </label>
        <input type="submit" class="btn col-md-12" value="登 录"/>
      </div>
      <div class="text-center" style="padding:5px;"> 版权所有：中国成都 </div>
    </div>
  </form>
</div>

<script src="<%=basePath%>asset/js/main.js"></script> 

</body>
</html>