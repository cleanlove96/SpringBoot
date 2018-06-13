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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>角色添加</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>roleController/roleAdd.do">
    <div class="form-group">
        <div class="label">
          <label>角色ID：</label>
        </div>
        <div class="field">
          <input id="roleId" type="text" class="input w50" value="" name="roleId" data-validate="required:请输入角色Id" />
          <span id="validateRid" style="color:red;line-height: 30px"></span>
          <div class="tips"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>角色名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="roleName" data-validate="required:请输入角色名" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>角色描述：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="roleDesc" data-validate="required:请输入角色描述" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
<script>
	$("#roleId").blur(function(){
		var roleId=$("#roleId").val();
		if(roleId!=null){
			$.ajax({
				type:"post",
				url:"<%=basePath%>roleController/validateRID.do",
				async:false,
				data:{"roleId":roleId},
				success:function(data){
					if(data=="error"){
						/* $("#roleId").val(""); */
						$("#validateRid").text("此id已存在,请修改！"); 
					}else{
						$("#validateRid").text("");
					}
				},
				error:function(data){}
			});
		}
	});
</script>
</html>