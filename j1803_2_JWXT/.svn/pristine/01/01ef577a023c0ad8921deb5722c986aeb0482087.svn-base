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
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<script src="<%=basePath%>resources/My97DatePicker/WdatePicker.js"></script>
<script>
   var check =function(id){
       var ele = document.getElementById(id);
        if(ele.value==''){
           alert('请选择角色');
        }
   }
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="<%=basePath%>userController/add.do">
				
				<div class="form-group">
					<div class="label">
						<label>登录名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="loginName"
							data-validate="required:请输入登录名" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>密码：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="password"
							data-validate="required:请输入密码" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>角色Id：</label>
					</div>
					<div class="field">
						<select name="roleId" class="input w50" id="list">
							<option value="">---请选择角色---</option>
							<c:forEach items="${rolelist }" var="role">
								<option value="${role.roleId }">${role.roleName }</option>
							</c:forEach>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				
				
				
				
				

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit" onclick = "check('list')">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>