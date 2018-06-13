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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>密码修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>personController/pwdUpdate.do">  
      <input type="hidden" name="userId" value="${USER.userId}">
      <div class="form-group">
        <div class="label">
          <label>登录名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  value="${USER.loginName}" name="loginName" disabled/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>旧密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" value="" name="password" data-validate="required:请输入旧密码" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" value="" id="password1" name="password1" data-validate="required:请输入新密码" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" value="" id="password2" name="password2" data-validate="required:请输入新密码" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="return validate_pwd()">确定</button>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
        	<div id="msg">${msg}</div>
        </div>
      </div>
    </form>
    
  </div>
</div>
<script type="text/javascript">
	function validate_pwd(){
		if($("#password1").val()==$("#password2").val()){
			return true;
		}else{
			confirm("无法匹配新密码，请重新确认");
			return false;
		}
	}
	$(function(){
		$("input[type='password']").focus(function (){
			$("#msg").html("");
		});
	})
	
</script>
</body>
</html>